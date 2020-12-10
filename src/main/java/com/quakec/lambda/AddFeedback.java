package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.AlternativesDAO;
import com.quakec.db.ChoicesDAO;
import com.quakec.db.FeedbackDAO;
import com.quakec.db.MembersDAO;
import com.quakec.http.AddFeedbackRequest;
import com.quakec.http.AddFeedbackResponse;
import com.quakec.http.SelectApprovalResponse;
import com.quakec.model.Alternative;
import com.quakec.model.Choice;
import com.quakec.model.Feedback;
import com.quakec.model.Member;

public class AddFeedback implements RequestHandler<AddFeedbackRequest, AddFeedbackResponse> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public AddFeedback() {}

    // Test purpose only.
    AddFeedback(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public AddFeedbackResponse handleRequest(AddFeedbackRequest req, Context context) {
        context.getLogger().log("Received event: " + req);

        AddFeedbackResponse response;
        MembersDAO membersDAO = new MembersDAO();
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        AlternativesDAO alternativesDAO = new AlternativesDAO();
        ChoicesDAO choicesDAO = new ChoicesDAO();
        
        try {
        	// first, check if the choice is completed already.
        	Alternative alt = alternativesDAO.getAlternative(req.getAlternativeId());
        	Choice choice = choicesDAO.getChoice(alt.getChoiceId());
        	
        	if(!choice.getChosenAlternative().equals("")) {
        		response = new AddFeedbackResponse(409, "Sorry, this choice has already been completed.");
        	} else {
	        	Member member = membersDAO.getMember(req.getMemberId());
	        	
	        	if(member != null) {
	        		Feedback existingFeedback = feedbackDAO.getFeedback(req.getMemberId(), req.getAlternativeId());
	        		
	        		if(existingFeedback != null) {
	        			feedbackDAO.updateFeedback(existingFeedback, req.getFeedback());
	        		} else {
	        			Feedback feedback = new Feedback(req.getAlternativeId(), req.getMemberId(), member.getName(), req.getFeedback());
	        			feedbackDAO.addFeedback(feedback);
	        		}
	        	}
	        	
	        	response = new AddFeedbackResponse(200);
        	}
        } catch(Exception e) {
        	response = new AddFeedbackResponse(400, e.getMessage());
        }
        
        
        return response;
    }
}