package com.clinica.odontologica.repository;

import java.util.List;
import java.util.Optional;

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
	
	public void remover(int id) {			
		pacientes.remove(obterPaciente(id));	
	}
	
	private Paciente obterPaciente(int id) {
		Optional<Paciente> pacienteEncontrado =  pacientes.stream().filter(p -> p.getId() == id).findFirst();	
		return pacienteEncontrado.isPresent() ? pacienteEncontrado.get() :  null;			
	}
	
	public Paciente editar(Paciente paciente, int id) throws Exception {
		
		Paciente pacienteParaEditar = obterPaciente(id);
		
		if(pacienteParaEditar == null)
			throw new Exception("Paciente não existe!");
		
		pacienteParaEditar.setNome(paciente.getNome());
		pacienteParaEditar.setEndereço(paciente.getEndereco());
		
		return pacienteParaEditar;
	}
}
