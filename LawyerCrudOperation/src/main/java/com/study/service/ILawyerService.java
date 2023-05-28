package com.study.service;

import java.util.List;

import com.study.dto.Lawyer;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;

public interface ILawyerService {
	List<Lawyer> getLawyerList() throws SomethingWentWrongException , NoRecordFoundException;
	Lawyer findLawyerById(int id)throws SomethingWentWrongException , NoRecordFoundException;
	String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException;
	String deleteLawyerById(int id) throws SomethingWentWrongException , NoRecordFoundException;
	String updateLawyerExperience(int id, int experience)throws SomethingWentWrongException , NoRecordFoundException;
}
