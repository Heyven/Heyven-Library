package org.hrms.mapper;

import org.hrms.domain.EmployeeFiles;

public interface EmployeeFilesMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(EmployeeFiles record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(EmployeeFiles record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    EmployeeFiles selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(EmployeeFiles record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(EmployeeFiles record);
}