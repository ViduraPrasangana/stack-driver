package com.company.user;

public class User {
    private final String name;
    private final String email;
    private final String phone;
    private final String notificationTypes;

    public User(String name, String email, String phone, String notificationTypes) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.notificationTypes = notificationTypes;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getNotificationTypes() {
        return notificationTypes.split(",");
    }
}
