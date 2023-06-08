package com.study.service;

import com.study.dao.IStudentDAO;
import com.study.dao.StudentDAOImpl;
import com.study.entity.Student;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;

public class StudentServiceImpl implements IStudentService {

	public Student findStudentById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IStudentDAO studentDAO = new StudentDAOImpl();
		return studentDAO.findStudentById(id);
	}

	public String saveStudent(Student student) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		IStudentDAO studentDAO = new StudentDAOImpl();
		return studentDAO.saveStudent(student);
	}

	public String deleteStudentById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IStudentDAO studentDAO = new StudentDAOImpl();
		return studentDAO.deleteStudentById(id);
	}

	public String updateStudentLevel(int id, int level) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IStudentDAO studentDAO = new StudentDAOImpl();
		return studentDAO.updateStudentLevel(id, level);
	}

}
