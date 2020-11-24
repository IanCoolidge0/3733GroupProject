package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
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

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public RegisterMember() {}

    // Test purpose only.
    RegisterMember(AmazonS3 s3) {
        this.s3 = s3;
    }
    
    boolean createMember(String name, String password) throws Exception{
    	MembersDAO dao = new MembersDAO();
    	
    	Member member = new Member(name,password);
    	return dao.addMember(member);
    	
    }

    @Override
    public RegisterMemberResponse handleRequest(RegisterMemberRequest req, Context context) {
        context.getLogger().log(req.toString());
        RegisterMemberResponse response;
        try {
        		if(createMember(req.getArg1(),req.getArg2())) {
        			response  = new RegisterMemberResponse(200);
        		} else {
        			response  = new RegisterMemberResponse(400);
        		}
        	} catch (Exception e) {
        		response  = new RegisterMemberResponse(400);
        	}
        return response;
     }

}
