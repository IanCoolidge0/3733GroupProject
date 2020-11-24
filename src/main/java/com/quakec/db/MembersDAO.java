package com.quakec.db;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.quakec.model.Member;





public class MembersDAO { 

	java.sql.Connection conn;
	
	final String tblName = "member";   // Exact capitalization

    public MembersDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }
    
    public boolean addMember(Member member) throws Exception {
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name = ?;");
//            ps.setString(1, constant.name);
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }
 
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (name,password,hasPwd,registered) values(?,?,?,?);");
            ps.setString(1,  member.getName());
            ps.setString(2,  member.getPassword());
            ps.setBoolean(3,  member.getHasPassword());
            ps.setBoolean(4,  member.getRegistered());
            ps.execute();
            return true;

//        } catch (Exception e) {
//            throw new Exception("Failed to insert constant: " + e.getMessage());
//        }
    }

   

}