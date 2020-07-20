package com.escolaapp.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolaapp.dto.ProfessorDTO;
import com.escolaapp.model.Disciplina;
import com.escolaapp.model.Professor;
import com.escolaapp.model.Response;
import com.escolaapp.repository.ProfessorRepository;

@CrossOrigin()
@RestController()
@RequestMapping("/api/professor")
public class ProfessorController {
	
	private ProfessorRepository professorRepository;
	private ModelMapper modelMapper;
	
	public ProfessorController() {
		professorRepository = new ProfessorRepository();
		modelMapper = new ModelMapper();
	}
		
	@GetMapping()
	public ResponseEntity<Response<List<ProfessorDTO>>> obtemTodos() {
		
		Response<List<ProfessorDTO>> response = new Response<List<ProfessorDTO>>();
		
		List<ProfessorDTO> professoresDTO = Arrays.asList(modelMapper.map(professorRepository.getAll(), ProfessorDTO[].class));
				 
		response.setData(professoresDTO);
		response.setStatus(HttpStatus.OK.value());
		
		return ResponseEntity.ok(response);
	}

	@PutMapping()
	public ResponseEntity<Response<ProfessorDTO>> editar(@RequestBody ProfessorDTO professorDTO){
		
		Response<ProfessorDTO> response = new Response<ProfessorDTO>();
		
		try
		{
			Professor professor = modelMapper.map(professorDTO, Professor.class);
			
			Professor professorAtualizado = professorRepository.edit(professor);
			
			ProfessorDTO professorAtualizadoDTO = modelMapper.map(professorAtualizado, ProfessorDTO.class);			
			
			response.setData(professorAtualizadoDTO);
			
			response.setStatus(HttpStatus.OK.value());
			
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.ok(response);
		}
		
	}
	
	@PostMapping()
	public ResponseEntity<Response<Professor>> cadastrar(@Valid @RequestBody Professor professor, BindingResult result) {					
		
		Response<Professor> response = new Response<Professor>();
		
		if(result.hasErrors())
		{
			for (ObjectError error : result.getAllErrors()) {
				String key = String.valueOf(response.getErrors().size() + 1); 
				response.getErrors().put(key, error.getDefaultMessage());
			}
			
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.badRequest().body(response);
		}
		
		Professor novoProfessor = new Professor();
		novoProfessor.setNome(professor.getNome());
		
		for (Disciplina element : professor.getDisciplinas()) {
			element.setProfessor(novoProfessor);
			novoProfessor.getDisciplinas().add(element);
		}
		
		professorRepository.add(novoProfessor);
	
		response.setData(novoProfessor);
		response.setStatus(HttpStatus.OK.value());
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable int id){
		Response<Integer> response = new Response<Integer>();
		
		try
		{
			professorRepository.delete(id);
			
			response.setData(id);
			response.setStatus(HttpStatus.OK.value());
			
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.ok(response);
		}
	}

}