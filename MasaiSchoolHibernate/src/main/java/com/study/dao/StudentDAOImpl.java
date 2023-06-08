package com.study.dao;

import com.study.entity.Student;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;
import com.study.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class StudentDAOImpl implements IStudentDAO {

	public Student findStudentById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Student student = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			student = em.find(Student.class, id);
			if (student == null) {
				throw new NoRecordFoundException("Oops...! Student not found given Id.");
			}

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new SomethingWentWrongException("Oops...! Unable to Found Student");
		}

		return student;
	}

	public String saveStudent(Student student) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et = null;
		String studnetSavedResult = "Studnet Saved Successfully.";

		try {
			em = EMUtils.getEntityManager();
			System.out.println(em);
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			et.commit();
			return "Studnet Saved Successfully.";
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			System.out.println(e.getMessage());
			throw new SomethingWentWrongException("Oops...! Unable to Save Student.");
		} finally {
			em.close();
		}
	}

	public String deleteStudentById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Student student = findStudentById(id);
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			student =  em.merge(student);
			em.remove(student);
			et.commit();
			return "Student Deleted Successfully";
		}catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			throw new SomethingWentWrongException("Oops...! Unable to Delete Student.");
		}
		
		
	}

	public String updateStudentLevel(int id, int level) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Student student = findStudentById(id);
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			student = em.merge(student);
			student.setLevel(level);
			et.commit();
			return  "Student Updated Successfully.";
		} catch (PersistenceException e) {
			// TODO: handle exception
			throw new SomethingWentWrongException("Oops...! Unable to Update Student.");
		}
		
		
	}

}
