package com.quakec.http;

import com.quakec.model.Choice;

import java.util.List;

public class DeleteStaleResponse {
    public int statusCode;
    public String errMessage;

    public DeleteStaleResponse (int statusCode, String errMessage) {
        this.statusCode = statusCode;
        this.errMessage = errMessage;
    }

    public DeleteStaleResponse () {
        this.statusCode = 200;
    }

    public String toString() {
        if (statusCode / 100 == 2) {  // too cute?
            return "It worked!";
        } else {
            return "ErrorResult(" + statusCode + ", err=" + errMessage + ")";
        }
    }
}
