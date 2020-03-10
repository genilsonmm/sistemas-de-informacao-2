package com.exercicio1.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio1.model.Livro;
import com.exercicio1.repository.LivroRepository;

@RestController()
@RequestMapping("/livros")
public class LivroController {
	
	public LivroController() {
		
	}
	
	@GetMapping()
	public String inicio() {
		return "Web Service executando...";
	}
	
	@PostMapping()
	public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
		LivroRepository.Instance().add(livro);
		return new ResponseEntity<Livro>(livro, HttpStatus.OK);
	}
}
