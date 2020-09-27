package com.rbridglall.steps;


import com.rbridglall.config.Config;
import com.rbridglall.config.Env;
import com.rbridglall.pages.LoginPage;
import com.rbridglall.pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Config.class)
@EnableConfigurationProperties(value = Env.class)
@AllArgsConstructor
public class SwagLagSteps {

    private WebDriver driver;
    private Env env;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Before
    public void setup(){
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
//        driver.close();
    }

    @Given("I have logged into swaglabs with user {string}")
    public void i_have_logged_into_swaglabs_with_user(String user) {
        driver.get(env.getSwaglabUrl());
        Env.User userObject = env.getUser(user);
        loginPage.login(userObject.getUsername(), userObject.getPassword());
    }

    @Given("I sort the products by price High to Low")
    public void i_sort_the_products_by_price_High_to_Low() {
        productsPage.filterProductsHighToLow();
    }

    @Given("I add the cheapest item to the basket")
    public void i_add_the_cheapest_item_to_the_basket() {

    }

    @Given("I add the second expensive item to the basket")
    public void i_add_the_second_expensive_item_to_the_basket() {
        System.out.println("i_add_the_second_expensive_item_to_the_basket");
    }

    @Given("I open the basket")
    public void i_open_the_basket() {
        System.out.println("i_open_the_basket");
    }

    @When("I checkout using my details")
    public void i_checkout_using_my_details() {
        System.out.println("i_checkout_using_my_details");
    }

    @Then("The purchase should be complete")
    public void the_purchase_should_be_complete() {
        System.out.println("");
    }

}
