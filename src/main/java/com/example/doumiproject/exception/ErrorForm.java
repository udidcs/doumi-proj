package com.example.doumiproject.exception;

import lombok.Data;

@Data
public class ErrorForm {

    String errormsg;
    int errorcode;

    public ErrorForm(String errormsg, int errorcode) {
        this.errormsg = errormsg;
        this.errorcode = errorcode;
    }
}
