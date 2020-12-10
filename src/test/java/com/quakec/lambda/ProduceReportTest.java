package com.quakec.lambda;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.quakec.http.ProduceReportRequest;
import com.quakec.http.ProduceReportResponse;


public class ProduceReportTest {
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	void testInput(String incoming, String outgoing) throws IOException {
		ProduceReport produceReport = new ProduceReport();
		ProduceReportRequest req = new Gson().fromJson(incoming, ProduceReportRequest.class);
		ProduceReportResponse response = produceReport.handleRequest(req, createContext("compute"));

		Assert.assertEquals(outgoing, response.errMessage);
		Assert.assertEquals(200, response.statusCode);
	}
	
	@Test
	public void testProduceReportSuccess() {
		String SAMPLE_INPUT_STRING = "";
		String RESULT = "";

		try {
			testInput(SAMPLE_INPUT_STRING, RESULT);
		} catch (IOException ioe) {
			Assert.fail("Invalid:" + ioe.getMessage());
		}
	}
}
