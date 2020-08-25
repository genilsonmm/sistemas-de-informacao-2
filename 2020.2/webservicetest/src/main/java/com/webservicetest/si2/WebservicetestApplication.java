package com.webservicetest.si2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webservicetest.si2.model.Aluno;

@SpringBootApplication
@RestController
public class WebservicetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicetestApplication.class, args);
	}
}
