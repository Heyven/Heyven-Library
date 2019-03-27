package org.hrms.mapper;

import org.hrms.domain.Authority;

public interface AuthorityMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(Authority record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(Authority record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    Authority selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(Authority record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(Authority record);
}