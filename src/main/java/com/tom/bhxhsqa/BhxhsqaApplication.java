package com.tom.bhxhsqa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = { "com.tom.bhxhsqa.repository" })
public class BhxhsqaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhxhsqaApplication.class, args);
	}

}
