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
import com.clinica.odontologica.repository.PacienteRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(path = "/v2/paciente", produces = "application/json")
public class PacienteMelhoradoController {
	
	private PacienteRepository pacienteRepository;

	private PacienteMelhoradoController() {
		this.pacienteRepository = new PacienteRepository();
	}
	
	//http://localhost:8080/paciente
	@ApiOperation(value = "Retorna todos os paciente cadastrados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acesssar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping()
	public Response<List<Paciente>> obterTodos(){		
		
		Response<List<Paciente>> response = new Response<List<Paciente>>();
		
		try
		{
			response.setDados(pacienteRepository.obterTodos());
			response.setStatus(HttpStatus.OK.value());
			
			return response;
		}
		catch(Exception e)
		{
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo paciente");
			
			return response;
		}
	}
	
	@GetMapping("/{id}")
	public Response<Paciente> obterPoId(@PathVariable int id){		
		
		Response<Paciente> response = new Response<Paciente>();
		
		try
		{
			response.setDados(pacienteRepository.obterPorId(id));
			response.setStatus(HttpStatus.OK.value());
			
			return response;
		}
		catch(Exception e)
		{
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao obter o paciente");
			
			return response;
		}
	}

	@PostMapping()
	public Response<Paciente> cadastrar(@Valid @RequestBody Paciente novoPaciente, BindingResult result)
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
				
				return response;
			}
			
			response.setStatus(HttpStatus.OK.value());
			pacienteRepository.cadastrar(novoPaciente);		
			response.setDados(novoPaciente);
			
			return response;
			
		}
		catch(Exception e) {	
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo paciente");
			
			return response;
		}
		
	}
	
	@DeleteMapping("/{id}")
	public Response<String> deletar(@PathVariable int id){
		
		Response<String> response = new Response<String>();
				
		try
		{
			pacienteRepository.remover(id);
			response.setDados("Paciente removido com sucesso");
			response.setStatus(HttpStatus.OK.value());
			return response;
		}
		catch(Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return response; 
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
