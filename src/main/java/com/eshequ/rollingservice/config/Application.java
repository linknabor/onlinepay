package com.eshequ.rollingservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.eshequ.rollingservice.service.HelloService;


@SpringBootApplication
@ComponentScan("com.eshequ.rollingservice")
@MapperScan(basePackages="com.eshequ.rollingservice.mapper")
public class Application implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private HelloService helloService;

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("输入参数 ：" + args.length + "个。");
		helloService.testInsert();
		
	}
	
	
	
}
