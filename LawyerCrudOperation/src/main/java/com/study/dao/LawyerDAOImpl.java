package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.dto.Lawyer;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;
import com.study.methods.UserMethods;
import com.study.utility.DBUtils;

public class LawyerDAOImpl implements ILawyerDAO {

	@Override
	public List<Lawyer> getLawyerList() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		List<Lawyer> lawyerList = new ArrayList<>();
		
		try (Connection connection = DBUtils.createConnection()){
			
			String selectQuery = "SELECT * FROM LAWYER";
			PreparedStatement prepareStatement = connection.prepareStatement(selectQuery);
			
			ResultSet rs = prepareStatement.executeQuery();
			if(UserMethods.isResultSetEmpty(rs)) throw new NoRecordFoundException("Oops...!Lawyer Not Found.");
			while(rs.next()) {
				Lawyer lawyer = new Lawyer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				lawyerList.add(lawyer);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Oops...! Unable to fetch Lawyer Records.");
		}
		return lawyerList;
	}

	@Override
	public Lawyer findLawyerById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.createConnection()){
			String findQuery = "SELECT * FROM LAWYER WHERE id =" + id ;
			
			
			PreparedStatement prepareStatement = connection.prepareStatement(findQuery);
			
			
			ResultSet rs = prepareStatement.executeQuery(findQuery);
			
			if(UserMethods.isResultSetEmpty(rs)) throw new NoRecordFoundException("Oops...! Lawyer Not Found.");
			
			rs.next();
			Lawyer 	lawyer = new Lawyer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			return lawyer;
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Oops...! Unable to find Lawyer");
		}
		
		return null;
	}

	@Override
	public String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		try (Connection connection = DBUtils.createConnection()){
			String addQuery = "INSERT INTO LAWYER VALUES(?,?,?,?,?)";
			
			PreparedStatement prepareStatement = connection.prepareStatement(addQuery);
			
			prepareStatement.setInt(1, lawyer.getId());
			prepareStatement.setString(2, lawyer.getName());
			prepareStatement.setString(3, lawyer.getEmail());	
			prepareStatement.setString(4, lawyer.getAddress());
			prepareStatement.setInt(5, lawyer.getExperience());
			
			prepareStatement.executeUpdate();
			return "Lawyer Add Sucsessfully...!";
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Oops..! Unable to Add Lawyer.");
		}
		
		return null;
	}

	@Override
	public String deleteLawyerById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		try (Connection connection = DBUtils.createConnection()){
			String deleteQuery = "DELETE FROM LAWYER WHERE ID = ?";
		
			PreparedStatement prepareStatement = connection.prepareStatement(deleteQuery);
			
			prepareStatement.setInt(1,id);
			
			if(prepareStatement.executeUpdate() == 0) throw new NoRecordFoundException("Oops...! Lawyer Not Found.");
		
			return "Lawyer Delete Sucsessfully.";
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Oops..! Unable to Delete Lawyer.");
		}
		
		return null;
	}

	@Override
	public String updateLawyerExperience(int id, int experience) throws SomethingWentWrongException , NoRecordFoundException{
		// TODO Auto-generated method stub
		
		try (Connection connection = DBUtils.createConnection()){
			
			String updateQuery = "UPDATE LAWYER SET  experience = ? WHERE id = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(updateQuery);
			prepareStatement.setInt(1, experience);
			prepareStatement.setInt(2, id);
			
			if(prepareStatement.executeUpdate() == 0) throw new NoRecordFoundException("Oops...! Lawyer Not Found.");
			return "Lawyer Updated Successfully...!";
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Oops...! Unable to Update Lawyer");
		}
		return null;
	}
	

}
