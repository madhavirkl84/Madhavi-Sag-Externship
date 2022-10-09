Feature: Flipkart laptop purchase 
   @homepage_laptop
    Scenario: Validate Laptop and filters getting slected. 
    Given User is on Flipkart home page
    When close the login popup
    Then search for "laptop" using searchbar 
    Then select PROCESSOR
    Then select BRAND
    Then select TYPE
    Then select the laptop open in new page
    Then Add pincode for laptop before adding it to cart
    Then Add to cart the selected item
  