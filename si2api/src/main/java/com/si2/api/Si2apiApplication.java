package com.si2.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.si2.api.model.Usuario;

@SpringBootApplication
@RestController
public class Si2apiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Si2apiApplication.class, args);
	}

	@RequestMapping("/")
	public String bemVindo() {
		return "Bem vindos ao curso de SI2";
	}
}
