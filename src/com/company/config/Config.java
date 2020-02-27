package com.company.config;

import com.company.application.Application;

import java.util.List;

public interface Config {
    List<Application> readConfigs(String path);
}
