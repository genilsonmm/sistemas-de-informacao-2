package com.clinica.odontologica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinica.odontologica.model.*;
import com.clinica.odontologica.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	private PacienteRepository pacienteRepository;

	private PacienteController() {
		this.pacienteRepository = new PacienteRepository();
	}
	
	//http://localhost:8080/paciente
	@GetMapping()
	public ResponseEntity<List<Paciente>> obterTodos(){		
		try
		{
			return ResponseEntity.ok(pacienteRepository.obterTodos());
		}
		catch(Exception e)
		{
			return (ResponseEntity<List<Paciente>>)ResponseEntity.badRequest();
		}
	}

}
