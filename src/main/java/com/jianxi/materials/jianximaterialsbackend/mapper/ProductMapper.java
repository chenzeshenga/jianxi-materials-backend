package com.jianxi.materials.jianximaterialsbackend.mapper;

import com.jianxi.materials.jianximaterialsbackend.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-07-25
 */
@Mapper
public interface ProductMapper {

    @Insert("insert into m_product(name,introduce,img,category) values(#{name},#{introduce},#{img},#{category})")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insert(Product product);

    @Update("update m_product set name=#{name},introduce=#{introduce},img=#{img},category=#{category} where id=#{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int update(Product product);

    @Select("select * from m_product order by id desc limit #{from},#{size}")
    List<Product> list(int from, int size);

    @Select("select id,name,introduce,img,category,level,`order` from m_product order by `order` asc")
    List<Product> listAll();

    @Select("select count(*) as total from m_product")
    long total();

    @Delete("delete from m_product where id=#{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int delete(String id);

    @Select("select * from m_product where id=#{id}")
    List<Product> getProduct(String id);

}
