package com.escolaapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escolaapp.model.Professor;

public class ProfessorRepository {

	private EntityManagerFactory entityManagerFactory; 
	
	public ProfessorRepository() {
		entityManagerFactory = Persistence.createEntityManagerFactory("escolaConfig");
	}
	
	public void add(Professor professor) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			entityManager.persist(professor);
			
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
	}
	
	public List<Professor> getAll(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("from " + Professor.class.getName());
		
		return query.getResultList();
	}

	public void delete(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		EntityTransaction transaction = entityManager.getTransaction();
		
		Professor aluno = entityManager.find(Professor.class, id);
		
		try {
			transaction.begin();
			
			entityManager.remove(aluno);
			
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		finally {
			entityManager.close();
		}
	}
}
