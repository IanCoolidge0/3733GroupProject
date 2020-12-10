package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestAddFeedbackResponse {
	@Test
	public void testAddFeedbackResponseBasic()
	{
		AddFeedbackResponse response = new AddFeedbackResponse(200);
		AddFeedbackResponse response2 = new AddFeedbackResponse(400,"failed");
		Assert.assertEquals(response.toString(),"success");
		Assert.assertEquals(response2.toString(),"ErrorResult(400, err=failed)");
	}
}
