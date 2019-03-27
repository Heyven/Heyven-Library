package org.hrms.mapper;

import org.hrms.domain.Recruitment;

public interface RecruitmentMapper {
    /**
     *
     * @mbggenerated 2017-05-11
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-11
     */
    int insert(Recruitment record);

    /**
     *
     * @mbggenerated 2017-05-11
     */
    int insertSelective(Recruitment record);

    /**
     *
     * @mbggenerated 2017-05-11
     */
    Recruitment selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-11
     */
    int updateByPrimaryKeySelective(Recruitment record);

    /**
     *
     * @mbggenerated 2017-05-11
     */
    int updateByPrimaryKey(Recruitment record);
}