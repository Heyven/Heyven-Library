package org.hrms.service;

import java.util.List;

import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.springframework.stereotype.Service;

/**
 * 基础业务接口(CURD)
 * @author VIC
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 */
@Service
public interface IBaseService<T,ID,R> {

    /**
     * 插入对象
     * @param r
     * @return Response
     */
    Response insert(R r);
    
    /**
     * 批量插入对象
     * @param ts
     * @return
     */
    int batchInsert(List<T> ts);
    
	/**
	 * 根据ID删除对象
	 * @param ids
	 * @return
	 */
	Response deleteInByPrimaryKey(List<ID> ids);
    
    /**
     * 根据ID删除对象
     * @param r
     * @return Response
     */
    Response deleteByPrimaryKey(R r);
    
    /**
     * 根据主键更新对象
     * @param r
     * @return Response
     */
    Response updateByPrimaryKey(R r);
    
    /**
     * 根据主键更新对象
     * @param r
     * @return Response
     */
    Response updateByPrimaryKeySelective(R r);

    /**
     * 根据主键查询对象
     * @param id
     * @return Response
     */
    Response selectByPrimaryKey(ID id);
    
    /**
     * 根据属性查询对象
     * @param r
     * @return Response
     */
    Response selectByProperty(R r);
    
    /**
     * 根据属性判断对象是否存在
     * @param r
     * @return Response
     */
    Response existsByProperty(R r);

    /**
     * 分页查询
     * 
     * @param pageing
     * @return Response
     */
    Response pageingSearch(Pageing pageing);
	
}
