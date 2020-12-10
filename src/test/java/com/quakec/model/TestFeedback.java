package com.quakec.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestFeedback {
	@Test
	public void testFeedbackBasic()
	{
		Feedback feedback = new Feedback();
		Feedback feedback2 = new Feedback("altId","memberId","memberName","contents");
		Date datetime = new Date();
		Feedback feedback3 = new Feedback("id","altId","memberId","memberName","contents",datetime);
		feedback3.setId("id2");
		feedback3.setAlternativeId("altId2");
		feedback3.setMemberId("memberId2");
		feedback3.setMemberName("memberName2");
		feedback3.setContents("contents2");
		feedback3.setDatetime(datetime);
		Assert.assertEquals(feedback3.getId(),"id2");
		Assert.assertEquals(feedback3.getAlternativeId(),"altId2");
		Assert.assertEquals(feedback3.getMemberId(),"memberId2");
		Assert.assertEquals(feedback3.getMemberName(),"memberName2");
		Assert.assertEquals(feedback3.getContents(),"contents2");
		Assert.assertEquals(feedback3.getDatetime(),datetime);
		}
}

