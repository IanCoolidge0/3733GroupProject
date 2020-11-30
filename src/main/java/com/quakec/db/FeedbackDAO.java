package com.quakec.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	private Feedback generateFeedback() throws Exception {
		return new Feedback();
	}
	
	public Feedback getFeedback(String id) throws Exception {
		return new Feedback();
	}
	
	public boolean deleteFeedback(String id) throws Exception {
		return true;
	}
	
	public boolean updateFeedback() throws Exception {
		return true;
	}
	
	public boolean addFeedback(Feedback feedback) throws Exception {
		return true;
	}
	
	public List<Feedback> getAllFeedback() throws Exception {
		return new ArrayList<Feedback>();
	}
	
	public List<Feedback> getAllFeedbackFromMember(String memberName) throws Exception {
		return new ArrayList<Feedback>();
	}
	
	public List<Feedback> getAllFeedbackOnAlternative(String alternativeId) throws Exception {
		return new ArrayList<Feedback>();
	}
	
	public List<Feedback> getAllFeedbackOnChoice(String choiceId) throws Exception {
		return new ArrayList<Feedback>();
	}

}




