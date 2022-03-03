package kr.co.ex.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "kr.co.ex.biz.*")
@MapperScan(basePackages = "kr.co.ex.biz.*")
public class SpringBootSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerApplication.class, args);
	}

}