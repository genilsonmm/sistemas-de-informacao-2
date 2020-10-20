package com.clinica.odontologica.repository;
import java.util.ArrayList;
import java.util.List;

import com.clinica.odontologica.model.*;

public class Database {

	private static Database instancia;
	
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	public static Database getInstance() {
		if(instancia == null) {
			instancia = new Database();
		}
		
		return instancia;
	}	
	
	public List<Paciente> pacientes()
	{
		return pacientes;
	}
}
