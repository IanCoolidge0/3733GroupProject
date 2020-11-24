package com.quakec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChoiceAlternativesDAO {

	Connection conn;
	
	final String tblName = "choiceAlternatives";   // Exact capitalization

    public ChoiceAlternativesDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }
    
    public boolean addAlternativeToChoice(String choiceId, String alternativeId) throws SQLException {
    	PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (choice,alternative) values(?,?);");
    	
    	ps.setString(1, choiceId);
    	ps.setString(2, alternativeId);
    	
    	return ps.execute();
    }
	
}
