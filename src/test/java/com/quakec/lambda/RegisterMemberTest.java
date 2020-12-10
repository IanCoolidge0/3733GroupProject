package com.quakec.lambda;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.quakec.http.CreateChoiceRequest;
import com.quakec.http.CreateChoiceResponse;
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
	
//	void testFailInput(String incoming, String outgoing) throws IOException {
//		RegisterMember registerMember = new RegisterMember();
//		RegisterMemberRequest req = new Gson().fromJson(incoming, RegisterMemberRequest.class);
//		RegisterMemberResponse response = registerMember.handleRequest(req, createContext("compute"));
//
//		Assert.assertTrue(response.httpCode != 200);
//	}
	
//	@Test
//	public void testRegisterMemberSuccess() {
//		
//		String SAMPLE_INPUT_STRING = "{\"choiceId\": \"11111111-1111-1111-1111-111111111111\", \"name\": \"Ray\",\"password\": \"\"}";
//		String RESULT = "Ray registered to 11111111-1111-1111-1111-111111111111";
//
//		try {
//			testInput(SAMPLE_INPUT_STRING, RESULT);
//		} catch (IOException ioe) {
//			Assert.fail("Invalid:" + ioe.getMessage());
//		}
//	}

}



