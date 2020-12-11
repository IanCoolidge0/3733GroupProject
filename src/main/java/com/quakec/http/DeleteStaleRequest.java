package com.quakec.http;

public class DeleteStaleRequest {

    private int timeInMills;

    public DeleteStaleRequest() {

    }

    public DeleteStaleRequest(int timeInMills) {
        this.timeInMills = timeInMills;
    }

    public void setTimeInMills(int timeInMills) {
        this.timeInMills = timeInMills;
    }

    public int getTimeInMills() {
        return this.timeInMills;
    }
}
