package com.quakec.http;

import com.quakec.model.Choice;

import java.util.List;

public class ProduceReportResponse {

    public int statusCode;
    public String errMessage;
    private List<Choice> choices;

    public ProduceReportResponse (int statusCode, String errMessage) {
        this.statusCode = statusCode;
        this.errMessage = errMessage;
    }
    public ProduceReportResponse (List<Choice> choices) {
        this.statusCode = 200;
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return this.choices;
    }

    public String toString() {
        if (statusCode / 100 == 2) {  // too cute?
            return "It worked!";
        } else {
            return "ErrorResult(" + statusCode + ", err=" + errMessage + ")";
        }
    }
}
