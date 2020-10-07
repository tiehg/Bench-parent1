package com.bench.Bench.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface S3ArticleMapper {
    long countByExample(S3ArticleExample example);

    int deleteByExample(S3ArticleExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(S3Article record);

    int insertSelective(S3Article record);

    List<S3Article> selectByExample(S3ArticleExample example);

    S3Article selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") S3Article record, @Param("example") S3ArticleExample example);

    int updateByExample(@Param("record") S3Article record, @Param("example") S3ArticleExample example);

    int updateByPrimaryKeySelective(S3Article record);

    int updateByPrimaryKey(S3Article record);
}
