package com.jianxi.materials.jianximaterialsbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

  @Select("select id from test")
  List<String> get();
}
