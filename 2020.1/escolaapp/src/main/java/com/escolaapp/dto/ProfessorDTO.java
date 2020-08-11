package com.escolaapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.escolaapp.model.Disciplina;
import com.escolaapp.model.Professor;

public class ProfessorDTO {
	
	private int id;
	private String nome;
	private List<String> disciplinas;
		
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
	
	public List<String> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<String> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
