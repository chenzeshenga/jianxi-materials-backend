package com.jianxi.materials.expo.controller;

import com.jianxi.materials.expo.mapper.TestMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

  @Resource private TestMapper testMapper;

  @GetMapping("/list")
  public List<String> get(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    //    String currentOrigin = httpServletRequest.getHeader("Origin");
    //    httpServletResponse.setHeader("Access-Control-Allow-Origin", currentOrigin);
    //    httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
    return testMapper.get();
  }
}
