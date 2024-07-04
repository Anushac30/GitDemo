package Anushacompany.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import Anushacompany.TestComponents.BaseTest;
import Anushacompany.pageobjects.CartPage;
import Anushacompany.pageobjects.CheckoutPage;
import Anushacompany.pageobjects.ConfirmationPage;
import Anushacompany.pageobjects.LandingPage;
import Anushacompany.pageobjects.Productpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImplimentation extends BaseTest {
	
	public LandingPage lp;
	public Productpage pp;
	public  ConfirmationPage confirmpage;
	String cname="India";
	
	@Given("I landed on Ecommerce page")
	public void  I_landed_on_Ecommerce_page() throws IOException
	{
		lp= launchApplication();
	}
	//Logged in with username<username> and password <password> 
	//we can not use the parameters in the given condition on the stepdifinition class instead we have to use regular expression as below
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password)
	{
		pp  =lp.loginApplication(username,password);
	}
	//When I add the product <productName> to cart
	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=pp.getProductList();
		pp.addProductToCart(productName);
	}
	   //And checkout <productName> and submit order
	@When("^checkout (.+) and submit order$")
	public void checkout_and_submit_order(String productName)
	{
		CartPage cp =  pp.gotoCartPage();
		
		Boolean match=cp.VerifyProductDisplay(productName);
		//anymatch will be used to get any product which matched
		Assert.assertTrue(match);
		
		CheckoutPage checkoutpage= cp.goToCheckout();
		checkoutpage.selectdropdown(cname);
		 confirmpage = checkoutpage.submitOrder();
	}
	//    Then I verify the "THANKYOU FOR THE ORDER." message is displayed on confirmation page
     @Then("I verify the {string} message is displayed on confirmation page")
     public void I_verify_the_message_displayed_on_confirmation_page(String string)
    {
    	 String msg= confirmpage.getConfirmationMsg();
         AssertJUnit.assertTrue(msg.equalsIgnoreCase(string));
         driver.close();
    }
     // Then  verify the "Incorrect email or password." message is displayed
     @Then("verify the {string} message is displayed")
     public void verify_the_message_is_displayed(String string1) {
    		Assert.assertEquals(string1,lp.getErrormessage());
    		driver.close();
    
}
}
