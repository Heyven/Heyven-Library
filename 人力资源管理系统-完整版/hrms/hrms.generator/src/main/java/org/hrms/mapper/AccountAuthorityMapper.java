package org.hrms.mapper;

import org.hrms.domain.AccountAuthority;

public interface AccountAuthorityMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(AccountAuthority record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(AccountAuthority record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    AccountAuthority selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(AccountAuthority record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(AccountAuthority record);
}