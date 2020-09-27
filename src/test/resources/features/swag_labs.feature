Feature: testing shopping journeys

  Scenario: filtering for most expensive and cheapest product with full checkout
    Given I have logged into swaglabs with user "standard_user"
    And I sort the products by price High to Low
    And I add the cheapest item to the basket
    And I add the second expensive item to the basket
    And I open the basket
    When I checkout using my details
    Then The purchase should be complete