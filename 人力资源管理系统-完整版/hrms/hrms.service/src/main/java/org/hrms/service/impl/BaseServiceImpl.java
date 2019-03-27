package org.hrms.service.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.beanutils.BeanUtils;
import org.hrms.common.annotation.AutoGeneration;
import org.hrms.common.annotation.MD5;
import org.hrms.common.annotation.OneToMany;
import org.hrms.common.annotation.OneToManyProperty;
import org.hrms.common.annotation.UniqueValue;
import org.hrms.common.annotation.UpdateAttribute;
import org.hrms.common.annotation.UpdateAttributeProperty;
import org.hrms.common.context.SpringContext;
import org.hrms.common.context.State;
import org.hrms.common.context.SystemConfiguraction;
import org.hrms.common.response.Response;
import org.hrms.common.search.Attribute;
import org.hrms.common.search.Pageing;
import org.hrms.service.IBaseService;
import org.hrms.storage.AccountAuthorityReadWrite;
import org.hrms.storage.AccountReadWrite;
import org.hrms.storage.AuthorityReadWrite;
import org.hrms.storage.DepartmentReadWrite;
import org.hrms.storage.EmployeeTransferReadWrite;
import org.hrms.storage.IDatabaseReadWrite;
import org.hrms.util.MD5Util;
import org.hrms.util.ObjectUtil;
import org.hrms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.collect.Lists;

/**
 * 基础业务接口实现类(CURD)
 * @author VIC
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 * @param <E>
 */
public abstract class BaseServiceImpl<T,ID,R> implements IBaseService<T,ID,R> {

	@Autowired
	protected IDatabaseReadWrite<T, ID> databaseReadWrite;
	@Autowired
	protected AuthorityReadWrite authorityReadWrite;
	@Autowired
	protected AccountReadWrite accountReadWrite;
	@Autowired
	protected AccountAuthorityReadWrite accountAuthorityReadWrite;
	@Autowired
	protected DepartmentReadWrite departmentReadWrite;
	@Autowired
	protected EmployeeTransferReadWrite employeeTransferReadWrite;
	@Autowired
	protected SystemConfiguraction systemConfiguraction;
	
