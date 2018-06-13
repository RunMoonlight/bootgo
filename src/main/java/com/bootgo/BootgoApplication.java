package com.bootgo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bootgo.dao")
public class BootgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootgoApplication.class, args);
	}
}
