package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.cssSelector("[data-test=username]");
    private By passwordField = By.cssSelector("[data-test=password]");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}