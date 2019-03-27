package org.hrms.web.controller;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;
import org.apache.commons.beanutils.BeanUtils;
import org.hrms.common.context.SpringContext;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.service.IAccountService;
import org.hrms.service.IAuthorityService;
import org.hrms.service.IBaseService;
import org.hrms.service.IEmployeeTransferService;
import org.hrms.util.ObjectUtil;
import org.hrms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基础控制器
 * 
 * @author VIC
 *
 */
public class BaseController<T, ID, R> extends CommonController {
	
	@Autowired  
	private HttpSession session; 
	@Resource
	IAuthorityService authorityService;
	@Resource
	IAccountService accountService;
	@Resource
	IEmployeeTransferService employeeTransferService;
	
	@Autowired
	protected IBaseService<T,ID,R> baseService;

	/**
	 * 根据泛型类型获取具体的Service
	 */
	public IBaseService<T, ID, R> getBaseService() {
		@SuppressWarnings("unchecked")
		Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return SpringContext.getBean(StringUtil.firstLowerCase(entityClass.getSimpleName()) + "ServiceImpl", IBaseService.class);
	}
	
	protected Response upload(CommonsMultipartFile file, HttpServletRequest request,String catalog){
		
		Response response = Response.getInstance();
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize()/1024+1;
		log.debug("fileName: " + fileName + " Size: " + fileSize);
		// 构建文件存储绝对路径
		String filePath = request.getSession().getServletContext().getRealPath(systemConfiguraction.upload) 
				+ File.separator + catalog + File.separator + fileName;
		log.debug("filePath: " + filePath);
		String path = systemConfiguraction.upload + File.separator + catalog + File.separator + fileName;
		try {
			file.getFileItem().write(new File(filePath));
			response.setState(true);
			response.setData(path);
			response.setMessage(getMessage("upload.success"));
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(getMessage("upload.fail"));
		}
		return response;
	}
	
	/**
	 * 通用插入对象
	 * @param r
	 * @return
	 */
	protected Response baseInsert(R r){
		setOperateCreator(r);
		Response response = baseService.insert(r);
		getMessage(response);
		return response;
	}
	
	private void setOperateCreator(R r) {
		String creator = "system";
		Object object = session.getAttribute("currentAccount");
		if(ObjectUtil.isNotEmpty(object)){
			creator = object.toString();
		}
		try {
			BeanUtils.setProperty(r, "creator", creator);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通用根据属性查询对象是否存在
	 * @param r
	 * @return
	 */
	protected Response baseExists(R r){
		Response response = baseService.existsByProperty(r);
		getMessage(response);
		return response;
	}
	
	/**
	 * 通用根据ID查找对象
	 * @param id
	 * @return
	 */
	protected ModelAndView baseFind(ID id){
		Response response = baseService.selectByPrimaryKey(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", response.getData());
		return modelAndView;
	}
	
	/**
	 * 通用分页查询对象
	 * @param newPageing
	 * @param request
	 * @return
	 */
	protected Response baseSearch(Pageing newPageing, HttpServletRequest request){
		// 从session中获取查询分页对象
		Object object = request.getSession().getAttribute("pageing");
		Pageing pageing = null;
		if(null != object){
			// 如果查询分页对象存在则转换类型为Pageing对象
			pageing = (Pageing)object;
			pageing.setOperate(newPageing.getOperate());
			pageing.setKeywords(newPageing.getKeywords());
		}else{
			pageing = newPageing;
		}
		// 执行分页查询
		Response response = baseService.pageingSearch(pageing);
		// 保存分页对象
		request.getSession().setAttribute("pageing", response.getPageing());
		return response;
	}
	
	/**
	 * 通用根据ID删除对象
	 * @param r
	 * @return
	 */
	protected Response baseDelete(R r){
		Response response = baseService.deleteByPrimaryKey(r);
		getMessage(response);
		return response;
	}
	
	/**
	 * 通用根据ID更新对象
	 * @param r
	 * @return
	 */
	protected Response baseSave(R r){
		setOperateCreator(r);
		Response response = baseService.updateByPrimaryKeySelective(r);
		getMessage(response);
		return response;
	}
	
	/**
	 * 获取国际化资源
	 * @param response
	 */
	protected void getMessage(Response response){
		if(StringUtil.isNotEmpty(response.getMessage())){
			// 如果有国际化KEY则获取国际化资源
			response.setMessage(getMessage(response.getMessage()));
		}
	}

}
