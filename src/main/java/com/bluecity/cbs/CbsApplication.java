package com.bluecity.cbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@MapperScan("com.bluecity.*.*.dao")
@SpringBootApplication
public class CbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbsApplication.class, args);
	}
}
