package com.company.application;

import com.company.log.Log;
import com.company.user.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final String log_file;
    private final String application_name;
    private final User[] users;
    private List<Log> logs;

    public Application(String log_file, String application_name, User[] users) {
        this.log_file = log_file;
        this.application_name = application_name;
        this.users = users;
        logs = new ArrayList<>();
    }

    public String getLog_file() {
        return log_file;
    }

    public String getApplication_name() {
        return application_name;
    }

    public User[] getUsers() {
        return users;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
