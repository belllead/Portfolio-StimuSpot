package com.ssafy.pjt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.project.model.dao")
public class DBConfig {

}
