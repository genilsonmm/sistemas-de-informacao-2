package com.webservicetest.si2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicetest.si2.model.Aluno;

@RestController()
@RequestMapping("/aluno")
public class AlunoController {

	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	//http://localhost:8080/aluno/cadastro
	@PostMapping("/cadastro")
	public int cadastrar(@RequestBody Aluno aluno) {
		
		alunos.add(aluno);
		
		return alunos.size();
	}
	
	@GetMapping("/obterPorMatricula/{matricula}")
	public ResponseEntity<Aluno> obterPorMatricula(@PathVariable int matricula){
		
		Aluno alunoEncontrado = null;
		
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula() == matricula)
			{
				alunoEncontrado = aluno;
			}
		}
		
		return ResponseEntity.ok(alunoEncontrado);
	}
	
	//http://localhost:8080/aluno/todos
	@GetMapping("/todos")
	public ResponseEntity<List<Aluno>> obterTodos() {
		
		try
		{
			return ResponseEntity.ok(alunos);
		}
		catch(Exception e) {
			return (ResponseEntity<List<Aluno>>) ResponseEntity.badRequest();
		}	 
	}
}
