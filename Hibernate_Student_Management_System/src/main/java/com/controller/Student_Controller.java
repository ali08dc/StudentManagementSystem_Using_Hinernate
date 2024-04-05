package com.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.Student_Entity;

public class Student_Controller {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("devil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	// SAVE STUDENT RECORD
	public boolean saveStudent(Student_Entity student) {

		if (student != null) {
			et.begin();
			em.persist(student);
			et.commit();

			return true;
		}

		return false;
	}

	// FIND STUDENT BY ID
	public Student_Entity findStudentById(int id) {

		Student_Entity s = null;

		if (id != 0) {

			s = em.find(Student_Entity.class, id);
		}

		return s;
	}

	// UPDATE STUDENT BY ID
	public boolean updateStudentByID(int id, String email) {

		Student_Entity s = em.find(Student_Entity.class, id);
		if (s != null) {
			s.setEmail(email);

			et.begin();
			em.merge(s);
			et.commit();
			return true;
		}
		return false;

	}

	// DELETE STUDENT BY ID
	public boolean deleteStudentByID(int id) {

		Student_Entity s = em.find(Student_Entity.class, id);
		if (s != null) {
			et.begin();
			em.remove(s);
			et.commit();
			return true;
		}
		return false;
	}

	// FIND ALL STUDENTS DETAIL
	public List<Student_Entity> findAll() {

		Query q = em.createQuery("select s from Student_Entity s");
		
		List<Student_Entity> list = q.getResultList();
		
		
		return list;

	}
}
