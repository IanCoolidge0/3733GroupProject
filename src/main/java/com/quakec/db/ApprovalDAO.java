package com.quakec.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quakec.model.Alternative;
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
	
	private Approval generateApproval(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String alternativeId = rs.getString("alternativeId");
		String memberId = rs.getString("memberId");
		String memberName = rs.getString("memberName");
		boolean isApproval = rs.getBoolean("isApproval");
		
		return new Approval(id, alternativeId, memberId, memberName, isApproval);
	}
	
	
	public Approval getApproval(String id) throws Exception {
		Approval app = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE id=?;");
		ps.setString(1, id);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) app = generateApproval(resultSet);
		resultSet.close();
		ps.close();
		
		return app;
	}
	
	public boolean deleteApproval(String id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblName + " WHERE id=?;");
		ps.setString(1, id);
		
		return ps.execute();
	}
	
	public boolean updateApproval(Approval approval, boolean isApproval) throws Exception {
		PreparedStatement ps = conn.prepareStatement("UPDATE " + tblName + " SET isApproval=? WHERE id=?;");
		ps.setBoolean(1, isApproval);
		ps.setString(2, approval.getId());
		
		return ps.execute();
	}
	
	public boolean addApproval(Approval approval) throws Exception {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (id,alternativeId,memberId,memberName,isApproval) values(?,?,?,?,?);");
		
		ps.setString(1, approval.getId());
		ps.setString(2, approval.getAlternativeId());
		ps.setString(3, approval.getMemberId());
		ps.setString(4, approval.getMemberName());
		ps.setBoolean(5, approval.getIsApproval());
		
		return ps.execute();
	}
	

	
	public List<Approval> getAllApproval() throws Exception {
		List<Approval> approvals = new ArrayList<Approval>();
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + ";");
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) approvals.add(generateApproval(resultSet));
		resultSet.close();
		ps.close();
		
		return approvals;
	}
	
	public List<Approval> getAllApprovalFromMember(String memberId) throws Exception {
		List<Approval> approvals = new ArrayList<Approval>();
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE memberId=?;");
		ps.setString(1, memberId);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) approvals.add(generateApproval(resultSet));
		resultSet.close();
		ps.close();
		
		return approvals;
	}
	
	public List<Approval> getAllApprovalOnAlternative(String alternativeId) throws Exception {
		List<Approval> approvals = new ArrayList<Approval>();
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE alternativeId=?;");
		ps.setString(1, alternativeId);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) approvals.add(generateApproval(resultSet));
		resultSet.close();
		ps.close();
		
		return approvals;
	}
	
	
	public List<Approval> getAllApprovalOnChoice(String choiceId) throws Exception {
		List<Approval> approvals = new ArrayList<Approval>();
		AlternativesDAO alternativesDAO = new AlternativesDAO();
		for(Alternative a : alternativesDAO.getAlternativesWithChoiceId(choiceId)) {
			approvals.addAll(getAllApprovalOnAlternative(a.getId()));
		}
		return approvals;
	}

	public Approval tryGetExistingApproval(String alternativeId, String memberId) throws SQLException {
		Approval app = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE alternativeId=? AND memberId=?;");
		ps.setString(1, alternativeId);
		ps.setString(2, memberId);
		
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) app = generateApproval(resultSet);
		resultSet.close();
		ps.close();
		
		return app;
	}

}
