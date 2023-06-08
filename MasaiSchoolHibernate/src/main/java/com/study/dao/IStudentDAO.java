package com.study.dao;

import com.study.entity.Student;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;

public interface IStudentDAO {
	Student findStudentById(int id) throws SomethingWentWrongException , NoRecordFoundException;
	String saveStudent(Student student) throws SomethingWentWrongException;
	String deleteStudentById(int id) throws SomethingWentWrongException , NoRecordFoundException;
	String updateStudentLevel(int id, int level) throws SomethingWentWrongException , NoRecordFoundException;
}
