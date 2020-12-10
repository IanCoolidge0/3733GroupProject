package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestViewChoicesRequest {
	@Test 
	public void testViewChoicesRequestBasic()
	{
		ViewChoicesRequest req = new ViewChoicesRequest("choiceId","memberId");
		ViewChoicesRequest req2 = new ViewChoicesRequest();
		Assert.assertEquals(req.getChoiceId(),"choiceId");
		Assert.assertEquals(req.getMemberId(),"memberId");
		Assert.assertEquals(req.toString(),"ViewChoice( choiceId, memberId)");
		req.setChoiceId("choiceId2");
		req.setMemberId("memberId2");
		Assert.assertEquals(req.getChoiceId(),"choiceId2");
		Assert.assertEquals(req.getMemberId(),"memberId2");
		Assert.assertEquals(req.toString(),"ViewChoice( choiceId2, memberId2)");
		
	}

}


