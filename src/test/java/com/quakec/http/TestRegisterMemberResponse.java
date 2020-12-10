package com.quakec.http;

import org.junit.Assert;
import org.junit.Test;

public class TestRegisterMemberResponse {
	@Test
	public void testRegisterMemberResponseBasic()
	{
		RegisterMemberResponse response = new RegisterMemberResponse("failed",400,"memberId","choiceId");
		RegisterMemberResponse response2 = new RegisterMemberResponse("","memberId","choiceId");
		RegisterMemberResponse response3 = new RegisterMemberResponse("",200);
		Assert.assertEquals(response.toString(),"Response(failed)");
		Assert.assertEquals(response.getChoiceId(),"choiceId");
		Assert.assertEquals(response.getMemberId(),"memberId");
		response.setChoiceId("choiceId2");
		response.setMemberId("memberId2");
		Assert.assertEquals(response.getChoiceId(),"choiceId2");
		Assert.assertEquals(response.getMemberId(),"memberId2");

	}
}




