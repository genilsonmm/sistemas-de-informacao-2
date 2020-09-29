package com.clinica.odontologica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinica.odontologica.model.Paciente;
import com.clinica.odontologica.model.Response;
import com.clinica.odontologica.repository.Database;
import com.clinica.odontologica.repository.PacienteRepository;

@RestController
@RequestMapping("/v2/paciente")
public class PacienteMelhoradoController {
	
	private PacienteRepository pacienteRepository;

	private PacienteMelhoradoController() {
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
	public ResponseEntity<Response<List<Paciente>>> obterTodos(){		
		
		Response<List<Paciente>> response = new Response<List<Paciente>>();
		
		try
		{
			response.setDados(pacienteRepository.obterTodos());
			response.setStatus(HttpStatus.OK.value());
			
			return ResponseEntity.ok(response);
		}
		catch(Exception e)
		{
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo paciente");
			
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping()
	public ResponseEntity<Response<Paciente>> cadastrar(@Valid @RequestBody Paciente novoPaciente, BindingResult result)
	{	
		Response<Paciente> response = new Response<Paciente>(); 
		
		try
		{		
			if(result.hasErrors())
			{			
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				for(ObjectError  error : result.getAllErrors()) {
					String key = String.valueOf(response.getErros().size() + 1);
					
					response.getErros().put(key, error.getDefaultMessage());
				}
				
				return ResponseEntity.ok(response);
			}
			
			response.setStatus(HttpStatus.OK.value());
			pacienteRepository.cadastrar(novoPaciente);		
			response.setDados(novoPaciente);
			
			return ResponseEntity.ok(response);
			
		}
		catch(Exception e) {	
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo paciente");
			
			return ResponseEntity.ok(response);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable int id){
		
		Response<String> response = new Response<String>();
		
		
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
	public ResponseEntity<Response<Paciente>> editar(@PathVariable int id, @Valid @RequestBody Paciente paciente, BindingResult result){
		
		Response<Paciente> response = new Response<Paciente>(); 
		
		try {
			
			if(result.hasErrors())
			{
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				for(ObjectError  error : result.getAllErrors()) {
					String key = String.valueOf(response.getErros().size() + 1);
					
					response.getErros().put(key, error.getDefaultMessage());
				}
				
				return ResponseEntity.ok(response);
			}
			
			response.setDados(pacienteRepository.editar(paciente, id));
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao editar novo paciente");
			
			return ResponseEntity.ok(response);
		}
	}
}
