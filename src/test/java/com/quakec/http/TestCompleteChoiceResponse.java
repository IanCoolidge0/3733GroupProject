package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestCompleteChoiceResponse {
	@Test
	public void testCompleteChoiceResponse()
	{
		CompleteChoiceResponse response = new CompleteChoiceResponse(200);
		CompleteChoiceResponse response2 = new CompleteChoiceResponse(400,"Failed");
		Assert.assertEquals(response.statusCode,200);
		Assert.assertEquals(response.error,"");
		Assert.assertEquals(response2.statusCode,400);
		Assert.assertEquals(response2.error,"Failed");
		Assert.assertEquals(response.toString(),"It worked!");
		Assert.assertEquals(response2.toString(),"ErrorResult(400, err=Failed)");
	}
}

