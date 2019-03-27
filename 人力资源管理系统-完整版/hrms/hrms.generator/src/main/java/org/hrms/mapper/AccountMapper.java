package org.hrms.mapper;

import org.hrms.domain.Account;

public interface AccountMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(Account record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(Account record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    Account selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeyWithBLOBs(Account record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(Account record);
}