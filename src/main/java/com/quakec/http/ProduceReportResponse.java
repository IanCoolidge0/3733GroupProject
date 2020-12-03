package com.quakec.http;

public class ProduceReportResponse {
    public int statusCode;
    public String error;

    public ProduceReportResponse (int statusCode) {
        this.statusCode = statusCode;
        this.error = "";
    }

    public ProduceReportResponse (int statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.error = errorMessage;
    }

    public String toString() {
        if (statusCode / 100 == 2) {  // too cute?
            return "It worked!";
        } else {
            return "ErrorResult(" + statusCode + ", err=" + error + ")";
        }
    }
}
