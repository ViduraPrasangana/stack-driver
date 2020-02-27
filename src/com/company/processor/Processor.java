package com.company.processor;

import com.company.application.Application;
import com.company.inputlogs.LogReader;
import com.company.log.LogFactory;
import com.company.notification.NotificationFactory;

import java.util.List;

public interface Processor {
    void performProcess(List<Application> applications, NotificationFactory notificationFactory);
}
