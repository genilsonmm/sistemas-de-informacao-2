package com.exercicio1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.exercicio1.model.Livro;

public class LivroRepository {

	private static LivroRepository instance;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public static LivroRepository instance() {
		if(instance == null)
			instance = new LivroRepository();
		
		return instance;
	}
	
	public List<Livro> todos(){
		return livros;
	}
	
	public void add(Livro livro) {
		livro.setId(proximoId());
		livros.add(livro);
	}
	
	public Livro editar(int id, Livro livro) throws Exception {
		
		Livro livroLocalizado = obterLivro(id);
		
		livroLocalizado.setTitulo(livro.getTitulo());
		livroLocalizado.setEditora(livro.getEditora());
		livroLocalizado.setPaginas(livro.getPaginas());
		
		return livroLocalizado;	
	}
	
	public Livro obterLivro(int id) throws Exception {
		
		Optional<Livro> livroLocalizado = livros.stream().filter(l -> l.getId() == id).findFirst();
		
		if(livroLocalizado.isPresent())
			return livroLocalizado.get();
		else
			throw new Exception("Não foi possível localizar o livro");
	}
	
	public int remover(int id) throws Exception {
		livros.remove(obterLivro(id));
		return id;
	}
	
	private int proximoId() {
		return livros.size() + 1;
	}
}