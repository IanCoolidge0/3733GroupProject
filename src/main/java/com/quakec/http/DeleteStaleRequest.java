package com.quakec.http;

public class DeleteStaleRequest {

    private int timeInMills;
    public DeleteStaleRequest(int timeInMills) {
        this.timeInMills = timeInMills;
    }

    public int getTime() {
        return this.timeInMills;
    }
}
