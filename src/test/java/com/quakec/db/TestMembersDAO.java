package com.quakec.db;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.quakec.lambda.TestContext;
import com.quakec.model.Choice;
import com.quakec.model.Member;

public class TestMembersDAO {
	
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	@Test
	public void testMembersDAOBasic() throws Exception
	{
		java.sql.Connection conn = DatabaseUtil.connect();
		conn.prepareStatement("DELETE FROM member;").execute();
		Random rand = new Random();
		String id1 = String.valueOf(rand.nextInt(100000));
		String id2 = String.valueOf(rand.nextInt(100000));
		ChoicesDAO cD = new ChoicesDAO();
		Choice addChoice = new Choice(id1,"name","desc",2);
		cD.createChoice(addChoice,new TestContext());
		MembersDAO mD = new MembersDAO();
		Member addMember = new Member(id1,"George","password1");
		Member addMember2 = new Member(id1,"George","password2");
		Assert.assertEquals("",mD.addMember(addMember));
		Assert.assertEquals("Incorrect password for member.",mD.addMember(addMember2));
		Choice addChoice2 = new Choice(id2,"name","desc",2);
		cD.createChoice(addChoice2,new TestContext());
		Member addMember3 = new Member(id2,"George","password1");
		Member addMember4 = new Member(id2,"George","");
		Member addMember5 = new Member(id2,"George","password2");
		Assert.assertEquals("",mD.addMember(addMember3));
		Assert.assertEquals("",mD.addMember(addMember3));
		Assert.assertEquals("Incorrect password for member.",mD.addMember(addMember4));
		Assert.assertEquals("Incorrect password for member.",mD.addMember(addMember5));
		Member addMember6 = new Member(id1,"Brian","password2");
		Member addMember7 = new Member(id1,"Phill","password2");
		Assert.assertEquals("",mD.addMember(addMember6));
		Assert.assertEquals("Sorry, this choice is at its membership limit.",mD.addMember(addMember7));
		Assert.assertEquals(3,mD.getAllMembers().size());
		Member getMember = mD.getMember(addMember.getId());
		Assert.assertEquals(getMember.getId(), addMember.getId());
		Assert.assertEquals(getMember.getName(), addMember.getName());
		mD.deleteMember(getMember);
		getMember = mD.getMember(addMember.getId());
		Assert.assertEquals(null, getMember);
		
		
		
		
		
		
		
	}
}
