package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.ApprovalDAO;
import com.quakec.db.MembersDAO;
import com.quakec.http.SelectApprovalRequest;
import com.quakec.http.SelectApprovalResponse;
import com.quakec.model.Approval;
import com.quakec.model.Member;

public class SelectDisapproval implements RequestHandler<SelectApprovalRequest, SelectApprovalResponse> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public SelectDisapproval() {}

    // Test purpose only.
    SelectDisapproval(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public SelectApprovalResponse handleRequest(SelectApprovalRequest req, Context context) {
    	context.getLogger().log("Received SelectApproval event: " + req);

    	SelectApprovalResponse response;
    	MembersDAO membersDAO = new MembersDAO();
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	
        try {
        	Member member = membersDAO.getMember(req.getName());
        	if(member != null) {
        		Approval existingApproval = approvalDAO.tryGetExistingApproval(req.getAlternativeId(), req.getName());
        		
        		if(existingApproval != null) {
        			approvalDAO.updateApproval(existingApproval, false);
        		} else {
	        		Approval approval = new Approval(req.getAlternativeId(), req.getMemberId(), req.getName(), false);
	        		approvalDAO.addApproval(approval);
        		}
        		
        		response = new SelectApprovalResponse(200);
        	} else {
        		response = new SelectApprovalResponse(400, "Member not found with given name: " + req.getName());
        	}
        } catch(Exception e) {
        	response = new SelectApprovalResponse(400, "Unable to select approval: " + e.getMessage());
        }
        
        return response;
    }
}