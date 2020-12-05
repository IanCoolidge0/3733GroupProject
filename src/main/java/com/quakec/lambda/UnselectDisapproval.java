package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class UnselectApproval implements RequestHandler<UnselectApprovalRequest, UnselectApprovalRequestResponse> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public UnselectApproval() {}

    // Test purpose only.
    UnselectApproval(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public UnselectApprovalResponse handleRequest(UnselectApprovalRequest req, Context context) {
        context.getLogger().log("Received UnselectApproval event: " + req);
        
        UnselectApprovalResponse response:
        MembersDAO membersDAO = new MembersDAO();
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	
        try {
       		Member member = membersDAO.getMember(req.getName());
       		if(member != null) {
       			approvalDAO.updateApproval(existingApproval, true);
       		} else {
       			approvalDAO.deleteApproval(response);      			
       		}
       		response = new UnselectApprovalResponse(200);
       
       	} else {
       		response = new UnselectApprovalResponse(400, "Member not found with given name: " + req.getName());
       	}
    }catch (Execption e) {
    	response = new UnselectApprovalResponse(400, "Unable to unselect approval: " + e.getMessage());
    }
   	return response
	}
}
