package org.hrms.mapper;

import org.hrms.domain.TrainingProject;

public interface TrainingProjectMapper {
    /**
     *
     * @mbggenerated 2017-05-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insert(TrainingProject record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int insertSelective(TrainingProject record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    TrainingProject selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeySelective(TrainingProject record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKeyWithBLOBs(TrainingProject record);

    /**
     *
     * @mbggenerated 2017-05-06
     */
    int updateByPrimaryKey(TrainingProject record);
}