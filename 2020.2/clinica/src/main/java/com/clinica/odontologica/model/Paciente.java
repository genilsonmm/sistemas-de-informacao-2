package com.clinica.odontologica.model;

import javax.validation.constraints.NotEmpty;

public class Paciente {
	private int id;
	
	@NotEmpty(message = "O campo nome é obrigatório")
	private String nome;
	
	@NotEmpty(message = "O campo endereço é obrigatório")
	private String endereco;

	public Paciente(int id, String nome, String endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}
}
