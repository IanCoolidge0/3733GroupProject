package com.quakec.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestChoice {
	@Test
	public void testChoiceBasic()
	{
		Choice c1 = new Choice();
		Choice c2 = new Choice("id","name","desc",2);
		Date datetime = new Date();
		Choice c3 = new Choice("id","name","desc",datetime,2,false);
		c3.setId("id2");
		c3.setName("name2");
		c3.setDescription("desc2");
		c3.setDatetime(datetime);
		c3.setMemberCount(3);
		c3.setHasChosenAlternative(true);
		Assert.assertEquals(c3.getId(),"id2");
		Assert.assertEquals(c3.getDescription(),"desc2");
		Assert.assertEquals(c3.getDatetime(),datetime);
		Assert.assertEquals(c3.getMemberCount(),3);
		Assert.assertEquals(c3.getName(),"name2");
		Assert.assertEquals(c3.getHasChosenAlternative(),true);
		
	}
}



