Feature: Flipkart Mobile purchase 
  @homepage_mobile
    Scenario: Validate Moble and filters getting slected. 
    Given User is on flipkart landing page
    When Close the login popupM
    Then search for the "mobile" using searchbar 
    Then select brand, RAM and ratings
    Then select the mobile open in new page
    Then Add pincode before adding it to cart
    Then Add to cart the selected mobile
 