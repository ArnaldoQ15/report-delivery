package com.report.delivery.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Component
public class Message {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(final MessageSource messageSource) {
        Message.messageSource = messageSource;
    }

    public static String getMessage(final String message, final Object... args) {
        try {
            return messageSource.getMessage(message, args, getLocale());
        } catch (final Exception e) {
            return message;
        }
    }

    public static String getMessage(final String message) {
        try {
            return messageSource.getMessage(message, null, getLocale());
        } catch (final Exception e) {
            return message;
        }
    }

}