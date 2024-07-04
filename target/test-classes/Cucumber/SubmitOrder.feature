

@tag
Feature: Purchase the order from the Ecommerce website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page


  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <username> and password <password>
    When I add the product <productName> to cart
    And checkout <productName> and submit order
    Then I verify the "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | username           | password             | productName  |
      |anushac30@gmail.com |    Santhosh14$Nikki  | ZARA COAT 3  |
     
