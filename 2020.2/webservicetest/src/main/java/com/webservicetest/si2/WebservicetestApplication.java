package com.webservicetest.si2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebservicetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicetestApplication.class, args);
	}

	//localhost:8080
	/*
	@GetMapping
	public String olaWebService() {
		return "EndPoint principal";
	}
	*/
	
	//localhost:8080/inicio
	@GetMapping("/inicio")
	public String bemVindo() {
		return "Bem vindo ao WebService REST";
	}
	
	//localhost:8080/bemVindo2
	@GetMapping("/bemVindo2")
	public String bemVindo2() {
		return "bemVindo2";
	}
	
	//localhost:8080/mensagem
	@RequestMapping(value = "/mensagem", method = RequestMethod.GET)
	public String teste() {
		return "Utilizando RequestMapping";
	}
	
	//localhost:8080/obterAluno/123654
	@GetMapping("/obterAluno/{matricula}")
	public String aluno(@PathVariable int matricula) {		
		return "Italo Galdino de matrícula: " + matricula;
	}
	
	@GetMapping("/soma/{numero1}/{numero2}")
	public String aluno(@PathVariable int numero1, @PathVariable int numero2) {			
		Calculadora calc = new Calculadora();	
		return "A soma é: " + (calc.somar(numero1, numero2));
	}
}
