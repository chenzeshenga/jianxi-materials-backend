package com.jianxi.materials.jianximaterialsbackend.mapper;

import com.jianxi.materials.jianximaterialsbackend.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-07-23
 */
@Mapper
public interface NewsMapper {

    @Insert("insert into m_news(title,time,content,type) values(#{title},#{time},#{content},#{type})")
    int insert(News news);

    @Update("update m_news set title=#{title},time=#{time},content=#{content} where id=#{id}")
    int update(News news);

    @Select("select * from m_news where type=#{type} order by id desc limit #{from},#{size}")
    List<News> list(String type, int from, int size);

    @Select("select * from m_news order by id desc limit #{from},#{size}")
    List<News> listAll(int from, int size);

    @Select("select count(*) as total from m_news where type=#{type}")
    long total(String type);

    @Select("select count(*) as total from m_news")
    long totalAll();

    @Delete("delete from m_news where id=#{id}")
    int delete(String id);

}
