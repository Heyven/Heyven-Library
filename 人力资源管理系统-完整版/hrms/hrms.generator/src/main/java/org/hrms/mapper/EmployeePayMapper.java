package org.hrms.mapper;

import org.hrms.domain.EmployeePay;

public interface EmployeePayMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(EmployeePay record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(EmployeePay record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    EmployeePay selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(EmployeePay record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(EmployeePay record);
}