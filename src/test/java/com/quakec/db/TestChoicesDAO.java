package com.quakec.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.quakec.lambda.TestContext;
import com.quakec.model.Choice;



public class TestChoicesDAO {
	
	Context createContext(String apiCall) {
		TestContext ctx = new TestContext();
		ctx.setFunctionName(apiCall);
		return ctx;
	}
	
	@Test
	public void testChoicesDAOBasic() throws Exception {
		Random rand = new Random();
		String id = String.valueOf(rand.nextInt(100000));
		ChoicesDAO cD = new ChoicesDAO();
		Choice addChoice = new Choice(id,"name","desc",2);
		Assert.assertEquals(true,cD.createChoice(addChoice,new TestContext()));
		Choice foundChoice = cD.getChoice(id);
		Assert.assertEquals(addChoice.getId(),foundChoice.getId());
		Assert.assertEquals(addChoice.getName(),foundChoice.getName());
		Assert.assertEquals(addChoice.getDescription(),foundChoice.getDescription());
		Assert.assertEquals(addChoice.getMemberCount(),foundChoice.getMemberCount());
		String id2 = String.valueOf(rand.nextInt(100000));
		Choice addChoice2 = new Choice(id2,"name","desc",2);
		cD.createChoice(addChoice2,new TestContext());
		List<Choice> foundChoices = cD.getAllChoices();
		List<Choice> checkChoices = new ArrayList<Choice>();
		checkChoices.add(addChoice);
		checkChoices.add(addChoice2);
		int found = 0;
		for(Choice cFind : foundChoices) {
			for(Choice cOther : checkChoices) {
				if(cOther.getId().equals(cFind.getId()))  {
					found++;
				}
			}
		}
		Assert.assertEquals(2,found);
		
		
	}
	
}
