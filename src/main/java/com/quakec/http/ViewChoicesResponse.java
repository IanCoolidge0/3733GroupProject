package com.quakec.http;

import java.util.List;

import com.quakec.model.Alternative;
import com.quakec.model.Approval;
import com.quakec.model.Choice;
import com.quakec.model.Feedback;
import com.quakec.model.Member;

public class ViewChoicesResponse {
	//this is bad fix allthis
	public int statusCode;
    public String errMessage;
    private Choice choice;
    private List<Alternative> alternatives;
    private List<Approval> approvals;
    private List<Member> members;
    private List<Feedback> feedbacks;
    

    public ViewChoicesResponse (int statusCode, String errMessage) {
        this.statusCode = statusCode;
        this.errMessage = errMessage;
    }
    
    public ViewChoicesResponse (Choice choice, List<Alternative> alternatives, List<Approval> approvals,List<Member> members,List<Feedback> feedbacks) {
    	this.statusCode = 200;
    	this.choice = choice;
    	this.alternatives = alternatives;
    	this.approvals = approvals;
    	this.members = members;
    	this.feedbacks = feedbacks;
    }
    
    public Choice getChoice() {return choice;}
    
    public List<Alternative> getAlternatives() {return alternatives;}
    
    public List<Approval> getApprovals() {return approvals;}
    
    public List<Member> getMembers() {return members;}
    
    public List<Feedback> getFeedbacks() {return feedbacks;}
    
    public String toString() {
        if (statusCode / 100 == 2) {  // too cute?
            return "It worked!";
        } else {
            return "ErrorResult(" + statusCode + ", err=" + errMessage + ")";
        }
    }

}
