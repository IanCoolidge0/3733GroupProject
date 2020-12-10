package com.quakec.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.quakec.model.Alternative;
import com.quakec.model.Approval;
import com.quakec.model.Feedback;
import com.quakec.model.Member;

public class FeedbackDAO {
	
	java.sql.Connection conn;

	final String tblName = "feedback";   // Exact capitalization

	public FeedbackDAO() {
		try  {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}
	
	private Feedback generateFeedback(ResultSet resultSet) throws Exception {
		String id =  resultSet.getString("id");
    	String alternativeId = resultSet.getString("alternativeId");
    	String memberId = resultSet.getString("memberId");
    	String memberName = resultSet.getString("memberName");
    	String contents = resultSet.getString("contents");
    	Timestamp timestamp  = resultSet.getTimestamp("datetime");
    	Date date = (Date) new java.util.Date(timestamp.getTime());
		return new Feedback(id,alternativeId,memberId,memberName,contents,date);
	}
	
	
	
	public Feedback getFeedback(String id) throws Exception {
		Feedback feedback = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE id=?;");
		ps.setString(1, id);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) feedback = generateFeedback(resultSet);
		resultSet.close();
		ps.close();
		
		return feedback;
	}
	
	public boolean deleteFeedback(String id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblName + " WHERE id=?;");
		ps.setString(1, id);
		
		return ps.execute();
	}
	
	public boolean updateFeedback(Feedback feedback, String newFeedback) throws Exception {
		PreparedStatement ps = conn.prepareStatement("UPDATE " + tblName + " SET contents=? WHERE id=?;");
		ps.setString(1, newFeedback);
		ps.setString(2, feedback.getId());
		
		return ps.execute();
	}
	
	public boolean addFeedback(Feedback feedback) throws Exception {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (id,alternativeId,memberId, memberName,contents,datetime) values(?,?,?,?);");
		
		ps.setString(1, feedback.getId());
		ps.setString(2,feedback.getAlternativeId());
		ps.setString(3, feedback.getMemberId());
		ps.setString(4, feedback.getMemberName());
		ps.setString(5, feedback.getContents());
		ps.setTimestamp(6, new Timestamp(feedback.getDatetime().getTime()));
		
		return ps.execute();
	}
	
	public List<Feedback> getAllFeedback() throws Exception {
		List<Feedback> feedback = new ArrayList<Feedback>();
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + ";");
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) feedback.add(generateFeedback(resultSet));
		resultSet.close();
		ps.close();
		
		return feedback;
	}
	
	
	public List<Feedback> getAllFeedbacklFromMember(String memberId) throws Exception {
		List<Feedback> feedback = new ArrayList<Feedback>();
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE memberId=?;");
		ps.setString(1, memberId);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) feedback.add(generateFeedback(resultSet));
		resultSet.close();
		ps.close();
		
		return feedback;
	}
	
	public List<Feedback> getAllFeedbackOnAlternative(String alternativeId) throws Exception {
		List<Feedback> feedback = new ArrayList<Feedback>();
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE alternativeId=?;");
		ps.setString(1, alternativeId);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) feedback.add(generateFeedback(resultSet));
		resultSet.close();
		ps.close();
		
		return feedback;
	}
	
	public List<Feedback> getAllFeedbackOnChoice(String choiceId) throws Exception {
		List<Feedback> feedback = new ArrayList<Feedback>();
		AlternativesDAO alternativesDAO = new AlternativesDAO();
		for(Alternative a : alternativesDAO.getAlternativesWithChoiceId(choiceId)) {
			feedback.addAll(getAllFeedbackOnAlternative(a.getId()));
		}
		return feedback;
	}

	public Feedback getFeedback(String memberId, String alternativeId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}




