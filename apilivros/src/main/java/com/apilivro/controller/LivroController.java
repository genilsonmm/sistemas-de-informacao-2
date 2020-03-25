package com.apilivro.controller;


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

import com.apilivro.model.Livro;
import com.apilivro.model.Response;
import com.apilivro.repository.LivroRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController()
@RequestMapping(path = "/api/v2/livros", produces = "application/json")
public class LivroController {
	
	public LivroController() {
		
	}
	
	
	@ApiOperation(value = "Retorna todos os livros cadastrados")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 404, message = "Livro não encontrado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})	
	@GetMapping()
	public ResponseEntity<List<Livro>> obtemTodos() {
		return new ResponseEntity<List<Livro>>(LivroRepository.instance().todos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> obterLivro(@PathVariable int id)
	{
		try
		{
			return new ResponseEntity<Object>(LivroRepository.instance().obterLivro(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Response<Livro>> cadastrar(@Valid @RequestBody Livro livro, BindingResult result) {					
		
		Response<Livro> response = new Response<Livro>();
		
		if(result.hasErrors())
		{
			for (ObjectError error : result.getAllErrors()) {
				String key = String.valueOf(response.getErrors().size() + 1); 
				response.getErrors().put(key, error.getDefaultMessage());
			}
			
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.badRequest().body(response);
		}
		
		LivroRepository.instance().add(livro);	
		
		response.setData(livro);
		response.setStatus(HttpStatus.OK.value());
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editar(@PathVariable int id, @RequestBody Livro livro)
	{
		try
		{
			Livro livroAtualizado = LivroRepository.instance().editar(id, livro);	
			return new ResponseEntity<Object>(livroAtualizado, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		try
		{
			return new ResponseEntity<Object>(LivroRepository.instance().remover(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
