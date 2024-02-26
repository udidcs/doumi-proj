package com.example.doumiproject.exception;

public class ErrorForm {

    String errormsg;
    int errorcode;

    public ErrorForm(String errormsg, int errorcode) {
        this.errormsg = errormsg;
        this.errorcode = errorcode;
    }
}
