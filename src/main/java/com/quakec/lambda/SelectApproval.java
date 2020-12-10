package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.quakec.db.AlternativesDAO;
import com.quakec.db.ApprovalDAO;
import com.quakec.db.ChoicesDAO;
import com.quakec.db.MembersDAO;
import com.quakec.http.SelectApprovalRequest;
import com.quakec.http.SelectApprovalResponse;
import com.quakec.model.Alternative;
import com.quakec.model.Approval;
import com.quakec.model.Choice;
import com.quakec.model.Member;

public class SelectApproval implements RequestHandler<SelectApprovalRequest, SelectApprovalResponse> {

    public SelectApproval() {}

    @Override
    public SelectApprovalResponse handleRequest(SelectApprovalRequest req, Context context) {
        context.getLogger().log("Received SelectApproval event: " + req);

    	SelectApprovalResponse response;
    	MembersDAO membersDAO = new MembersDAO();
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	AlternativesDAO alternativesDAO = new AlternativesDAO();
    	ChoicesDAO choicesDAO = new ChoicesDAO();
    	
        try {
        	// first, check if the choice is completed already.
        	Alternative alt = alternativesDAO.getAlternative(req.getAlternativeId());
        	Choice choice = choicesDAO.getChoice(alt.getChoiceId());
        	
        	if(!choice.getChosenAlternative().equals("")) {
        		response = new SelectApprovalResponse(409, "Sorry, this choice has already been completed.");
        	} else {
	        	Member member = membersDAO.getMember(req.getMemberId());
	        	if(member != null) {
	        		Approval existingApproval = approvalDAO.tryGetExistingApproval(req.getAlternativeId(), req.getMemberId());
	        		
	        		if(existingApproval != null) {
	        			approvalDAO.updateApproval(existingApproval, true);
	        		} else {
		        		Approval approval = new Approval(req.getAlternativeId(), req.getMemberId(), member.getName(), true);
		        		approvalDAO.addApproval(approval);
	        		}
	        		
	        		response = new SelectApprovalResponse(200);
	        	} else {
	        		response = new SelectApprovalResponse(400, "Member not found with given name: " + req.getName());
	        	}
        	}
        } catch(Exception e) {
        	response = new SelectApprovalResponse(400, "Unable to select approval: " + e.getMessage());
        }
        
        return response;
    }
}