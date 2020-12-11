package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.quakec.db.ChoicesDAO;
import com.quakec.http.DeleteStaleRequest;
import com.quakec.http.DeleteStaleResponse;

public class DeleteStale implements RequestHandler<DeleteStaleRequest, DeleteStaleResponse> {
	private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public DeleteStale() {}

    // Test purpose only.
    DeleteStale(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public DeleteStaleResponse handleRequest(DeleteStaleRequest request, Context context) {
        // Get the object from the event and show its content type
        DeleteStaleResponse response;

        try {
            if (deleteStale(request.getTimeInMills())) {
                response = new DeleteStaleResponse();
            } else {
                response = new DeleteStaleResponse(403, "Delete Stale Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new DeleteStaleResponse(403, e.getMessage());
        }

        return response;
    }

    private boolean deleteStale(int timeInMillis) throws Exception {
        ChoicesDAO choiceDAO = new ChoicesDAO();

        return choiceDAO.deleteStaleChoices(timeInMillis);
    }
}
