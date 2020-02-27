package com.company.notification;

import com.company.log.Log;
import com.company.user.User;

public abstract class Notification {
    protected final User user;
    protected final Log log;

    public Notification(User user, Log log) {
        this.user = user;
        this.log = log;
    }

    abstract public void sendNotification();
}
