package Anushacompany.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anushacompany.Abstractmethods.abstractComponents;

public class CartPage extends abstractComponents{
	
	     WebDriver driver;
	
		
		public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
		@FindBy(css= ".totalRow button")
		WebElement checkoutbutton;

		@FindBy(xpath="//div[@class='cartSection']/h3")
		private List<WebElement> cartproducts;
		
		public Boolean VerifyProductDisplay(String productName)
		{
			Boolean match= cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
			return match;
		}
		public CheckoutPage goToCheckout() 
		{
			checkoutbutton.click();
			CheckoutPage checkoutpage = new CheckoutPage(driver);
			return checkoutpage;
		}

		
		
		
}
