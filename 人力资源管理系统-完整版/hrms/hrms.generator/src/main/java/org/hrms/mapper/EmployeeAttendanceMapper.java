package org.hrms.mapper;

import org.hrms.domain.EmployeeAttendance;

public interface EmployeeAttendanceMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(EmployeeAttendance record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(EmployeeAttendance record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    EmployeeAttendance selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(EmployeeAttendance record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeyWithBLOBs(EmployeeAttendance record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(EmployeeAttendance record);
}