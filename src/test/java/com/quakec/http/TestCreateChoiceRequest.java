package com.quakec.http;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestCreateChoiceRequest {
	@Test 
	public void testCreateChoiceRequestBasic()
	{	
		List<String> alternatives = new ArrayList<String>();
		alternatives.add("alt1");
		CreateChoiceRequest req = new CreateChoiceRequest("title", "description", 2, alternatives, "id");
		CreateChoiceRequest req2 = new CreateChoiceRequest();
		Assert.assertEquals(req.getTitle(),"title");
		Assert.assertEquals(req.getDescription(),"description");
		Assert.assertEquals(req.getMemberCount(),2);
		Assert.assertEquals(req.getAlternatives(),alternatives);
		Assert.assertEquals(req.getId(),"id");
		Assert.assertEquals(req.toString(),"CreateChoice(title,description,2,alt1), id");
		req.setTitle("title2");
		req.setDescription("description2");
		req.setMemberCount(3);
		List<String> alternatives2 = new ArrayList<String>();
		alternatives2.add("alt2");
		alternatives2.add("alt3");
		req.setAlternatives(alternatives2);
		req.setId("id2");
		Assert.assertEquals(req.toString(),"CreateChoice(title2,description2,3,alt2,alt3), id2");
		Assert.assertEquals(req.getTitle(),"title2");
		Assert.assertEquals(req.getDescription(),"description2");
		Assert.assertEquals(req.getMemberCount(),3);
		Assert.assertEquals(req.getAlternatives(),alternatives2);
		Assert.assertEquals(req.getId(),"id2");
	}
	

}

