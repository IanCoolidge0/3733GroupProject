package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.ApprovalDAO;
import com.quakec.db.MembersDAO;
import com.quakec.http.SelectApprovalResponse;
import com.quakec.http.UnselectApprovalRequest;
import com.quakec.http.UnselectApprovalResponse;
import com.quakec.model.Approval;
import com.quakec.model.Member;

public class UnselectApproval implements RequestHandler<UnselectApprovalRequest, UnselectApprovalResponse> {

//    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public UnselectApproval() {}

    // Test purpose only.
//    UnselectApproval(AmazonS3 s3) {
//        this.s3 = s3;
//    }

    @Override
    public UnselectApprovalResponse handleRequest(UnselectApprovalRequest req, Context context) {
    	context.getLogger().log("Received SelectApproval event: " + req);

    	UnselectApprovalResponse response;
    	MembersDAO membersDAO = new MembersDAO();
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	
        try {
        	Member member = membersDAO.getMember(req.getName());
        	if(member != null) {
        		Approval existingApproval = approvalDAO.tryGetExistingApproval(req.getAlternativeId(), req.getName());
        		
        		if(existingApproval != null) {
        			approvalDAO.deleteApproval(existingApproval.getId());
        		} else {
        			response = new UnselectApprovalResponse(400, "Approval not found for given user: " + req.getName());
        		}
        		
        		response = new UnselectApprovalResponse(200);
        	} else {
        		response = new UnselectApprovalResponse(400, "Member not found with given name: " + req.getName());
        	}
        } catch(Exception e) {
        	response = new UnselectApprovalResponse(400, "Unable to select approval: " + e.getMessage());
        }
        
        return response;
	}
}
