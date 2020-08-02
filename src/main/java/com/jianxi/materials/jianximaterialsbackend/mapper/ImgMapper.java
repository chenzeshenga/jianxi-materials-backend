package com.jianxi.materials.jianximaterialsbackend.mapper;

import com.jianxi.materials.jianximaterialsbackend.pojo.Img;
import org.apache.ibatis.annotations.*;

/**
 * @author chenzeshenga
 * @since 2020-07-12
 */
@Mapper
@CacheNamespace(flushInterval = 86400000L)
public interface ImgMapper {

    @Select({"select uuid,img,ctime,name from m_img where uuid=#{uuid}"})
    Img getImgByUuid(String uuid);

    @Insert({"insert into m_img(uuid,img) values (#{uuid},#{img})"})
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insert(Img img);

}
