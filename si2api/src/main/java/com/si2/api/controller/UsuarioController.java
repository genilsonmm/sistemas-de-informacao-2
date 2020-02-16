package com.si2.api.controller;

import java.util.ArrayList;
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

import com.si2.api.model.Usuario;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {
	
	private List<Usuario> usuarios;
	
	public UsuarioController() {
		usuarios = new ArrayList<Usuario>();
		
		usuarios.add(new Usuario(1, "Daniel", 34));
		usuarios.add(new Usuario(2, "Maria", 24));
		usuarios.add(new Usuario(3, "João", 14));
	}
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> todos(){
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/id/{numero}")
	public ResponseEntity<String> user(@PathVariable int numero) {
		if(numero == 1)
		{
			String mensagem = "usuário de id: " + numero;
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public String cadastrarUsuario(@RequestBody Usuario usuario) {
		return "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
	}	
	
	@DeleteMapping("/{id}")
	public String deletarUsuario(@PathVariable int id) {
		return "Usuário de Id: " + id + " removido com sucesso!";
	}	
	
	@PutMapping("/{id}")
	public String atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
		return "Usuário de Id: " + id + " atualizado para: " + usuario;
	}
}