	/**
	 * 创建T泛型实例对象
	 * 
	 * @return 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("hiding")
	protected <T> T getTInstnce() throws InstantiationException, IllegalAccessException {
		// 获取泛型类型
		@SuppressWarnings("unchecked")
		Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		// 创建实例对象
		return (T)entityClass.newInstance();
	}
	
	@SuppressWarnings("hiding")
	protected <ID> ID getIDInstnce(String id) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// 获取泛型类型
		@SuppressWarnings("unchecked")
		Class <ID> entityClass = (Class <ID>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		Constructor<ID> constructor = entityClass.getConstructor(String.class);
		// 创建实例对象
		return constructor.newInstance(id);
	}
	
	/**
	 * 获取请求对象中被注解的属性名称及属性值集合
	 * 1. 需要验证唯一性的属性需要使用UniqueValue注解标注
	 * 2. 需要实现一对多映射关系的属性
	 * 
	 * @param r 输入对象
	 * @param annotationType 注解类型
	 * @param returnType 返回类型
	 * @return List
	 */
	protected <RT> List<RT> getAnnotationFields(R r, Class<? extends Annotation> annotationType, Class<RT> returnType){

		//返回注解属性对象集合
		List<RT> annotationProperties = new ArrayList<RT>();
		try{
			// 获取对象的所有属性字段
			Field[] fields = r.getClass().getDeclaredFields();
	        for(Field field : fields){ 
	        	
	        	// 判断属性是否被UniqueValue注解,如注解则添加记录到集合中
	            boolean fieldHasAnno = field.isAnnotationPresent(annotationType);  
	            
	            if(fieldHasAnno){
	            	// 设置字段为可以访问(如果是private)
	            	field.setAccessible(true); 
	            	// 获取字段的值
	            	Object value = field.get(r);
	            	// 获取字段的名字
	            	String name = field.getName();
	            	
	            	// 获取字段指定类型的注解对象
	            	Annotation annotation = field.getAnnotation(annotationType);
	            	try{
	            		// 创建返回对象
	            		RT rt = returnType.newInstance();
	            		// 唯一注解
	            		if(annotation instanceof UniqueValue){
	            			// 通过反射调用注解对象的方法获取注解的属性值
		            		Object object = annotation.getClass().getMethod("field").invoke(annotation);
		            		name = null != object && object.toString().length() > 0 ? object.toString() : name;
		            		
	            		}else if(annotation instanceof OneToMany){
	            			// 一对多注解
	            			// 通过反射调用注解对象的方法获取注解的属性值
			            	String mapper = annotation.getClass().getMethod("mapper").invoke(annotation).toString();
		            		mapper = StringUtil.isNotEmpty(mapper) ? mapper : null;
		            		
		            		String domain = annotation.getClass().getMethod("domain").invoke(annotation).toString();
		            		domain = StringUtil.isNotEmpty(domain) ? domain : null;
		            		
		            		String oneKey = annotation.getClass().getMethod("oneKey").invoke(annotation).toString();
		            		String manyKey = annotation.getClass().getMethod("manyKey").invoke(annotation).toString();
		            		
		            		BeanUtils.setProperty(rt, "mapper", mapper);
		            		BeanUtils.setProperty(rt, "domain", domain);
		            		BeanUtils.setProperty(rt, "oneKey", oneKey);
		            		BeanUtils.setProperty(rt, "manyKey", manyKey);
	            		}else if(annotation instanceof UpdateAttribute){
	            			// 通过反射调用注解对象的方法获取注解的属性值
			            	String mapper = annotation.getClass().getMethod("mapper").invoke(annotation).toString();
		            		mapper = StringUtil.isNotEmpty(mapper) ? mapper : null;
		            		BeanUtils.setProperty(rt, "mapper", mapper);
		            		
		            		String[] srcAttributes = (String[]) annotation.getClass().getMethod("srcAttributes").invoke(annotation);
		            		String[] destAttributes = (String[]) annotation.getClass().getMethod("destAttributes").invoke(annotation);
		            		BeanUtils.setProperty(rt, "srcAttributes", srcAttributes);
		            		BeanUtils.setProperty(rt, "destAttributes", destAttributes);
	            		}
	            		BeanUtils.setProperty(rt, "name", name);
	            		BeanUtils.setProperty(rt, "value", value);
	            		// 将注解属性对象添加到集合
		            	annotationProperties.add(rt);
	            	}catch (Exception e) {
	            		e.printStackTrace();
					}
	            }  
	        }  
		}catch (Exception e) {
			e.printStackTrace();
		}
        return annotationProperties;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response insert(R r) {
		
		Response response = Response.getInstance();
		try{
			// 获取在插入前需要验证唯一性的字段,验证该字段的值的唯一性
			List<Attribute> annotationProperties = getAnnotationFields(r, UniqueValue.class, Attribute.class);
			if(annotationProperties.size() > 0){
				for(Attribute annotationProperty : annotationProperties){
					// 循环查询需要验证唯一性的字段值是否存在,如果存在则返回提示
					if(null != databaseReadWrite.selectByAttribute(annotationProperty)){
						// 设置国际化消息KEY并返回
						response.setMessage(annotationProperty.getName() + ".exists");
						return response;
					}
				}
			}
			
			// MD5加密的属性字段
			List<Attribute> md5Properties = getAnnotationFields(r, MD5.class, Attribute.class);
			if(annotationProperties.size() > 0){
				for(Attribute md5Property : md5Properties){
					if(ObjectUtil.isNotEmpty(md5Property.getValue()) && StringUtil.isNotEmpty(md5Property.getValue().toString())){
						BeanUtils.setProperty(r, md5Property.getName(), MD5Util.encryptMD5(md5Property.getValue().toString()));
					}
				}
			}
			
			// 自动赋值的属性字段(默认赋值32位UUID)
			List<Attribute> autoAttributes = getAnnotationFields(r, AutoGeneration.class, Attribute.class);
			if(autoAttributes.size() > 0){
				for(Attribute autoAttribute : autoAttributes){
					BeanUtils.setProperty(r, autoAttribute.getName(), UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
				}
			}
			
			// 动态更新被其他对象改变的对象属性值(例如员工调动)
			List<UpdateAttributeProperty> updateAttributes = getAnnotationFields(r, UpdateAttribute.class, UpdateAttributeProperty.class);
			if(updateAttributes.size() > 0){
				for(UpdateAttributeProperty updateAttribute : updateAttributes){
					IDatabaseReadWrite tmpMapper = SpringContext.getBean(StringUtil.firstLowerCase(updateAttribute.getMapper()), IDatabaseReadWrite.class);
					T t = (T)tmpMapper.selectByPrimaryKey(updateAttribute.getValue());
					for(int i = 0; i < updateAttribute.getSrcAttributes().length; i++){
						String srcAttributeName = updateAttribute.getSrcAttributes()[i];
						String destAttributeName = updateAttribute.getDestAttributes()[i];
						BeanUtils.setProperty(t, destAttributeName, BeanUtils.getArrayProperty(r, srcAttributeName));	
					}
					tmpMapper.updateByPrimaryKey(t);
				}
			}
			
			// 如验证唯一性通过则进行插入数据操作
			// 通过泛型构建一个实体对象
			T t = getTInstnce();
			// 将Request对象的属性值复制到实体对象
			BeanUtils.copyProperties(t, r);
			// 初始化创建时间,更新时间,状态
			long currentTime = System.currentTimeMillis();
			BeanUtils.setProperty(t, "createTime", currentTime);
			BeanUtils.setProperty(t, "updateTime", currentTime);
			BeanUtils.setProperty(t, "state", State.ENABLED.toString());
			// 执行插入
			int insert  = databaseReadWrite.insert(t);
			
			// 获取ID
			Object object = BeanUtils.getProperty(t, "id");
			// 插入一对多关系映射数据
			// 获取被注解的一对多关系的属性名称和值
			List<OneToManyProperty> oneToManyPropertys = getAnnotationFields(r, OneToMany.class, OneToManyProperty.class);
			// 构建一对多关系的数据集
			for(OneToManyProperty oneToManyProperty : oneToManyPropertys){
				if(ObjectUtil.isNotEmpty(oneToManyProperty.getValue()) && StringUtil.isNotEmpty(oneToManyProperty.getValue().toString())){
					// 获取mapper接口
					IDatabaseReadWrite tmpMapper = SpringContext.getBean(StringUtil.firstLowerCase(oneToManyProperty.getMapper()), IDatabaseReadWrite.class);
					// 添加新的一对多数据
					insertOneToManyData(object, oneToManyProperty, tmpMapper);
				}
			}
			
			if(insert > 0){
				// 成功
				response.setState(true);
				response.setMessage("add.success");
				Method[] methods = r.getClass().getMethods();
				for(Method method : methods){
					if(method.getName().equals("setId")){
						ID id = getIDInstnce(object.toString());
						method.invoke(r,id);
						break;
					}
				}
			}else{
				// 失败
				response.setMessage("add.fail");
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("system.error");
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Response deleteByPrimaryKey(R r) {
		
		Response response = Response.getInstance();
		try{
			String[] ids = BeanUtils.getProperty(r, "ids").split(",");
			// 获取被注解的一对多关系的属性名称和值
			List<OneToManyProperty> oneToManyPropertys = getAnnotationFields(r, OneToMany.class, OneToManyProperty.class);
			// 构建一对多关系的数据集
			for(OneToManyProperty oneToManyProperty : oneToManyPropertys){
				if(ObjectUtil.isNotEmpty(oneToManyProperty.getValue()) && StringUtil.isNotEmpty(oneToManyProperty.getValue().toString())){
					// 获取mapper接口
					IDatabaseReadWrite tmpMapper = SpringContext.getBean(StringUtil.firstLowerCase(oneToManyProperty.getMapper()), IDatabaseReadWrite.class);
					// 删除原来一对多数据
					for(String id : ids){
						deleteOneToManyData(id, oneToManyProperty, tmpMapper);
					}
				}
			}
			
			int delete = 0;
			// 此处考虑使用in删除
			for(String temp : ids){
				ID id = getIDInstnce(temp);
				delete = databaseReadWrite.deleteByPrimaryKey(id);
			}
			
			if(delete > 0){
				// 删除对象成功
				response.setState(true);
				response.setMessage("delete.success");
			}else{
				// 删除对象失败
				response.setMessage("delete.fail");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("system.error");
		}
		return response;
	}

	public Response updateByPrimaryKey(R r) {
		
		return updateByPrimaryKeySelective(r);
	}
	
	@SuppressWarnings("rawtypes")
	public Response updateByPrimaryKeySelective(R r) {
		Response response = Response.getInstance();
		try{
			// 获取被注解的一对多关系的属性名称和值
			List<OneToManyProperty> oneToManyPropertys = getAnnotationFields(r, OneToMany.class, OneToManyProperty.class);
			// 构建一对多关系的数据集
			for(OneToManyProperty oneToManyProperty : oneToManyPropertys){
				if(ObjectUtil.isNotEmpty(oneToManyProperty.getValue()) && StringUtil.isNotEmpty(oneToManyProperty.getValue().toString())){
					// 获取mapper接口
					IDatabaseReadWrite tmpMapper = SpringContext.getBean(StringUtil.firstLowerCase(oneToManyProperty.getMapper()), IDatabaseReadWrite.class);
					ID id = getIDInstnce(BeanUtils.getProperty(r, "id"));
					// 删除原来一对多数据
					deleteOneToManyData(id, oneToManyProperty, tmpMapper);
					// 添加新的一对多数据
					insertOneToManyData(id, oneToManyProperty, tmpMapper);
				}
			}
			
			// 通过泛型构建一个实体对象
			T t = getTInstnce();
			// 将Request对象的属性值复制到实体对象
			BeanUtils.copyProperties(t, r);
			// 更新前根据ID查询对象是否存在
			ID id = getIDInstnce(BeanUtils.getProperty(r, "id"));
			// 设置更新时间
			BeanUtils.setProperty(t, "updatetime", System.currentTimeMillis());
			if(null != databaseReadWrite.selectByPrimaryKey(id)){
				// 对象存在执行更新
				int update  = databaseReadWrite.updateByPrimaryKey(t);
				if(update > 0){
					// 成功
					response.setState(true);
					response.setMessage("update.success");
				}else{
					// 失败
					response.setMessage("update.fail");
				}
			}else{
				// 对象未存在
				response.setMessage("not.exists");
			}
		}catch (Exception e) {
			// 插入错误,系统异常
			e.printStackTrace();
			response.setMessage("system.error");
		}
		return response;
	}

	/**
	 * 添加新的映射数据
	 * 
	 * @param id
	 * @param oneToManyProperty
	 * @param tmpMapper
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void insertOneToManyData(Object id, OneToManyProperty oneToManyProperty, IDatabaseReadWrite tmpMapper)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 将多方的id使用逗号分隔
		String[] values = oneToManyProperty.getValue().toString().split(",");
		// 构建关系映射对象集合
		List<Object> instances = Lists.newArrayList();
		// 获取映射对象类型
		Class clz = Class.forName(oneToManyProperty.getDomain());
		// 构建关系映射对象并初始化值然后添加到集合
		for(String value : values){
			Object instance = clz.newInstance();
			BeanUtils.setProperty(instance, oneToManyProperty.getOneKey(), id);
			BeanUtils.setProperty(instance, oneToManyProperty.getManyKey(), getIDInstnce(value));
			instances.add(instance);
		}
		// 重新添加新的关系映射数据
		tmpMapper.batchInsert(instances);
	}

	/**
	 * 根据属性删除映射关系数据
	 * @param value
	 * @param oneToManyProperty
	 * @param tmpMapper
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	private void deleteOneToManyData(Object value, OneToManyProperty oneToManyProperty, IDatabaseReadWrite tmpMapper)
			throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// 构建删除属性
		Attribute annotationProperty = Attribute.getInstance();
		annotationProperty.setName(oneToManyProperty.getOneKey());
		annotationProperty.setValue(value);
		// 删除所有映射数据
		tmpMapper.deleteByAttribute(annotationProperty);
	}

	public Response selectByPrimaryKey(ID id) {
		
		// 执行查询对象
		Response response = Response.getInstance();
		T t = databaseReadWrite.selectByPrimaryKey(id);
		if(null != t){
			// 查询到对象
			response.setState(true);
			response.setData(t);
		}else{
			// 未查询到对象
			response.setMessage("not.exists");
		}
		return response;
	}
	
	public Response selectByProperty(R r) {
		List<Attribute> annotationProperties = getAnnotationFields(r, UniqueValue.class, Attribute.class);
		return selectByProperty(annotationProperties.get(0));
	}
	
	private Response selectByProperty(Attribute attribute) {
		Response response = Response.getInstance();
		try{
			if(null != attribute){
				T t = databaseReadWrite.selectByAttribute(attribute);
				if(null != t){
					response.setData(t);
					response.setState(true);
				}else{
					response.setMessage(attribute.getName()+".not.exists");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("system.error");
		}
		return response;
	}

	public Response existsByProperty(R r) {
		Response response = selectByProperty(r);
		if(response.getState()){
			response.setData(null);
			response.setMessage("value.exists");
		}
		return response;
	}

	public Response pageingSearch(Pageing pageing) {
		Response response = Response.getInstance();
		try{
			// 1. 获取总行数并计算总页数
			// 如查询关键字不为空则设置为模糊匹配条件
			if(null != pageing.getKeywords() && StringUtil.isNotEmpty(pageing.getKeywords().getValue().toString())){
				pageing.getKeywords().setValue("%" + pageing.getKeywords().getValue() + "%");
				pageing.getKeywords().setLikePattern(true);
			}else{
				pageing.getKeywords().setValue(null);
			}
			int sumLine = databaseReadWrite.countByAttribute(pageing.getKeywords());
			pageing.calculatorSumPage(sumLine);
			
			// 计算当前页码
			pageing.calculatorCurrentPage();
			
			// 执行查询
			List<T> data = databaseReadWrite.pageingSearch(pageing);
			response.setData(data);
			response.setPageing(pageing);
			response.setState(true);
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("system.error");
		}
		return response;
	}

	public int batchInsert(List<T> ts) {
		try {
			long currentTime = System.currentTimeMillis();
			for(T t : ts){
				BeanUtils.setProperty(t, "createTime", currentTime);
				BeanUtils.setProperty(t, "updateTime", currentTime);
				BeanUtils.setProperty(t, "state", State.ENABLED.toString());
			}
			return databaseReadWrite.batchInsert(ts);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Response deleteInByPrimaryKey(List<ID> ids) {
		
		Response response = Response.getInstance();
		int delete = databaseReadWrite.deleteInByPrimaryKey(ids);
		if(delete > 0){
			response.setState(true);
			response.setMessage("delete.success");
		}else{
			response.setMessage("delete.fail");
		}
		return response;
	}

}
