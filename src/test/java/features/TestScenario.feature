Feature: Step by step Test Scenario

  Scenario: adding a specific product to the cart and price comparison testing
    Given user goes to
    When go to category
    And user click on the computer-tablet icon
    And Scroll the apple from the filter area and click the checkbox
    And Scroll to screen size and select screen size
    And Find the highest priced item and click on it
    And move to the next tab
    And The product price is memorized before adding to cart
    And Click on the Add to Cart button and click on the Go to Cart button on the screen that opens.
    Then Check that the product price recorded in the TempData variable is equal to the product price in the Cart.