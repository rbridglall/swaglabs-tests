package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class PurchaseCompletePage {

    private WebDriver driver;

    private By completeMessage = By.cssSelector(".complete-text");

    public PurchaseCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompleteMessage(){
        return driver.findElement(completeMessage).getText();
    }
}
