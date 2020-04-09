package com.marco.annotationssandbox.validation;

public class EmailUsageExample {

    @Email
    private String email;

    public EmailUsageExample(String email) {
        this.email = email;
    }
}
