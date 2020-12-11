package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.quakec.db.ChoicesDAO;
import com.quakec.http.DeleteStaleRequest;
import com.quakec.http.DeleteStaleResponse;
import com.quakec.http.ProduceReportRequest;
import com.quakec.http.ProduceReportResponse;
import com.quakec.model.Choice;

import java.util.List;

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
            if (deleteStale(request.getTime())) {
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
