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

    		Member member = null;
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE id=?;");
    		ps.setString(1, id);
    		ResultSet resultSet = ps.executeQuery();
    		
    		while (resultSet.next()) {
    			member =  generateMember(resultSet);
    		}
    		
    		resultSet.close();
    		ps.close();
    		return member;
 
    }
    
    public boolean deleteMember(Member member) throws Exception {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblName + " WHERE id = ?;");
            ps.setString(1, member.getId());
            int numAffected = ps.executeUpdate();
            ps.close();
            
            return (numAffected == 1);

    }
    
    public List<Member> getMembersWithName(String name) throws Exception {
    	List<Member> members = new ArrayList<>();
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
    }
    

    
    public List<Member> getMembersWithChoiceId(String id) throws Exception {
    	List<Member> members = new ArrayList<>();

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

    }
    
    public String addMember(Member member) throws Exception {

        	ChoicesDAO choiceDAO = new ChoicesDAO();
        	Choice c = choiceDAO.getChoice(member.getChoiceId());
        	
        	List<Member> membersWithName = getMembersWithName(member.getName());
        	
        	for(Member m : membersWithName) {
        		if(m.getChoiceId().equals(member.getChoiceId())) {
        			if(!m.getHasPassword() || m.getPassword().equals(member.getPassword())) {
        				return "";
        			} else {
        				return "Incorrect password for member.";
        			}
        		}
        	}
        	
        	int memberCountMax = c.getMemberCount();
        	if(getMembersWithChoiceId(member.getChoiceId()).size() >= memberCountMax) {
        		return "Sorry, this choice is at its membership limit.";
        	}
        	
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (id, choiceId, name,password,hasPassword) values(?,?,?,?,?);");
            ps.setString(1, member.getId());
            ps.setString(2, member.getChoiceId());
            ps.setString(3,  member.getName());
            ps.setString(4,  member.getPassword());
            ps.setBoolean(5,  member.getHasPassword());
            ps.execute();
            return "";


    }
    
    public List<Member> getAllMembers() throws Exception {
        
        List<Member> allMembers = new ArrayList<>();

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

    }
    

}






