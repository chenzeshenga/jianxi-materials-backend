package com.jianxi.materials.expo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jianxi")
public class ExpoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpoApplication.class, args);
  }
}
