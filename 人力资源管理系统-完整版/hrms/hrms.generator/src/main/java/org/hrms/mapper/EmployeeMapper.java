package org.hrms.mapper;

import org.hrms.domain.Employee;

public interface EmployeeMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(Employee record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(Employee record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(Employee record);
}