package com.quakec.http;
import com.quakec.model.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestViewChoicesResponse {
	@Test
	public void testViewChoicesResponseBasic()
	{
		ViewChoicesResponse response = new ViewChoicesResponse(400,"failed");
		Choice choice = new Choice();
		List<Alternative> alternatives = new ArrayList<Alternative>();
		alternatives.add(new Alternative());
		List<Approval> approvals = new ArrayList<Approval>();
		approvals.add(new Approval());
		List<Member> members = new ArrayList<Member>();
		members.add(new Member());
<<<<<<< HEAD
		List<Feedback> feedback = new ArrayList<Feedback>();
		feedback.add(new Feedback());
		ViewChoicesResponse response2 = new ViewChoicesResponse(choice,alternatives,approvals,members,feedback);
=======
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		feedbacks.add(new Feedback());
		ViewChoicesResponse response2 = new ViewChoicesResponse(choice,alternatives,approvals,members,feedbacks);
>>>>>>> branch 'main' of https://github.com/IanCoolidge0/3733GroupProject.git
		Assert.assertEquals(response2.getChoice(),choice);
		Assert.assertEquals(response2.getAlternatives(),alternatives);
		Assert.assertEquals(response2.getApprovals(),approvals);
		Assert.assertEquals(response2.getMembers(),members);
		Assert.assertEquals(response.toString(),"ErrorResult(400, err=failed)");
		Assert.assertEquals(response2.toString(),"It worked!");
		
	}
}


