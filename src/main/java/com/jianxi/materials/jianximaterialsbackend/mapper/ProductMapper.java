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

    @Insert("insert into m_product(name,introduce,img) values(#{name},#{introduce},#{img})")
    int insert(Product product);

    @Update("update m_product set name=#{name},introduce=#{introduce},img=#{img} where id=#{id}")
    int update(Product product);

    @Select("select * from m_product order by id desc limit #{from},#{size}")
    List<Product> list(int from, int size);

    @Select("select * from m_product order by id desc")
    List<Product> listAll();

    @Select("select count(*) as total from m_product")
    long total();

    @Delete("delete from m_product where id=#{id}")
    int delete(String id);

    @Select("select * from m_product where id=#{id} limit 1")
    Product getProduct(String id);

}
