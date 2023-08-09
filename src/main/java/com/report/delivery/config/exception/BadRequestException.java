package com.report.delivery.config.exception;


import com.report.delivery.util.Message;

public class BadRequestException extends Exception {

    public BadRequestException(final String message) {
        super(Message.getMessage(message));
    }

    public BadRequestException(final String message, final Object... args) {
        super(Message.getMessage(message, args));
    }

}