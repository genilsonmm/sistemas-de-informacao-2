package com.si2.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar() {
		return "Listar valores";
	}
	
	@GetMapping("/usuario/id/{numero}")
	public String user(@PathVariable String numero) {
		return "usuário de id: " + numero;
	}
}
