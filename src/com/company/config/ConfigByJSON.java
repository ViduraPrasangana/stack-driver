package com.company.config;


import com.company.application.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigByJSON implements Config {
    @Override
    public List<Application> readConfigs(String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            Reader reader = new FileReader(path);
            List<Application> applications = Arrays.asList(gson.fromJson(reader, Application[].class));
            return applications;
        } catch (FileNotFoundException e) {
            System.out.println("Config.json file not found");
        }

        return new ArrayList<>();
    }
}
