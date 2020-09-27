Feature: Filtering products and full checkout journey

  Scenario: Checkout is successful with the second costliest and cheapest products
    Given I have logged into swaglabs with user "standard_user"
    And I sort the products by price High to Low and confirm they are sorted
    And I add the cheapest item to the basket
    And I add the second costliest item to the basket
    And I open the basket and confirm that the correct items were added
    And I checkout
    When I checkout using my details
    Then I should see the success message "Your order has been dispatched, and will arrive just as fast as the pony can get there!"