package com.quakec.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.quakec.db.ChoicesDAO;
import com.quakec.http.ProduceReportRequest;
import com.quakec.http.ProduceReportResponse;
import com.quakec.model.Choice;

import java.util.ArrayList;
import java.util.List;

public class ProduceReport implements RequestHandler<ProduceReportRequest, ProduceReportResponse> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public ProduceReport() {}

    // Test purpose only.
    ProduceReport(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public ProduceReportResponse handleRequest(ProduceReportRequest request, Context context) {
        // Get the object from the event and show its content type
        ProduceReportResponse response;

        try {
            List<Choice> choices = getChoices();
            response = new ProduceReportResponse(choices);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ProduceReportResponse(403, e.getMessage());
        }
        return response;
    }

    private List<Choice> getChoices() throws Exception {
        ChoicesDAO choiceDAO = new ChoicesDAO();

        return choiceDAO.getAllChoices();
    }
}