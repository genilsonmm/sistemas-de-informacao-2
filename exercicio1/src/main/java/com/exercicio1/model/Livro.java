package com.exercicio1.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Livro {
	
	private int id;
	
	@NotEmpty(message = "Digite o título para o livro") 
	private String titulo;
	
	@NotEmpty(message = "Digite o nome da editora") 
	private String editora;
	
	@NotNull(message = "A quantidade de páginas não pode ser nula")
	@Min(value=10, message = "O livro deve conter no mínimo 10 páginas")
	private long paginas;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public long getPaginas() {
		return paginas;
	}

	public void setPaginas(long paginas) {
		this.paginas = paginas;
	}
}
