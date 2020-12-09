package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.quakec.db.MembersDAO;
import com.quakec.http.RegisterMemberRequest;
import com.quakec.http.RegisterMemberResponse;
import com.quakec.model.Member;




public class RegisterMember implements RequestHandler<RegisterMemberRequest,RegisterMemberResponse> {
	LambdaLogger logger;

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public RegisterMember() {}

    // Test purpose only.
    RegisterMember(AmazonS3 s3) {
        this.s3 = s3;
    }
    

    
    private String createMember(String choiceId, String name, String password, Context context) throws Exception { 
    	if (logger != null) { logger.log("in createMember"); }
    	MembersDAO dao = new MembersDAO();
    	
    	Member m = new Member (choiceId, name, password);
    	if(dao.addMember(m))
    		return m.getId();
    	else return null;
    }

    

    @Override
    public RegisterMemberResponse handleRequest(RegisterMemberRequest req, Context context) {
    	context.getLogger().log("Received event: " + req);
        RegisterMemberResponse response;
        try {
        	String newId = createMember(req.getChoiceId(),req.getName(),req.getPassword(),context);
        	if(newId != null) {
        		response = new RegisterMemberResponse(req.getName()+" registered to "+req.getChoiceId(), newId,req.getChoiceId());		
        	} else {
        		response = new RegisterMemberResponse(req.getName(), 422);
        	}
        } catch (Exception e) {
        	response = new RegisterMemberResponse("Unable to register user: " + req.getName() + "(" +  e.getMessage()+")",400);
        }
        return response;
     }
}





