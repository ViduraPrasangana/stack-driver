package com.company.inputlogs;

import com.company.application.Application;
import com.company.log.Log;
import com.company.log.LogFactory;
import com.company.notification.NotificationFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LogReaderTXT extends LogReader {
    public LogReaderTXT(List<Application> applications, LogFactory logFactory, NotificationFactory notificationFactory) {
        super(applications,logFactory,notificationFactory);
    }

    @Override
    public List<Application> readLogs(LogFactory logFactory) {
        for (Application application : applications) {
            try {
                List<String> logsStr = Files.readAllLines(Paths.get(application.getLog_file()));
                List<Log> logs = new ArrayList<>();
                for (String log : logsStr) {
                    String[] splitArray = log.split(" ");
                    logs.add(logFactory.getInstance(splitArray[0],splitArray[1],splitArray[2]));
                }
                application.setLogs(logs);

            } catch (IOException e) {
                System.out.println("Log file of "+application.getApplication_name()+" is not found");
            }
        }

        return applications;
    }
}
