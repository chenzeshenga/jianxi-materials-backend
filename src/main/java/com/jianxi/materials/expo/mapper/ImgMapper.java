package com.jianxi.materials.expo.mapper;

import com.jianxi.materials.expo.pojo.Img;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author chenzeshenga
 * @since 2020-07-12
 */
@Mapper
@CacheNamespace
public interface ImgMapper {

  @Select("select uuid,img,ctime,name from m_img where uuid=#{uuid}")
  Img getImgByUuid(String uuid);
}
