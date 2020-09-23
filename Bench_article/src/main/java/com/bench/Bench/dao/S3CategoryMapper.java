package com.bench.Bench.dao;

import com.bench.bean.S3Category;
import com.bench.bean.S3CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface S3CategoryMapper {
    long countByExample(S3CategoryExample example);

    int deleteByExample(S3CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(S3Category record);

    int insertSelective(S3Category record);

    List<S3Category> selectByExample(S3CategoryExample example);

    S3Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") S3Category record, @Param("example") S3CategoryExample example);

    int updateByExample(@Param("record") S3Category record, @Param("example") S3CategoryExample example);

    int updateByPrimaryKeySelective(S3Category record);

    int updateByPrimaryKey(S3Category record);
}