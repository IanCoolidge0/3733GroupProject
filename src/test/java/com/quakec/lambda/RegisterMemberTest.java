package com.quakec.lambda;

import java.io.IOException;

import org.junit.Assert;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.quakec.http.RegisterMemberRequest;
import com.quakec.http.RegisterMemberResponse;

public class RegisterMemberTest {
	
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	void testInput(String incoming, String outgoing) throws IOException {
		RegisterMember registerMember = new RegisterMember();
		RegisterMemberRequest req = new Gson().fromJson(incoming, RegisterMemberRequest.class);
		RegisterMemberResponse response = registerMember.handleRequest(req, createContext("compute"));

		Assert.assertEquals(outgoing, response.response);
		Assert.assertEquals(200, response.httpCode);
	}
	
	void testFailInput(String incoming, String outgoing) throws IOException {
		RegisterMember registerMember = new RegisterMember();
		RegisterMemberRequest req = new Gson().fromJson(incoming, RegisterMemberRequest.class);
		RegisterMemberResponse response = registerMember.handleRequest(req, createContext("compute"));

		Assert.assertTrue(response.httpCode != 200);
	}

}



