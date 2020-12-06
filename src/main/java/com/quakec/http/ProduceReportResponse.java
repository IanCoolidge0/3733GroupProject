package com.quakec.http;

import java.util.List;

public class ProduceReportResponse {

    public int statusCode;
    public String errMessage;
    private List<String> choiceNames;
    private List<String> ids;
    private List<String> dates;
    private List<Boolean> completed;

    public ProduceReportResponse (int statusCode, String errMessage) {
        this.statusCode = statusCode;
        this.errMessage = errMessage;
    }
    public ProduceReportResponse (List<String> choiceNames, List<String> ids, List<String> dates, List<Boolean> completed) {
        this.statusCode = 200;
        this.choiceNames = choiceNames;
        this.ids = ids;
        this.dates = dates;
        this.completed = completed;
    }

    public List<String> getChoiceNames() {
        return this.choiceNames;
    }

    public List<String> getDatess() {
        return this.dates;
    }

    public List<String> getIds() {
        return this.ids;
    }

    public List<Boolean> getCompleted() {
        return this.completed;
    }

    public String toString() {
        if (statusCode / 100 == 2) {  // too cute?
            return "It worked!";
        } else {
            return "ErrorResult(" + statusCode + ", err=" + error + ")";
        }
    }
}
