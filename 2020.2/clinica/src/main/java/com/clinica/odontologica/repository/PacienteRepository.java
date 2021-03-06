package com.clinica.odontologica.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.clinica.odontologica.model.Paciente;

public class PacienteRepository {

	private EntityManagerFactory entityManagerFactory;
	
	public PacienteRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("clinicaConfig");
	}
	
	public void cadastrar(Paciente paciente) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction =  entityManager.getTransaction();
		
		try
		{
			transaction.begin();
						
			entityManager.persist(paciente);

			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
	}
	
	public List<Paciente> obterTodos(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("from " + Paciente.class.getName());
		return query.getResultList();
	}
	
	public Paciente obterPorId(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Paciente.class, id);
	}
	
	public void remover(int id) {			
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction =  entityManager.getTransaction();
		
		Paciente paciente = entityManager.find(Paciente.class, id);
		
		try
		{
			transaction.begin();
						
			entityManager.remove(paciente);

			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
	}
		
	public Paciente editar(Paciente paciente, int id) throws Exception {
		/*
		Paciente pacienteParaEditar = obterPaciente(id);
		
		if(pacienteParaEditar == null)
			throw new Exception("Paciente não existe!");
		
		pacienteParaEditar.setNome(paciente.getNome());
		pacienteParaEditar.setEndereço(paciente.getEndereco());
		*/
		return null;
	}
}
