package com.company.processor;

import com.company.application.Application;
import com.company.log.ErrorLog;
import com.company.log.Log;
import com.company.notification.Notification;
import com.company.notification.NotificationFactory;
import com.company.user.User;

import java.util.List;

public class ErrorProcessor implements Processor {


    @Override
    public void performProcess(List<Application> applications, NotificationFactory notificationFactory) {
        for (Application application : applications) {
            for (Log log : application.getLogs()) {
                if (log instanceof ErrorLog) {
                    for (User user : application.getUsers()) {
                        for (String notificationType : user.getNotificationTypes()) {
                            Notification notification = notificationFactory.getInstance(notificationType, user, log);
                            notification.sendNotification();
                        }
                    }
                }
            }
        }

    }


}


