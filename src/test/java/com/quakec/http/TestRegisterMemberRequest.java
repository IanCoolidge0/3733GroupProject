package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestRegisterMemberRequest {
	@Test
	public void testRegisterMemberRequestBasic()
	{
		RegisterMemberRequest req = new RegisterMemberRequest("choiceId","name","password");
		RegisterMemberRequest req2 = new RegisterMemberRequest();
		Assert.assertEquals(req.getChoiceId(), "choiceId");
		Assert.assertEquals(req.getName(),"name");
		Assert.assertEquals(req.getPassword(),"password");
		Assert.assertEquals(req.toString(),"Add(choiceId,name,password)");
		req.setChoiceId("choiceId2");
		req.setName("name2");
		req.setPassword("password2");
		Assert.assertEquals(req.getChoiceId(), "choiceId2");
		Assert.assertEquals(req.getName(),"name2");
		Assert.assertEquals(req.getPassword(),"password2");
		Assert.assertEquals(req.toString(),"Add(choiceId2,name2,password2)");
	}
}



