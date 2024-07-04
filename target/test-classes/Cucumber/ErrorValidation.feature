
@tag
Feature: Error validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Checking Error validations using incorrect testdata
    Given I landed on Ecommerce page
    When Logged in with username <username> and password <password>
    Then  verify the "Incorrect email or password." message is displayed

      Examples: 
      | username           | password             | 
      |anushac30@gmail.com |    Santhosh14$Nikk  | 
     