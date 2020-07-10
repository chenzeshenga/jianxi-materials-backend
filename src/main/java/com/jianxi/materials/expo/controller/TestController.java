package com.jianxi.materials.expo.controller;

import com.jianxi.materials.expo.mapper.TestMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

  @Resource private TestMapper testMapper;

  @GetMapping("/list")
  public List<String> get() {
    return testMapper.get();
  }
}
