package com.quakec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quakec.model.Alternative;
import com.quakec.model.Member;

public class AlternativesDAO {

	Connection conn;
	
	final String tblName = "alternative"; // Exact capitalization
	
	public AlternativesDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}
	
	public boolean createAlternative(Alternative alternative) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (number,name,id,choiceId) values(?,?,?,?)");
		
		ps.setInt(1, alternative.getNumber());
		ps.setString(2, alternative.getName());
		ps.setString(3, alternative.getId());
		ps.setString(4, alternative.getChoiceId());
		
		return ps.execute();
	}
	
	public Alternative getAlternative(String id) throws Exception {
		Alternative altern = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE id=?;");
		ps.setString(1, id);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) altern = generateAlternative(resultSet);
		resultSet.close();
		ps.close();
		
		return altern;
	}
	
	public List<Alternative> getAlternativesWithChoiceId(String id) throws Exception {
    	List<Alternative> members = new ArrayList<>();
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE choiceId = ?;");
    		ps.setString(1, id);
    		ResultSet resultSet = ps.executeQuery();
    		
    		
    		while (resultSet.next()) {
    			Alternative a = generateAlternative(resultSet);
    			members.add(a);
    		}
    		resultSet.close();
    		ps.close();
    		return members;
    	} catch (Exception e) {
    		throw new Exception("Failed to get alternatives of choiceId:" + e.getMessage());
    	}
    }
	
	private Alternative generateAlternative(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("name");
		int number = resultSet.getInt("number");
		String id = resultSet.getString("id");
		String choiceId = resultSet.getString("choiceId");
		
		return new Alternative(id,choiceId,name,number);
	}
	
}
