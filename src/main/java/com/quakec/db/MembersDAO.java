package com.quakec.db;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.quakec.model.Choice;
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
    
    private Member generateMember(ResultSet resultSet) throws Exception {
    	String id =  resultSet.getString("id");
    	String choiceId = resultSet.getString("choiceId");
    	String name = resultSet.getString("name");
    	String password = resultSet.getString("password");
    	boolean hasPassword = resultSet.getBoolean("hasPassword");
    	
    	return new Member(id,choiceId,name,password,hasPassword);   	
    }

    public Member getMember(String id) throws Exception {
    	try {
    		Member member = null;
    		PreparedStatement ps = conn.prepareStatement("SELECT* FROM " + tblName + " WHERE id=?;");
    		ps.setString(1, id);
    		ResultSet resultSet = ps.executeQuery();
    		
    		while (resultSet.next()) {
    			member =  generateMember(resultSet);
    		}
    		
    		resultSet.close();
    		ps.close();
    		return member;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception("Failed in getting member: " + e.getMessage());
    	}
    }
    
    public boolean deleteMember(Member member) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblName + " WHERE id = ?;");
            ps.setString(1, member.getId());
            int numAffected = ps.executeUpdate();
            ps.close();
            
            return (numAffected == 1);

        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }
    
    public List<Member> getMembersWithName(String name) throws Exception {
    	List<Member> members = new ArrayList<>();
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name = ?;");
    		ps.setString(1, name);
    		ResultSet resultSet = ps.executeQuery();
    		
    		
    		while (resultSet.next()) {
    			Member m = generateMember(resultSet);
    			members.add(m);
    		}
    		resultSet.close();
    		ps.close();
    		return members;
    	} catch (Exception e) {
    		throw new Exception("Failed to get members of same name:" + e.getMessage());
    	}
    }
    
//  PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name = ?;");
//  ps.setString(1, member.getName());
//  ResultSet resultSet = ps.executeQuery();
//  
//  // already present?
//  while (resultSet.next()) {
//      Member m = generateMember(resultSet);
//      resultSet.close();
//      return false;
    
//    return false;
    
    public List<Member> getMembersWithChoiceId(String id) throws Exception {
    	List<Member> members = new ArrayList<>();
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE choiceId = ?;");
    		ps.setString(1, id);
    		ResultSet resultSet = ps.executeQuery();
    		
    		
    		while (resultSet.next()) {
    			Member m = generateMember(resultSet);
    			members.add(m);
    		}
    		resultSet.close();
    		ps.close();
    		return members;
    	} catch (Exception e) {
    		throw new Exception("Failed to get members of choiceId:" + e.getMessage());
    	}
    }
    
    public boolean addMember(Member member) throws Exception {
        try {
        	ChoicesDAO choiceDAO = new ChoicesDAO();
        	Choice c = choiceDAO.getChoice(member.getChoiceId());
        	int memberCountMax = c.getMemberCount();
        	if(getMembersWithChoiceId(member.getChoiceId()).size() >= memberCountMax) {
        		return false;
        	}
        	
        	List<Member> membersWithName = getMembersWithName(member.getName());
        	if(membersWithName.size() > 0) {
//        		if(!member.getHasPassword()) {
//        			return false;
//        		}
        	}
        	for(Member m : membersWithName) {
        		if(m.getChoiceId().equals(member.getChoiceId())) {
        			return false;
        		}
//        		if(m.getHasPassword() && m.getPassword().equals(member.getPassword())) {
//        			return false;
//        		}
        	}
        	
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (id, choiceId, name,password,hasPassword) values(?,?,?,?,?);");
            ps.setString(1, member.getId());
            ps.setString(2, member.getChoiceId());
            ps.setString(3,  member.getName());
            ps.setString(4,  member.getPassword());
            ps.setBoolean(5,  member.getHasPassword());
            ps.execute();
            return true;

        } catch (Exception e) {
            throw new Exception("Failed add member: " + e.getMessage());
        }
    }
    
    public List<Member> getAllMembers() throws Exception {
        
        List<Member> allMembers = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tblName + ";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Member m = generateMember(resultSet);
                allMembers.add(m);
            }
            resultSet.close();
            statement.close();
            return allMembers;

        } catch (Exception e) {
            throw new Exception("Failed in getting members: " + e.getMessage());
        }
    }
    

}






