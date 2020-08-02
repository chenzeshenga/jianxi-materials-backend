package com.jianxi.materials.jianximaterialsbackend.mapper;

import com.jianxi.materials.jianximaterialsbackend.pojo.Job;
import com.jianxi.materials.jianximaterialsbackend.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-08-02
 */
@Mapper
@CacheNamespace(flushInterval = 86400000L)
public interface HrMapper {

    @Insert("insert into m_hr(title,content,contact) values(#{title},#{content},#{contact})")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insert(Job product);

    @Update("update m_hr set title=#{title},content=#{content},contact=#{contact} where id=#{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int update(Job product);

    @Select("select id,title,content,contact from m_hr order by id desc")
    List<Job> listAll();

    @Delete("delete from m_hr where id=#{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int delete(String id);

}
