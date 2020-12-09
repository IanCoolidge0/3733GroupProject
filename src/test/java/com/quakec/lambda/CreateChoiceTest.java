package com.quakec.lambda;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.quakec.http.CreateChoiceRequest;
import com.quakec.http.CreateChoiceResponse;

public class CreateChoiceTest {
	
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	void testInput(String incoming, String outgoing) throws IOException {
		CreateChoice createChoice = new CreateChoice();
		CreateChoiceRequest req = new Gson().fromJson(incoming, CreateChoiceRequest.class);
		CreateChoiceResponse response = createChoice.handleRequest(req, createContext("compute"));

		Assert.assertEquals(outgoing, response.error);
		Assert.assertEquals(200, response.statusCode);
	}
	
	void testFailInput(String incoming, String outgoing) throws IOException {
		CreateChoice createChoice = new CreateChoice();
		CreateChoiceRequest req = new Gson().fromJson(incoming, CreateChoiceRequest.class);

		CreateChoiceResponse response = createChoice.handleRequest(req, createContext("compute"));

		Assert.assertEquals(400, response.statusCode);
	}
	
	@Test
	public void testCreateChoiceSuccess() {
		String SAMPLE_INPUT_STRING = "{\"title\": \"Project\", \"description\": \"project description\", \"alternatives\": [\"Project 1\",\"Project 2\",\"Project 3\"],\"id\": \"21111111-1121-1111-1111-111111121111\",\"memberCount\": \"2\"}";
		String RESULT = "It worked!";

		try {
			testInput(SAMPLE_INPUT_STRING, RESULT);
		} catch (IOException ioe) {
			Assert.fail("Invalid:" + ioe.getMessage());
		}
	}

}


