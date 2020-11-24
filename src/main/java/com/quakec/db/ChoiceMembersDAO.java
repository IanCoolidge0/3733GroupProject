package com.quakec.db;

import java.sql.PreparedStatement;

import com.quakec.model.Member;

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


//
//    
//    
//    private Member generateMember(ResultSet resultSet) throws Exception {
//    	String name = resultSet.getString("name");
//    	String password = resultSet.getString("password");
//    	boolean hasPassword = resultSet.getBoolean("hasPwd");
//    	boolean registered = resultSet.getBoolean("registered");
//    	return new Member(name,password,hasPassword,registered);
//    	
//    }
//
//    public Member getMember(String name) throws Exception {
//    	try {
//    		Member member = null;
//    		PreparedStatement ps = conn.prepareStatement("SELECT* FROM " + tblName + " WHERE name=?;");
//    		ps.setString(1, name);
//    		ResultSet resultSet = ps.executeQuery();
//    		
//    		while (resultSet.next()) {
//    			member =  generateMember(resultSet);
//    		}
//    		resultSet.close();
//    		ps.close();
//    		return member;
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    		throw new Exception("Failed in getting member: " + e.getMessage());
//    	}
//    }
//    
//    public boolean deleteMember(Member member) throws Exception {
//        try {
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblName + " WHERE name = ?;");
//            ps.setString(1, member.getName());
//            int numAffected = ps.executeUpdate();
//            ps.close();
//            
//            return (numAffected == 1);
//
//        } catch (Exception e) {
//            throw new Exception("Failed to insert constant: " + e.getMessage());
//        }
//    }
//    
//    public boolean updateMemberRegistered(String name, boolean registered) throws Exception {
//        try {
//        	String query = "UPDATE " + tblName + " SET registered=? WHERE name=?;";
//        	PreparedStatement ps = conn.prepareStatement(query);
//            ps.setBoolean(1, registered);
//            ps.setString(2, name);
//            int numAffected = ps.executeUpdate();
//            ps.close();
//            
//            return (numAffected == 1);
//        } catch (Exception e) {
//            throw new Exception("Failed to update report: " + e.getMessage());
//        }
//    }
//    
//    public boolean addMember(Member member) throws Exception {
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name = ?;");
//            ps.setString(1, member.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Member m = generateMember(resultSet);
//                resultSet.close();
//                return false;
//            }
//
//            ps = conn.prepareStatement("INSERT INTO " + tblName + " (name,password,hasPwd,registered) values(?,?,?,?);");
//            ps.setString(1,  member.getName());
//            ps.setString(2,  member.getPassword());
//            ps.setBoolean(3,  member.getHasPassword());
//            ps.setBoolean(4,  member.getRegistered());
//            ps.execute();
//            return true;
//
//        } catch (Exception e) {
//            throw new Exception("Failed to insert constant: " + e.getMessage());
//        }
//    }
//    
//    public List<Member> getAllMembers() throws Exception {
//        
//        List<Member> allMembers = new ArrayList<>();
//        try {
//            Statement statement = conn.createStatement();
//            String query = "SELECT * FROM " + tblName + ";";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                Member m = generateMember(resultSet);
//                allMembers.add(m);
//            }
//            resultSet.close();
//            statement.close();
//            return allMembers;
//
//        } catch (Exception e) {
//            throw new Exception("Failed in getting constants: " + e.getMessage());
//        }
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    
//
//}







