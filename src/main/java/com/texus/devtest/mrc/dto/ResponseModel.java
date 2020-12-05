package com.texus.devtest.mrc.dto;

public class ResponseModel <E> {
    private int statusCode;
    private String statusDescription;
    private E response;

    public ResponseModel() {

    }

    public ResponseModel(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    public ResponseModel(int statusCode, String statusDescription, E entity) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.response = entity;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public E getResponse() {
        return response;
    }

    public void setResponse(E entity) {
        this.response = entity;
    }
}

