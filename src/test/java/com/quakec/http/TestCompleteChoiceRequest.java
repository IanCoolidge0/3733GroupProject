package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestCompleteChoiceRequest {
	@Test
	public void testCompleteChoiceRequestBasic()
	{
		CompleteChoiceRequest req = new CompleteChoiceRequest();
		CompleteChoiceRequest req2 = new CompleteChoiceRequest("choiceId","altId");
		req2.setChoiceId("choiceId2");
		req2.setAlternativeId("altId2");
		Assert.assertEquals(req2.getChoiceId(),"choiceId2");
		Assert.assertEquals(req2.getAlternativeId(),"altId2");
	}
}

