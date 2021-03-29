package com.jianxi.materials.jianximaterialsbackend.mapper;

import com.jianxi.materials.jianximaterialsbackend.pojo.Materials;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-07-26
 */
@Mapper
@CacheNamespace(flushInterval = 86400000L)
public interface MaterialsMapper {

    @Insert("insert into m_file(uuid,path,ctime,name) values(#{uuid},#{path},#{ctime},#{name})")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insert(Materials materials);

    @Select("select uuid,ctime,name from m_file order by uuid desc limit #{from},#{size}")
    List<Materials> list(int from, int size);

    @Select("select count(*) as total from m_file")
    long totalAll();

    @Delete("delete from m_file where uuid=#{uuid}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int delete(String uuid);

    @Select("select * from m_file where uuid=#{uuid} limit 1")
    Materials getFile(String uuid);

}
