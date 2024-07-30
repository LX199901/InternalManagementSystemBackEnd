package com.cms.common.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImsResponse<T> {
    private String message;
    private boolean status;
    private List<T> results;

    public ImsResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    public ImsResponse(boolean status) {
        this.status = status;
    }

    public ImsResponse(List<T> results) {
    	this.status = true;
    	this.message = "";
        this.results = results;
    }
    
    @JsonProperty
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @JsonProperty
    public List<T> getResults() {
        return this.results;
    }
}
