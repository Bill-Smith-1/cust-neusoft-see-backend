package com.neusoft;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Description: SpringBoot初始化类
 * 
 * @author: neuedu
 * 
 * @date: 2023-12-06
 * 
 */
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MakeApplication.class);
	}
}
