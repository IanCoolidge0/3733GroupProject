package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.AlternativesDAO;
import com.quakec.db.ChoiceAlternativesDAO;
import com.quakec.db.ChoicesDAO;
import com.quakec.http.CreateChoiceRequest;
import com.quakec.http.CreateChoiceResponse;
import com.quakec.model.Alternative;
import com.quakec.model.Choice;

public class CreateChoice implements RequestHandler<CreateChoiceRequest, CreateChoiceResponse> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public CreateChoice() {}

    // Test purpose only.
    CreateChoice(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public CreateChoiceResponse handleRequest(CreateChoiceRequest req, Context context) {
        context.getLogger().log("Received event: " + req);
    
        CreateChoiceResponse response;
        
        try {
        	if(createChoice(req.getTitle(), req.getDescription(), req.getAlternatives())) {
        		response = new CreateChoiceResponse(201);
        	} else {
        		response = new CreateChoiceResponse(400);
        	}
        } catch(Exception e) {
        	response = new CreateChoiceResponse(400);
        }
        
        return response;
    }

	private boolean createChoice(String title, String description, String[] alternatives) throws Exception {
		ChoicesDAO choiceDAO = new ChoicesDAO();
		AlternativesDAO altDAO = new AlternativesDAO();
		ChoiceAlternativesDAO chAltDAO = new ChoiceAlternativesDAO();
		
		boolean success = true;
		
		Choice choice = new Choice(title, description, 0);
		choiceDAO.createChoice(choice);
		
		for(int i = 0; i < alternatives.length; i++) {
			String alternName = alternatives[i];
			
			Alternative altern = new Alternative(alternName, i + 1);
			altDAO.createAlternative(altern);
			chAltDAO.addAlternativeToChoice(choice.getId(), altern.getId());
		}
		
		return success;
	}
    
    
}


