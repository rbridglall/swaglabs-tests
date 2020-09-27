package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class YourInformationPage {

    private WebDriver driver;

    private By firstNameField = By.cssSelector("[data-test=firstName]");
    private By lastNameField = By.cssSelector("[data-test=lastName]");
    private By zipCodeField = By.cssSelector("[data-test=postalCode]");
    private By continueButton = By.cssSelector(".checkout_buttons .cart_button");

    public YourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String firstName, String lastName, String zipCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void continuePurchase(){
        driver.findElement(continueButton).click();
    }
}
