package com.quakec.db;

import java.util.ArrayList;
import java.util.List;

import com.quakec.model.Approval;
import com.quakec.model.Feedback;

public class ApprovalDAO {
	
	java.sql.Connection conn;

	final String tblName = "approval";   // Exact capitalization

	public ApprovalDAO() {
		try  {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}
	
	private Approval generateApproval() throws Exception {
		return new Approval();
	}
	
	public Approval getApproval(String id) throws Exception {
		return new Approval();
	}
	
	public boolean deleteApproval(String id) throws Exception {
		return true;
	}
	
	public boolean updateApproval() throws Exception {
		return true;
	}
	
	public boolean addApproval(Approval approval) throws Exception {
		return true;
	}
	
	public List<Approval> getAllApproval() throws Exception {
		return new ArrayList<Approval>();
	}
	
	public List<Approval> getAllApprovalFromMember(String memberName) throws Exception {
		return new ArrayList<Approval>();
	}
	
	public List<Approval> getAllApprovalOnAlternative(String alternativeId) throws Exception {
		return new ArrayList<Approval>();
	}
	
	public List<Approval> getAllApprovalOnChoice(String choiceId) throws Exception {
		return new ArrayList<Approval>();
	}

}
