package org.hrms.mapper;

import org.hrms.domain.Department;

public interface DepartmentMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(Department record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(Department record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    Department selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(Department record);
}