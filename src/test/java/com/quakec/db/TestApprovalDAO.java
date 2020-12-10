package com.quakec.db;

import java.sql.PreparedStatement;
import java.util.Random;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.TestContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.quakec.model.Alternative;
import com.quakec.model.Approval;
import com.quakec.model.Choice;
import com.quakec.model.Member;

public class TestApprovalDAO {
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	@Test
	public void testApprovalDAOBasic() throws Exception
	{
		Random rand = new Random();
		String id1 = String.valueOf(rand.nextInt(100000));
		String id2 = String.valueOf(rand.nextInt(100000));
		ChoicesDAO cD = new ChoicesDAO();
		Choice addChoice = new Choice(id1,"name","desc",2);
		cD.createChoice(addChoice,new TestContext());
		MembersDAO mD = new MembersDAO();
		Member addMember = new Member(id1,"Liam","password1");
		mD.addMember(addMember);
		AlternativesDAO altD = new AlternativesDAO();
		Alternative alt1 = new Alternative(id1,"alt1",1);
		Alternative alt2 = new Alternative(id1,"alt2",2);
		altD.createAlternative(alt1);
		altD.createAlternative(alt2);
		ApprovalDAO apD = new ApprovalDAO();
		Approval app1 = new Approval(alt1.getId(),addMember.getId(),addMember.getName(),true);
		apD.addApproval(app1);
		Assert.assertEquals(apD.getApproval(app1.getId()).getId(),app1.getId());
		apD.updateApproval(app1, false);
		Assert.assertEquals(apD.getApproval(app1.getId()).getIsApproval(),false);
		Assert.assertEquals(apD.getAllApproval().get(0).getId(),app1.getId());
		Assert.assertEquals(apD.getAllApprovalFromMember(addMember.getId()).get(0).getId(),app1.getId());
		Assert.assertEquals(apD.getAllApprovalOnAlternative(alt1.getId()).get(0).getId(),app1.getId());
		Assert.assertEquals(apD.getAllApprovalOnChoice(id1).get(0).getId(),app1.getId());
		Assert.assertEquals(apD.tryGetExistingApproval(alt1.getId(), addMember.getId()).getId(),app1.getId());
		apD.deleteApproval(app1.getId());
		Assert.assertEquals(apD.getAllApprovalFromMember(addMember.getId()).size(),0);
		
		
		
	}
}
//
//public Approval(String alternativeId, String memberId, String memberName, boolean isApproval) {
//	this(UUID.randomUUID().toString(),alternativeId,memberId,memberName,isApproval);
//}
//
//public boolean addApproval(Approval approval) throws Exception {
//	PreparedStatement ps = conn.prepareStatement("INSERT INTO " + tblName + " (id,alternativeId,memberId,memberName,isApproval) values(?,?,?,?,?);");
//	
//	ps.setString(1, approval.getId());
//	ps.setString(2, approval.getAlternativeId());
//	ps.setString(3, approval.getMemberId());
//	ps.setString(4, approval.getMemberName());
//	ps.setBoolean(5, approval.getIsApproval());
//	
//	return ps.execute();
//}

//
//		Feedback f = new Feedback(alt1.getId(),addMember.getId(),addMember.getName(),"comment");
//		FeedbackDAO fD = new FeedbackDAO();
//		fD.addFeedback(f);
//		Assert.assertEquals(fD.getFeedback(f.getId()).getId(),f.getId());
//		fD.deleteFeedback(f.getId());
//		Assert.assertEquals(fD.getFeedback(f.getId()),null);
//		fD.addFeedback(f);
//		Assert.assertEquals(fD.getAllFeedback().get(0).getId(),f.getId());
//		Assert.assertEquals(fD.getAllFeedbackFromMember(addMember.getId()).get(0).getId(),f.getId());
//		Assert.assertEquals(fD.getAllFeedbackOnAlternative(alt1.getId()).get(0).getId(),f.getId());
//		Assert.assertEquals(fD.getAllFeedbackOnChoice(id1).get(0).getId(),f.getId());
//		Assert.assertEquals(fD.getFeedback(addMember.getId(),alt1.getId()).getId(),f.getId());
//		fD.updateFeedback(f, "new comment");
//		Assert.assertEquals(fD.getFeedback(addMember.getId(),alt1.getId()).getContents(),"new comment");
//		
//	}
//
//}

//
//public Feedback(String alternativeId, String memberId, String memberName, String contents) {
//	this(UUID.randomUUID().toString(),alternativeId,memberId,memberName,contents,new Date());
//}