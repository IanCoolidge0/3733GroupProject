package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.ChoicesDAO;
import com.quakec.http.CompleteChoiceRequest;
import com.quakec.http.CompleteChoiceResponse;

public class CompleteChoice implements RequestHandler<CompleteChoiceRequest, CompleteChoiceResponse> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public CompleteChoice() {}

    // Test purpose only.
    CompleteChoice(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public CompleteChoiceResponse handleRequest(CompleteChoiceRequest req, Context context) {
        context.getLogger().log("Received CompleteChoice event: " + req);

        CompleteChoiceResponse response;
        
        try {
	        ChoicesDAO choicesDAO = new ChoicesDAO();
	        if(choicesDAO.completeChoice(req.getChoiceId(), req.getAlternativeId())) {
	        	response = new CompleteChoiceResponse(200);
	        } else {
	        	response = new CompleteChoiceResponse(400, "Failed to complete choice.");
	        }
        } catch(Exception e) {
        	response = new CompleteChoiceResponse(400, e.getMessage());
        }
        
        return response;
    }
}