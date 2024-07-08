package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"controller.*","*.member","data.*","tiles.config","com.example.demo","naver.cloud"}) //어노테이션 패키지들
@MapperScan("data.mapper") //mapper에 있는 인터페이스만을 넣기 위함
public class BootMybatisTilesV3Application {

    public static void main(String[] args) {
        SpringApplication.run(BootMybatisTilesV3Application.class, args);
    }

}
