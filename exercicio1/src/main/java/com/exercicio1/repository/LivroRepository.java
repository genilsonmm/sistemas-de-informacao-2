package com.exercicio1.repository;

import java.util.ArrayList;
import java.util.List;

import com.exercicio1.model.Livro;

public class LivroRepository {

	private static LivroRepository instance;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public static LivroRepository Instance() {
		if(instance == null)
			instance = new LivroRepository();
		
		return instance;
	}
	
	public void add(Livro livro) {
		livros.add(livro);
	}
}
