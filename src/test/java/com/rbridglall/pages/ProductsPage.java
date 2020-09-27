package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsPage {

    private WebDriver driver;

    private By productFilter = By.cssSelector("product_sort_container");
    private By shoppingCartButton = By.id("shopping_cart_containe");
    private By productsList = By.className("inventory_item");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterProductsHighToLow() {
        Select productSelect = new Select(driver.findElement(productFilter));
        productSelect.selectByValue("hilo");
    }

    public void filterProductsLowToHigh() {
        Select productSelect = new Select(driver.findElement(productFilter));
        productSelect.selectByValue("lohi");
    }

    public List<WebElement> getProductList(){
        return driver.findElements(productsList);
    }
}