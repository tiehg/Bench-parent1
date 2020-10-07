package com.bench.Bench.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface S3AnnouncementMapper {
    long countByExample(S3AnnouncementExample example);

    int deleteByExample(S3AnnouncementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(S3Announcement record);

    int insertSelective(S3Announcement record);

    List<S3Announcement> selectByExample(S3AnnouncementExample example);

    S3Announcement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") S3Announcement record, @Param("example") S3AnnouncementExample example);

    int updateByExample(@Param("record") S3Announcement record, @Param("example") S3AnnouncementExample example);

    int updateByPrimaryKeySelective(S3Announcement record);

    int updateByPrimaryKey(S3Announcement record);
}
