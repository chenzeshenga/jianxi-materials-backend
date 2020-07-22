package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenzeshenga
 * @since 2020-07-22
 */
@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin("*")
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody User user) {
        log.info("user enter msg as {}", user);
        String username = user.getUsername();
        String pwd = user.getPwd();
        if (!"admin".equals(username) || !"jianxi@123".equals(pwd)) {
            throw new IllegalArgumentException("用户名密码错误");
        }
    }

}
