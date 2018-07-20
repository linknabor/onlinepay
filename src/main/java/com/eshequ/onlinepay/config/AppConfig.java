package com.eshequ.onlinepay.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.eshequ.onlinepay")
@MapperScan(basePackages="com.eshequ.onlinepay.mapper")
public class AppConfig {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AppConfig.class, args);
		
	}
	
	
}
