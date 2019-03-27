package org.hrms.mapper;

import org.hrms.domain.EmployeeContract;

public interface EmployeeContractMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(EmployeeContract record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(EmployeeContract record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    EmployeeContract selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(EmployeeContract record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(EmployeeContract record);
}