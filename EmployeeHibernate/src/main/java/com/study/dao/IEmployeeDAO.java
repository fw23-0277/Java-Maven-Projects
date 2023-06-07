package com.study.dao;

import com.study.entity.Employee;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;

public interface IEmployeeDAO {
	public void save(Employee emp) throws SomethingWentWrongException;
	public String getAddressOfEmployee(int empId)throws SomethingWentWrongException  , NoRecordFoundException;
	public String giveBonusToEmployee(int empId, int bonus) throws SomethingWentWrongException , NoRecordFoundException;
	public boolean deleteEmployee(int empId) throws SomethingWentWrongException , NoRecordFoundException;
	public Employee getEmployeeById(int id) throws SomethingWentWrongException , NoRecordFoundException;
}
