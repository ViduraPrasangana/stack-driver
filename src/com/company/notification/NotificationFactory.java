package com.company.notification;

import com.company.log.Log;
import com.company.user.User;

public class NotificationFactory {
    public Notification getInstance(String type, User user, Log log){
        Notification notification;
        switch (type){
            case "email":
                notification = new EmailNotification(user,log);
                break;
            case "sms":
                notification = new SmsNotification(user,log);
                break;
            default:
                System.out.println("Unknown notification type");
                notification = null;
        }
        return notification;
    }
}
