package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestUnselectApprovalResponse {
	@Test
	public void testUnselectApprovalResponseBasic()
	{
		UnselectApprovalResponse response = new UnselectApprovalResponse(200);
		UnselectApprovalResponse response2 = new UnselectApprovalResponse(400,"failed");
		Assert.assertEquals(response.toString(),"success");
		Assert.assertEquals(response2.toString(),"ErrorResult(400, err=failed)");
	}
}
