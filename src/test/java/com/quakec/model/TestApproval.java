package com.quakec.model;

import org.junit.Assert;
import org.junit.Test;

public class TestApproval {
	@Test
	public void testApprovalBasic()
	{
		Approval ap1 = new Approval("alternativeId","memberId","memberName",true);
		Approval ap2 = new Approval("id","alternativeId","memberId","memberName",true);
		Approval ap3 = new Approval();
		ap2.setId("id2");
		ap2.setAlternativeId("alternativeId2");
		ap2.setApproval(false);
		ap2.setMemberId("memberId2");
		ap2.setMemberName("name2");
		ap2.setIsApproval(false);
		
		Assert.assertEquals(ap2.getId(),"id2");
		Assert.assertEquals(ap2.getAlternativeId(),"alternativeId2");
		Assert.assertEquals(ap2.getMemberId(),"memberId2");
		Assert.assertEquals(ap2.getMemberName(),"name2");
		Assert.assertEquals(ap2.getIsApproval(),false);
	
	}
}



