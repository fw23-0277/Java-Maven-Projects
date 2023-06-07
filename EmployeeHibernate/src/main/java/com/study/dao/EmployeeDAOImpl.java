package com.study.dao;

import com.study.entity.Employee;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;
import com.study.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class EmployeeDAOImpl implements IEmployeeDAO {

	public void save(Employee emp) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(emp);
			et.commit();
			
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			throw new SomethingWentWrongException("Oops...! Unable to Save Employee.");
		}finally {
			em.close();
		}
		
	}

	public String getAddressOfEmployee(int empId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(empId);
		return emp.getAddress();
	}

	public String giveBonusToEmployee(int empId, int bonus) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(empId);
		return null;
	}

	public boolean deleteEmployee(int empId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(empId);
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		boolean success  = false;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			emp = em.merge(emp);
			em.remove(emp);
			et.commit();
			success = true;
		} catch (PersistenceException e) {
			// TODO: handle exception
			throw new SomethingWentWrongException("Oops...! Unable to Delete Employee.");
		}
		
		return success;
	}

	public Employee getEmployeeById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Employee emp =  null;
		try(EntityManager em = EMUtils.getEntityManager()){
			emp = em.find(Employee.class, id);
			if(emp == null) {
				throw new NoRecordFoundException("Oops...! Employee Not Found Given Id");
			}
			
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
		return emp;
	}

	

	

}
