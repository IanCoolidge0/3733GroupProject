package com.quakec.db;

import java.util.Random;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.quakec.lambda.TestContext;
import com.quakec.model.Alternative;
import com.quakec.model.Choice;
import com.quakec.model.Member;

public class TestAlternativesDAO {
	
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	@Test
	public void testAlternativesDAOBasic() throws Exception{
		Random rand = new Random();
		String id1 = String.valueOf(rand.nextInt(100000));
		String id2 = String.valueOf(rand.nextInt(100000));
		ChoicesDAO cD = new ChoicesDAO();
		Choice addChoice = new Choice(id1,"name","desc",2);
		cD.createChoice(addChoice,new TestContext());
		MembersDAO mD = new MembersDAO();
		Member addMember = new Member(id1,"Gill","password1");
		mD.addMember(addMember);
		AlternativesDAO altD = new AlternativesDAO();
		Alternative alt1 = new Alternative(id1,"alt1",1);
		Alternative alt2 = new Alternative(id1,"alt2",2);
		altD.createAlternative(alt1);
		altD.createAlternative(alt2);
		Assert.assertEquals(alt1.getId(),altD.getAlternative(alt1.getId()).getId());
		Assert.assertEquals(alt1.getName(),altD.getAlternative(alt1.getId()).getName());
		Assert.assertEquals(alt2.getNumber(),altD.getAlternative(alt2.getId()).getNumber());
		Assert.assertEquals(2,altD.getAlternativesWithChoiceId(id1).size());
		altD.removeAlternative(alt2.getId());
		Assert.assertEquals(1,altD.getAlternativesWithChoiceId(id1).size());
		cD.completeChoice(id1, alt1.getId());
		Assert.assertEquals(cD.getChoice(id1).getChosenAlternative(), alt1.getId());
	}

}

