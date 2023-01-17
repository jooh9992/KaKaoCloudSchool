package com.kakao.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ReviewboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewboardApplication.class, args);
	}

}
