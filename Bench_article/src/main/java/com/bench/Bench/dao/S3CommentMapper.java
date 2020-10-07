package com.bench.Bench.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface S3CommentMapper {
    long countByExample(S3CommentExample example);

    int deleteByExample(S3CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(S3Comment record);

    int insertSelective(S3Comment record);

    List<S3Comment> selectByExample(S3CommentExample example);

    S3Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") S3Comment record, @Param("example") S3CommentExample example);

    int updateByExample(@Param("record") S3Comment record, @Param("example") S3CommentExample example);

    int updateByPrimaryKeySelective(S3Comment record);

    int updateByPrimaryKey(S3Comment record);
}
