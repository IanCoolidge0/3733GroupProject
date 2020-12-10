package com.quakec.http;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.quakec.model.Choice;

public class TestProduceReportResponse {
	@Test
	public void testProduceReportResponseBasic()
	{
		List<Choice> choices = new ArrayList<Choice>();
		ProduceReportResponse response = new ProduceReportResponse(choices);
		Assert.assertEquals(response.getChoices(),choices);
		ProduceReportResponse response2 = new ProduceReportResponse(400,"failed");
		Assert.assertEquals(response.toString(),"It worked!");
		Assert.assertEquals(response2.toString(),"ErrorResult(400, err=failed)");
	}
}
