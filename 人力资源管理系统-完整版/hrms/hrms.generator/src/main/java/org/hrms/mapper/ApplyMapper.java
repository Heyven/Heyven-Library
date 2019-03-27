package org.hrms.mapper;

import org.hrms.domain.Apply;

public interface ApplyMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(Apply record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(Apply record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    Apply selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(Apply record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(Apply record);
}