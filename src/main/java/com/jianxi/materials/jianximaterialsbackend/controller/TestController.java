package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.TestMapper;
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
@CrossOrigin("*")
public class TestController {

    @Resource
    private TestMapper testMapper;

    @GetMapping("/list")
    public List<String> get(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //    String currentOrigin = httpServletRequest.getHeader("Origin");
        //    httpServletResponse.setHeader("Access-Control-Allow-Origin", currentOrigin);
        //    httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        return testMapper.get();
    }
}
