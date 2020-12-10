package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestCreateChoiceResponse {
	@Test
	public void testCreateChoiceResponseBasic()
	{
		CreateChoiceResponse response = new CreateChoiceResponse(200);
		CreateChoiceResponse response2 = new CreateChoiceResponse(400,"failed");
		Assert.assertEquals(response.toString(),"It worked!");
		Assert.assertEquals(response2.toString(),"ErrorResult(400, err=failed)");
	}
}
