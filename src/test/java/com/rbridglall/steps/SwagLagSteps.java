package com.rbridglall.steps;


import com.github.javafaker.Faker;
import com.rbridglall.config.Config;
import com.rbridglall.config.Env;
import com.rbridglall.pages.*;
import com.rbridglall.utils.SharedState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Config.class)
@EnableConfigurationProperties(value = Env.class)
@AllArgsConstructor
@DirtiesContext
public class SwagLagSteps {

    private WebDriver driver;
    private Env env;
    private SharedState sharedState;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private YourInformationPage yourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private PurchaseCompletePage purchaseCompletePage;

    @Before
    public void setup(){
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Given("I have logged into swaglabs with user {string}")
    public void i_have_logged_into_swaglabs_with_user(String user) {
        driver.get(env.getSwaglabUrl());
        Env.User userObject = env.getUser(user);
        loginPage.login(userObject.getUsername(), userObject.getPassword());
    }

    @And("I sort the products by price High to Low and confirm they are sorted")
    public void i_sort_the_products_by_price_High_to_Low() {
        productsPage.filterProductsHighToLow();
        assertThat(productsPage.getProductPrices()).isSortedAccordingTo((price1, price2) -> {
            if(price1 > price2){
                return -1;
            } else if(price1 < price2){
                return 1;
            } else {
                return 0;
            }
        });
        sharedState.setSortedProductPrices(productsPage.getProductPrices());
    }

    @And("I add the cheapest item to the basket")
    public void i_add_the_cheapest_item_to_the_basket() {
        List<WebElement> productList = productsPage.getProductList();
        productsPage.addProductToBasket(productList.get(productList.size() - 1));
    }

    @And("I add the second costliest item to the basket")
    public void i_add_the_second_costliest_item_to_the_basket() {
        List<WebElement> productList = productsPage.getProductList();
        productsPage.addProductToBasket(productList.get(1));
    }


    @And("I open the basket and confirm that the correct items were added")
    public void i_open_the_basket_and_confirm_that_the_correct_items_were_added() {
        productsPage.openBasket();
        List<Double> sortedProductPrices = sharedState.getSortedProductPrices();
        assertThat(cartPage.getCartPrices().get(0)).matches(price -> price.equals(sortedProductPrices.get(sortedProductPrices.size() - 1)));
        assertThat(cartPage.getCartPrices().get(1)).matches(price -> price.equals(sortedProductPrices.get(1)));
    }

    @And("I checkout")
    public void i_checkout(){
        cartPage.checkout();
    }

    @When("I checkout using my details")
    public void i_checkout_using_my_details() {
        Faker faker = new Faker();
        yourInformationPage.enterDetails(faker.name().firstName(), faker.name().lastName(), faker.address().zipCode());
        yourInformationPage.continuePurchase();
        checkoutOverviewPage.finishPurchase();

    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_sucess_message(String message) {
        String completeText = purchaseCompletePage.getCompleteMessage();
        assertThat(completeText).isEqualToIgnoringCase(message);
    }

}
