package com.quakec.lambda;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.AlternativesDAO;
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
        	
        	if(createChoice(req.getTitle(), req.getDescription(), req.getAlternatives(), req.getId(), context)) {
        		response = new CreateChoiceResponse(200);
        	} else {
        		response = new CreateChoiceResponse(400);
        	}
        } catch(Exception e) {
        	response = new CreateChoiceResponse(400);
        }
        
        return response;
    }

	private boolean createChoice(String title, String description, List<String> alternatives, String id, Context ctx) throws Exception {
		ChoicesDAO choiceDAO = new ChoicesDAO();
		AlternativesDAO altDAO = new AlternativesDAO();
		
		ctx.getLogger().log("after DAO constructors");
		
		boolean success = true;
		
		Choice choice = new Choice(title, description, 0, id);

		choiceDAO.createChoice(choice, ctx);
		
		ctx.getLogger().log("after createChoice");
		
		for(int i = 0; i < alternatives.size(); i++) {
			String alternName = alternatives.get(i);
			Alternative altern = new Alternative(alternName, i + 1, id);

			altDAO.createAlternative(altern);
			
			ctx.getLogger().log("after createAlternative " + i);
		}
		
		return success;
	}
    
    
}


