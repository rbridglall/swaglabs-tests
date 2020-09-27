package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class CheckoutOverviewPage {

    private WebDriver driver;

    private By finishButton = By.cssSelector(".cart_footer .cart_button");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finishPurchase(){
        driver.findElement(finishButton).click();
    }
}
