package org.hrms.mapper;

import org.hrms.domain.EmployeeTransfer;

public interface EmployeeTransferMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(EmployeeTransfer record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(EmployeeTransfer record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    EmployeeTransfer selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(EmployeeTransfer record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeyWithBLOBs(EmployeeTransfer record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(EmployeeTransfer record);
}