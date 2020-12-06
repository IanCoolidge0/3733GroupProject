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
    public ProduceReportResponse handleRequest(ProduceReportRequest request, Context context) throws Exception {
        /*
        - create producereportresponse
        - using daos, get all info that would be in report
        -
         */
        // Get the object from the event and show its content type
        ProduceReportResponse response;

        int i;
        List<Choice> choices = getChoices();
        List<String> choiceNames = new ArrayList<String>();
        List<String> ids = new ArrayList<String>();
        List<String> dates = new ArrayList<String>();
        List<Boolean> completed = new ArrayList<Boolean>();

        try {
            Choice currentChoice;
            for (i = 0; i < choices.size(); i++) {
                currentChoice = choices.get(i);
                choiceNames.add(currentChoice.getName());
                ids.add(currentChoice.getId());
                dates.add(currentChoice.getDatetime().toString());
                //TODO make this add completed state of choice
                completed.add(false);
            }
            response = new ProduceReportResponse(choiceNames, ids, dates, completed);
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