package com.quakec.db;

import java.sql.PreparedStatement;

public class ChoiceMembersDAO {
	
	java.sql.Connection conn;
	
	final String tblName = "choiceMembers";   // Exact capitalization

    public ChoiceMembersDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }
    
    public boolean addChoiceMember(String choiceId, String memberId) throws Exception {
//      try {
//          PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name = ?;");
//          ps.setString(1, constant.name);
//          ResultSet resultSet = ps.executeQuery();
//          
//          // already present?
//          while (resultSet.next()) {
//              Constant c = generateConstant(resultSet);
//              resultSet.close();
//              return false;
//          }

          PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (choice,member) values(?,?);");
          ps.setString(1,  choiceId);
          ps.setString(2,  memberId);
          ps.execute();
          return true;

//      } catch (Exception e) {
//          throw new Exception("Failed to insert constant: " + e.getMessage());
//      }
  }

}
