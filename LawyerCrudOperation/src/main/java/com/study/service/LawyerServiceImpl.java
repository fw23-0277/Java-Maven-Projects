package com.study.service;

import java.util.List;

import com.study.dao.ILawyerDAO;
import com.study.dao.LawyerDAOImpl;
import com.study.dto.Lawyer;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;

public class LawyerServiceImpl implements ILawyerService {
	
	ILawyerDAO lawyerDAO = new LawyerDAOImpl();
	
	@Override
	public List<Lawyer> getLawyerList() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return lawyerDAO.getLawyerList();
	}

	@Override
	public Lawyer findLawyerById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return lawyerDAO.findLawyerById(id);
	}

	@Override
	public String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return lawyerDAO.saveLawyer(lawyer);
	}

	@Override
	public String deleteLawyerById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return lawyerDAO.deleteLawyerById(id);
	}

	@Override
	public String updateLawyerExperience(int id, int experience) throws SomethingWentWrongException , NoRecordFoundException{
		// TODO Auto-generated method stub
		return lawyerDAO.updateLawyerExperience(id, experience);
	}
	

}
