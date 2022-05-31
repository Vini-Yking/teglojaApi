package br.com.tegloja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class TeglojaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeglojaApiApplication.class, args);
	}

}
