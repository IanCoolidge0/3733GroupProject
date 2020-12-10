package com.quakec.http;


import org.junit.Assert;
import org.junit.Test;


public class TestUnselectApprovalRequest {

	@Test 
	public void testSelectApprovalRequestBasic()
	{
		UnselectApprovalRequest req = new UnselectApprovalRequest("name","altId","memberId");
		UnselectApprovalRequest req2 = new UnselectApprovalRequest();
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


