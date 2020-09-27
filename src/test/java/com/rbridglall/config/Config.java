package com.rbridglall.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.rbridglall")
public class Config {

    @Autowired
    private Env env;

    @Bean
    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", env.getDriverLocation());
        return new ChromeDriver();
    }
}
