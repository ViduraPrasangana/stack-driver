package com.company.notification;

import com.company.log.Log;
import com.company.user.User;

public class SmsNotification extends Notification {
    public SmsNotification(User user, Log log) {
        super(user, log);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending SMS to "+user.getPhone()+" : "+log.getMessage());
    }
}
