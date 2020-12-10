package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestSelectApprovalRequest {
	@Test 
	public void testSelectApprovalRequestBasic()
	{
		SelectApprovalRequest req = new SelectApprovalRequest("name","altId","memberId");
		SelectApprovalRequest req2 = new SelectApprovalRequest();
		Assert.assertEquals(req.getName(),"name");
		Assert.assertEquals(req.getAlternativeId(),"altId");
		Assert.assertEquals(req.getMemberId(),"memberId");
		req.setName("name2");
		req.setAlternativeId("altId2");
		req.setMemberId("memberId2");
		Assert.assertEquals(req.getName(),"name2");
		Assert.assertEquals(req.getAlternativeId(),"altId2");
		Assert.assertEquals(req.getMemberId(),"memberId2");
		
	}
}


