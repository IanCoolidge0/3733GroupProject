package com.quakec.lambda;

import java.io.IOException;

import org.junit.Assert;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.quakec.http.SelectApprovalRequest;
import com.quakec.http.SelectApprovalResponse;


public class SelectApprovalTest {
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	void testInput(String incoming, String outgoing) throws IOException {
		SelectApproval selectApproval = new SelectApproval();
		SelectApprovalRequest req = new Gson().fromJson(incoming, SelectApprovalRequest.class);
		SelectApprovalResponse response = selectApproval.handleRequest(req, createContext("compute"));

		Assert.assertEquals(outgoing, response.error);
		Assert.assertEquals(200, response.statusCode);
	}
	
	void testFailInput(String incoming, String outgoing) throws IOException {
		SelectApproval selectApproval = new SelectApproval();
		SelectApprovalRequest req = new Gson().fromJson(incoming, SelectApprovalRequest.class);
		SelectApprovalResponse response = selectApproval.handleRequest(req, createContext("compute"));

		Assert.assertTrue(response.statusCode != 200);
	}
}


