package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.quakec.db.MembersDAO;
import com.quakec.http.RegisterMemberRequest;
import com.quakec.http.RegisterMemberResponse;
import com.quakec.model.Member;




public class RegisterMember implements RequestHandler<RegisterMemberRequest,RegisterMemberResponse> {
	LambdaLogger logger;

//    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public RegisterMember() {}

    // Test purpose only.
//    RegisterMember(AmazonS3 s3) {
//        this.s3 = s3;
//    }
    

    
    private Pair<String, Boolean> createMember(String choiceId, String name, String password, Context context) throws Exception { 
    	if (logger != null) { logger.log("in createMember"); }
    	MembersDAO dao = new MembersDAO();
    	
    	Member m = new Member (choiceId, name, password);
    	String result = dao.addMember(m);
    	if(result.equals(""))
    		return new Pair<String, Boolean>(m.getId(), true);
    	else return new Pair<String, Boolean>(result, false);
    }

    

    @Override
    public RegisterMemberResponse handleRequest(RegisterMemberRequest req, Context context) {
    	context.getLogger().log("Received event: " + req);
        RegisterMemberResponse response;
        try {
        	Pair<String, Boolean> newId = createMember(req.getChoiceId(),req.getName(),req.getPassword(),context);
        	if(newId.right) {
        		response = new RegisterMemberResponse(req.getName()+" registered to "+req.getChoiceId(), newId.left,req.getChoiceId());		
        	} else {
        		response = new RegisterMemberResponse(newId.left, 422);
        	}
        } catch (Exception e) {
        	response = new RegisterMemberResponse("Unable to register user: " + req.getName() + "(" +  e.getMessage()+")",400);
        }
        return response;
     }
}





