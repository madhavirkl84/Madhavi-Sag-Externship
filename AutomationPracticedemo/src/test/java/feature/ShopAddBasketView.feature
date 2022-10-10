Feature: Shop-Add to Basket-View Basket Functionality

  @AddCart
  Scenario: View Basket Functionality
    Given Open automationtesting page for View Basket
    When Click on Shop Menu for View Basket
    Then Click on the Add To Basket to add book to your basket
    Then User can view that Book in the Menu item with price
    Then Click on View Basket link to proceed to check out page
    Then User can find total and subtotal values just above the Proceed to Checkout button
    Then Total always < subtotal as taxes are added in the subtotal
    Then Click on Proceed to Check out button to payment gateway page
    Then View Billing,Order,Additional details and Payment gateway details
    Then User can fill billing details form and can opt any payment in the payment gateway.
      | firstName | lastName | companyName | emailAddress | phone no   | country | address | address2 | city      | state     | pincode | additionalComment            |
      | madhu     | malik    | sag         | madh@abc.com | 1234123456 | India   | Verthu  | Panathu  | Bangalore | Karnataka |  222365 | Want it as early as possible |
    Then Click on Place Order button to complete process
    Then After place order user completes his process and navigates to Order confirmation page with order, bank, customer and billing details.
