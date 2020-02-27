package com.company.inputlogs;

import com.company.application.Application;
import com.company.log.Log;
import com.company.log.LogFactory;
import com.company.notification.NotificationFactory;
import com.company.processor.Processor;

import java.util.ArrayList;
import java.util.List;

public abstract class LogReader {
    protected List<Application> applications;
    private Thread process = null;
    private List<Processor> processors;
    private LogFactory logFactory;
    private NotificationFactory notificationFactory;

    public LogReader(List<Application> applications, LogFactory logFactory, NotificationFactory notificationFactory) {
        this.applications = applications;
        this.logFactory = logFactory;
        this.notificationFactory = notificationFactory;

        processors = new ArrayList<>();
    }

    public void addProcessor(Processor processor) {
        processors.add(processor);
    }

    public void startReading() {
        process = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    List<Application> applications = readLogs(logFactory);
                    for (Processor processor : processors) {
                        processor.performProcess(applications, notificationFactory);
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Reading thread has been interrupted");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        process.start();
    }

    abstract public List<Application> readLogs(LogFactory logFactory);

    public void killReading() {
        if (process != null) {
            process.stop();
        }
    }
}
