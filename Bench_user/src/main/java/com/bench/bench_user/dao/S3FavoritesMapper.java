package com.bench.bench_user.dao;

import com.bench.bean.S3Favorites;
import com.bench.bean.S3FavoritesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface S3FavoritesMapper {
    long countByExample(S3FavoritesExample example);

    int deleteByExample(S3FavoritesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(S3Favorites record);

    int insertSelective(S3Favorites record);

    List<S3Favorites> selectByExample(S3FavoritesExample example);

    S3Favorites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") S3Favorites record, @Param("example") S3FavoritesExample example);

    int updateByExample(@Param("record") S3Favorites record, @Param("example") S3FavoritesExample example);

    int updateByPrimaryKeySelective(S3Favorites record);

    int updateByPrimaryKey(S3Favorites record);
}