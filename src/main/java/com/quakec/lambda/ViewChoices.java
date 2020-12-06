package com.quakec.lambda;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.quakec.db.AlternativesDAO;
import com.quakec.db.ApprovalDAO;
import com.quakec.db.ChoicesDAO;
import com.quakec.db.MembersDAO;
import com.quakec.http.ViewChoicesRequest;
import com.quakec.http.ViewChoicesResponse;
import com.quakec.model.Alternative;
import com.quakec.model.Approval;
import com.quakec.model.Choice;
import com.quakec.model.Member;

public class ViewChoices implements RequestHandler<ViewChoicesRequest, ViewChoicesResponse> {
	private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public ViewChoices() {}

    // Test purpose only.
    ViewChoices(AmazonS3 s3) {
        this.s3 = s3;
    }
	
	@Override
    public ViewChoicesResponse handleRequest(ViewChoicesRequest req, Context context) {
        context.getLogger().log("Received event: " + req);
        ViewChoicesResponse response;
        // Get the object from the event and show its content type
        String choiceId = req.getChoiceId();
        String memberId = req.getMemberId();
        try {
        	ChoicesDAO choicesDAO = new ChoicesDAO();
        	MembersDAO membersDAO = new MembersDAO();
        	AlternativesDAO alternativesDAO = new AlternativesDAO();
        	ApprovalDAO approvalDAO = new ApprovalDAO();
        	Choice choice = choicesDAO.getChoice(choiceId);
        	
        	List<Member> members = membersDAO.getMembersWithChoiceId(choiceId);
        	List<Alternative> alternatives = alternativesDAO.getAlternativesWithChoiceId(choiceId);
        	List<Approval> approvals = approvalDAO.getAllApprovalOnChoice(choiceId);
        	response = new ViewChoicesResponse(choice,alternatives,approvals,members);
        	
//        	response = new ViewChoicesResponse()
        } catch (Exception e) {
        	response = new ViewChoicesResponse(400,"things broke");
        }
        return response;
    }
}
