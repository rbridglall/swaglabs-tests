package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartPage {

    private WebDriver driver;

    private By checkoutButton = By.cssSelector(".checkout_button");
    private By cartPrices = By.cssSelector(".inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Double> getCartPrices(){
        return driver.findElements(cartPrices).stream()
                .map(price -> Double.parseDouble(price.getText()))
                .collect(Collectors.toList());
    }

    public void checkout(){
        driver.findElement(checkoutButton).click();
    }
}
