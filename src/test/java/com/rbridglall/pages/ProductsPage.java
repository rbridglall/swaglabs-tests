package com.rbridglall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsPage {

    private WebDriver driver;

    private By productFilter = By.className("product_sort_container");
    private By shoppingCartButton = By.id("shopping_cart_container");
    private By productsList = By.className("inventory_item");
    private By productPrice = By.className("inventory_item_price");

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

    public List<WebElement> getProductList() {
        return driver.findElements(productsList);
    }

    public void openBasket() {
        driver.findElement(shoppingCartButton).click();
    }

    public void addProductToBasket(WebElement product) {
        product.findElement(By.cssSelector(".pricebar>button")).click();
    }

    public List<Double> getProductPrices() {
        return getProductList().stream()
                .map(product -> {
                    String productPriceString = product.findElement(productPrice).getText().replace("$", "");
                    return Double.parseDouble(productPriceString);
                })
                .collect(Collectors.toList());
    }
}