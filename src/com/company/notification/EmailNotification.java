package com.company.notification;

import com.company.log.Log;
import com.company.user.User;

public class EmailNotification extends Notification {
    public EmailNotification(User user, Log log) {
        super(user, log);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending Email to "+user.getEmail()+" : "+log.getMessage());

    }
}
