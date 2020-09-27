package com.rbridglall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties
@Component
@Data
public class Env {

    private String swaglabUrl;
    private Map<String, User> users;
    private Driver driver;

    @Data
    public static class User {
        private String username;
        private String password;
    }

    @Data
    public static class Driver {
        private String os;
        private String mac;
        private String windows;
    }

    public User getUser(String user) {
        return users.get(user);
    }

    public String getDriverLocation(){
        return this.driver.getOs().equalsIgnoreCase("windows") ? this.driver.windows : this.driver.mac;
    }
}
