package com.quakec.db;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.quakec.model.Choice;



public class ChoicesDAO { 

	java.sql.Connection conn;
	
	final String tblName = "choice";   // Exact capitalization

    public ChoicesDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }
    
    public boolean createChoice(Choice choice) throws SQLException {
    	PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (name,description,dateCreated,memberCount,hasChosenAlternative,id) values(?,?,?,?,?,?);");
    	
    	ps.setString(1, choice.getName());
    	ps.setString(2, choice.getDescription());
    	ps.setTimestamp(3, new Timestamp(choice.getDatetime().getTime()));
    	ps.setInt(4, choice.getMemberCount());
    	ps.setBoolean(5, choice.getHasChosenAlternative());
    	ps.setString(6, choice.getId());
    	
    	return ps.execute();
    }
    
	public Choice getChoice(String id) throws Exception {
	        
	        try {
	            Choice choice = null;
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE id=?;");
	            ps.setString(1,  id);
	            ResultSet resultSet = ps.executeQuery();
	            
	            while (resultSet.next()) {
	                choice = generateChoice(resultSet);
	            }
	            resultSet.close();
	            ps.close();
	            
	            return choice;
	
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw new Exception("Failed in getting constant: " + e.getMessage());
	        }
	}

	public Choice[] getAllChoices() throws Exception {
		ArrayList<Choice> tempChoices = new ArrayList<>();
		try {
			Choice choice = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				choice = generateChoice(resultSet);
				tempChoices.add(choice);
			}

			resultSet.close();
			ps.close();
			Choice[] choices = new Choice[tempChoices.size()];
			choices = tempChoices.toArray(choices);

			return choices;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting constant: " + e.getMessage());
		}
	}
	
	private Choice generateChoice(ResultSet resultSet) throws Exception {
        String name  = resultSet.getString("name");
        String description  = resultSet.getString("description");
        Timestamp timestamp  = resultSet.getTimestamp("datetime");
        Date date = (Date) new java.util.Date(timestamp.getTime());
        int memberCount  = resultSet.getInt("memberCount");
        boolean hasChosenAlternative  = resultSet.getBoolean("hasChosenAlternative");
        String id  = resultSet.getString("id");
        
        return new Choice (name, description, date, memberCount, hasChosenAlternative, id);
    }
	
    

   

}