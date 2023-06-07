package com.study.service;

import com.study.dao.EmployeeDAOImpl;
import com.study.dao.IEmployeeDAO;
import com.study.entity.Employee;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;

public class EmployeeServiceImpl implements IEmployeeService {

	public void save(Employee emp) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.save(emp);
	}

	public String getAddressOfEmployee(int empId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.getAddressOfEmployee(empId);
	}

	public String giveBonusToEmployee(int empId, int bonus) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEmployee(int empId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.deleteEmployee(empId);
	}

	public Employee findEmployee(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
