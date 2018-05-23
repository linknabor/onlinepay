package com.eshequ.rollingservice.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 没有用了,不加载。默认配置自行会加载sqlSessionFactory
 * @author huym
 *
 */
public class DatabaseConfig {

	/**
	 * mybatis 配置
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SqlSessionFactory getSqleSessionFactory() throws IOException {
		
		String resource = "mybatis-config.xml";
    	InputStream inputStream = Resources.getResourceAsStream(resource);
    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    	return sqlSessionFactory;
	}
	
	
}
