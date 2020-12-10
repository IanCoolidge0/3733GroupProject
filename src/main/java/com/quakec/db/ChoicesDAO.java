package com.quakec.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
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
    
    public boolean createChoice(Choice choice, Context ctx) throws SQLException {
    	PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (name,description,datetime,memberCount,chosenAlternative,id) values(?,?,?,?,?,?);");
    	
    	ps.setString(1, choice.getName());
    	ps.setString(2, choice.getDescription());
    	ps.setTimestamp(3, new Timestamp(choice.getDatetime().getTime()));
    	ps.setInt(4, choice.getMemberCount());
    	ps.setString(5, choice.getChosenAlternative());
    	ps.setString(6, choice.getId());
//    	try {
    		ps.execute();
    		return true;
//    	} catch(Exception e) {
//    		ctx.getLogger().log("error was " + e.getMessage());
//    		return false;
//    	}
    }
    
	public Choice getChoice(String id) throws Exception {
	        
//	        try {
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
	
//	        } catch (Exception e) {
//	        	e.printStackTrace();
//	            throw new Exception("Failed in getting constant: " + e.getMessage());
//	        }
	}

	public List<Choice> getAllChoices() throws Exception {
		ArrayList<Choice> choices = new ArrayList<>();
//		try {
			Choice choice = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				choice = generateChoice(resultSet);
				choices.add(choice);
			}

			resultSet.close();
			ps.close();

			return choices;

//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("Failed in getting constant: " + e.getMessage());
//		}
	}
	
	private Choice generateChoice(ResultSet resultSet) throws Exception {
        String name  = resultSet.getString("name");
        String description  = resultSet.getString("description");
        Timestamp timestamp  = resultSet.getTimestamp("datetime");
        Date date = new Date(timestamp.getTime());
        int memberCount  = resultSet.getInt("memberCount");
        String chosenAlternative  = resultSet.getString("chosenAlternative");
        String id  = resultSet.getString("id");
        
        return new Choice (id, name, description, date, memberCount,chosenAlternative);
    }

	public boolean completeChoice(String choiceId, String alternativeId) throws Exception {
		AlternativesDAO alternativesDAO = new AlternativesDAO();
		
		if(alternativesDAO.getAlternative(alternativeId).getChoiceId().equals(choiceId)) { // is the alternative actually part of the choice??
			PreparedStatement ps = conn.prepareStatement("UPDATE " + tblName + " SET chosenAlternative=? WHERE id=?;");
			ps.setString(1, alternativeId);
			ps.setString(2, choiceId);
			
			boolean result = ps.execute();
			ps.close();
			
			return result;
		}

		// it's not, return false. something went wrong
		return false;
	}
	

}

