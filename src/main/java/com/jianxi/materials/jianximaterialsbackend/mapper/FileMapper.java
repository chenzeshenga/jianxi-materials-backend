package com.jianxi.materials.jianximaterialsbackend.mapper;

import com.jianxi.materials.jianximaterialsbackend.pojo.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-07-26
 */
@Mapper
@CacheNamespace(flushInterval = 86400000L)
public interface FileMapper {

    @Insert("insert into m_file(uuid,file,ctime,name) values(#{uuid},#{file},#{ctime},#{name})")
    int insert(File file);

    @Select("select uuid,ctime,name from m_file order by uuid desc limit #{from},#{size}")
    List<File> list(int from, int size);

    @Select("select count(*) as total from m_file")
    long totalAll();

    @Delete("delete from m_file where uuid=#{uuid}")
    int delete(String uuid);

    @Select("select * from m_file where uuid=#{uuid} limit 1")
    File getFile(String uuid);

}
