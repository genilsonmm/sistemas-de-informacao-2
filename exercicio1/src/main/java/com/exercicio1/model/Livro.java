package com.exercicio1.model;


public class Livro {
	
	private int id;
	private String titulo;
	private String editora;
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
