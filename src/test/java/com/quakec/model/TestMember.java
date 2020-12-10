package com.quakec.model;

import org.junit.Assert;
import org.junit.Test;

public class TestMember {
	@Test
	public void testMemberBasic()
	{
		Member member = new Member("choiceId","name","");
		Member member2 = new Member("choiceId","name","password");
		Member member3 = new Member("memberId","choiceId","name","password",true);
		Member member4 = new Member();
		Assert.assertEquals(member3.getId(),"memberId");
		Assert.assertEquals(member3.getChoiceId(),"choiceId");
		Assert.assertEquals(member3.getName(),"name");
		Assert.assertEquals(member3.getPassword(),"password");
		Assert.assertEquals(member3.getHasPassword(),true);
	}
}


