package com.company;

import com.company.application.Application;
import com.company.config.Config;
import com.company.config.ConfigByJSON;
import com.company.inputlogs.LogReader;
import com.company.inputlogs.LogReaderTXT;
import com.company.log.LogFactory;
import com.company.notification.NotificationFactory;
import com.company.processor.ErrorProcessor;
import com.company.processor.Processor;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Config config = new ConfigByJSON();
        List<Application> applications = config.readConfigs("C:\\Users\\HunterAlex\\IdeaProjects\\Strack Driver\\src\\com\\company\\config.json");

        LogFactory logFactory = new LogFactory();
        NotificationFactory notificationFactory = new NotificationFactory();
        LogReader logReader = new LogReaderTXT(applications,logFactory,notificationFactory);

        Processor errorProcessor = new ErrorProcessor();
        logReader.addProcessor(errorProcessor);
        logReader.startReading();

        try {
            Thread.sleep(10000);
            System.out.println("Killing");
            logReader.killReading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
