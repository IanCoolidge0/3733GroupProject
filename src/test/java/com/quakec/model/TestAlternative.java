package com.quakec.model;

import org.junit.Assert;
import org.junit.Test;

public class TestAlternative {
	@Test
	public void testAlternativeBasic()
	{
		Alternative alt1 = new Alternative("choiceId","name",1);
		Alternative alt2 = new Alternative("id","choiceId","name",1);
		Alternative alt3 = new Alternative();
		alt2.setId("id2");
		alt2.setChoiceId("choiceId2");
		alt2.setName("name2");
		alt2.setNumber(2);
		Assert.assertEquals(alt2.getId(),"id2");
		Assert.assertEquals(alt2.getChoiceId(),"choiceId2");
		Assert.assertEquals(alt2.getName(),"name2");
		Assert.assertEquals(alt2.getNumber(),2);
	}
}


