package com.company.log;

import java.util.Date;

public class LogFactory {
    public Log getInstance(String severity, String date, String message){
        Log log ;
        switch (severity){
            case "INFO":
                log = new InfoLog(date,message);
                break;
            case "WARNING":
                log = new WarningLog(date,message);
                break;
            case "ERROR":
                log = new ErrorLog(date, message);
                break;
            default:
                log = null;
                System.out.println("Unknown severity : "+severity);
                break;
        }
        return log;
    }
}
