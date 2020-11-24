package com.quakec.db;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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