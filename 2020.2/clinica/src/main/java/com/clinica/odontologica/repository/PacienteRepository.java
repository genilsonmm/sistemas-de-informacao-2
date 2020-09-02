package com.clinica.odontologica.repository;

import java.util.List;

import com.clinica.odontologica.model.Paciente;

public class PacienteRepository {

	private List<Paciente> pacientes;
	
	public PacienteRepository() {
		this.pacientes = Database.getInstance().pacientes();
	}
	
	public void cadastrar(Paciente paciente) {
		pacientes.add(paciente);
	}
	
	public List<Paciente> obterTodos(){
		return pacientes;
	}
	
	public void remover() {
		
	}
	
	public Paciente editar(Paciente paciente) {
		return null;
	}
}
