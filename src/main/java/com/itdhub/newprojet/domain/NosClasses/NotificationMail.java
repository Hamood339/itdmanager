package com.itdhub.newprojet.domain.NosClasses;

public class NotificationMail {
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String to;
    String subject;
    String text;

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    String From;

    public NotificationMail() {
    }

    public NotificationMail(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }


}
