package com.si2.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		usuarios.forEach(u -> {
			System.out.println(u.getNome());
		});
	}
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> todos(){
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public Usuario user(){
		return new Usuario(10, "Maria", 30);
	}
	
	@GetMapping("/id/{numero}")
	public ResponseEntity<Usuario> user(@PathVariable int numero) {
		
		Optional<Usuario> usuario = usuarios.stream().filter(user -> user.getId() == numero).findFirst();
		
		if(usuario.isPresent())
		{		
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
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
