package com.itdhub.newprojet.service.NosServices;

import org.springframework.mail.MailException;

public class NotificationException extends Throwable {
    public NotificationException(String s, MailException e) {

    }
}
