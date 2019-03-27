package org.hrms.storage;

import java.util.List;

import org.hrms.common.search.Attribute;
import org.hrms.common.search.Pageing;


/**
 * 
 * @author VIC
 *
 * @param <T> 实体类类类型
 * @param <ID> 实体类的ID类型
 */
public interface IDatabaseReadWrite<T,ID> {

    /**
     * 插入对象
     * @param t
     * @return
     */
    int insert(T t);
    
    /**
     * 插入对象
     * @param t
     * @return
     */
    int insertSelective(T t);
    
    /**
     * 批量插入对象
     * @param ts
     * @return
     */
    int batchInsert(List<T> ts);
    
	/**
	 * 根据主键删除对象
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(ID id);
    
	/**
	 * 根据主键批量删除对象
	 * @param ids
	 * @return
	 */
	int deleteInByPrimaryKey(List<ID> ids);

	/**
	 * 根据属性删除对象
	 * @param attribute
	 * @return
	 */
	int deleteByAttribute(Attribute attribute);
	
    /**
     * 根据主键更新对象
     * @param t
     * @return
     */
    int updateByPrimaryKey(T t);
	
    /**
     * 根据主键查询对象
     * @param id
     * @return
     */
    T selectByPrimaryKey(ID id);
    
	/**
	 * 根据属性统计对象记录数量
	 * 
	 * @param attribute
	 * @return
	 */
    int countByAttribute(Attribute attribute);

    /**
     * 查询对象
     * @param attribute
     * @return
     */
    T selectByAttribute(Attribute attribute);
    
    /**
     * 查询对象集
     * @param attribute
     * @return
     */
    List<T> selectByAttributes(Attribute attribute);

    /**
     * 分页查询
     * 
     * @param pageing
     * @return List
     */
	List<T> pageingSearch(Pageing pageing);
	
}
