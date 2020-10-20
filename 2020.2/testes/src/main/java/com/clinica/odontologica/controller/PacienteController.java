package com.clinica.odontologica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinica.odontologica.model.*;
import com.clinica.odontologica.repository.Database;
import com.clinica.odontologica.repository.PacienteRepository;

@RestController
@RequestMapping("/v1/paciente")
public class PacienteController {
	
	private PacienteRepository pacienteRepository;

	private PacienteController() {
		this.pacienteRepository = new PacienteRepository();
		
		Paciente maria = new Paciente(1, "Maria", "Centro");
		Paciente joao = new Paciente(2, "João", "Catolé");
		Paciente danilo = new Paciente(3, "Danilo", "Itarare");
		
		Database.getInstance().pacientes().add(maria);
		Database.getInstance().pacientes().add(joao);
		Database.getInstance().pacientes().add(danilo);
	}
	
	//http://localhost:8080/paciente
	@GetMapping()
	public ResponseEntity<List<Paciente>> obterTodos(){		
		try
		{
			return new ResponseEntity<List<Paciente>>(pacienteRepository.obterTodos(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Paciente>>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping()
	public ResponseEntity<String> cadastrar(@RequestBody Paciente novoPaciente)
	{
		try
		{
			pacienteRepository.cadastrar(novoPaciente);
			return new ResponseEntity<String>("Paciente cadastrado com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable int id){
		try
		{
			pacienteRepository.remover(id);
			return new ResponseEntity<String>("Paciente removido com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> editar(@PathVariable int id, @RequestBody Paciente paciente){
		try {
			Paciente pacienteEditado = pacienteRepository.editar(paciente, id);
			return new ResponseEntity<Paciente>(pacienteEditado, HttpStatus.OK); 
		}
		catch(Exception e) {
			return new ResponseEntity<Paciente>(HttpStatus.BAD_REQUEST);
		}
	}
}
