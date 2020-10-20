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
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
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
	
	public void remover(int id) {			
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		Paciente paciente = entityManager.find(Paciente.class, id);
		
		try {
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
	
	private Paciente obterPaciente(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Paciente.class, id);			
	}
	
	public Paciente editar(Paciente paciente, int id) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		Paciente pacienteAtualizado = entityManager.find(Paciente.class, id);
		pacienteAtualizado.setNome(paciente.getNome());
		
		try
		{
			transaction.begin();
			
			paciente = entityManager.merge(pacienteAtualizado);
			
			transaction.commit();
			
		}
		catch(Exception error) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
		
		return paciente;
	}
}
