package com.demo.SpringBoot;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@MapperScan("com.demo.mapper")
@SpringBootApplication(scanBasePackages = { "com.demo" })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
