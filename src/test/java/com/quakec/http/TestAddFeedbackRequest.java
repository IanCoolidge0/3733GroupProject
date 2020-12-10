package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestAddFeedbackRequest {
	@Test 
	public void testAddFeedbackRequestBasic()
	{	
		AddFeedbackRequest req = new AddFeedbackRequest("name", "alternativeId", "memberId", "feedback");
		AddFeedbackRequest req2 = new AddFeedbackRequest();
		Assert.assertEquals(req.getName(),"name");
		Assert.assertEquals(req.getAlternativeId(),"alternativeId");
		Assert.assertEquals(req.getMemberId(),"memberId");
		Assert.assertEquals(req.getFeedback(),"feedback");
		req.setName("name2");
		req.setAlternativeId("alternativeId2");
		req.setMemberId("memberId2");
		req.setFeedback("feedback2");
		Assert.assertEquals(req.getName(),"name2");
		Assert.assertEquals(req.getAlternativeId(),"alternativeId2");
		Assert.assertEquals(req.getMemberId(),"memberId2");
		Assert.assertEquals(req.getFeedback(),"feedback2");
	}
}
