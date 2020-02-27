package com.company.log;

import java.util.Date;

public abstract class Log {
    private final String date;
    private final String message;

    public Log( String date, String message) {

        this.date = date;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
