package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestSelectApprovalResponse {
	@Test
	public void testSelectApprovalResponseBasic()
	{
		SelectApprovalResponse response = new SelectApprovalResponse(200);
		SelectApprovalResponse response2 = new SelectApprovalResponse(400,"failed");
		Assert.assertEquals(response.toString(),"success");
		Assert.assertEquals(response2.toString(),"ErrorResult(400, err=failed)");
	}
}
