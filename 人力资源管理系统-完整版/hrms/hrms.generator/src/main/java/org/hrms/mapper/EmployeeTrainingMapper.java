package org.hrms.mapper;

import org.hrms.domain.EmployeeTraining;

public interface EmployeeTrainingMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(EmployeeTraining record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(EmployeeTraining record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    EmployeeTraining selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(EmployeeTraining record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeyWithBLOBs(EmployeeTraining record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(EmployeeTraining record);
}