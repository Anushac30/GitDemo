package Anushacompany.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anushacompany.Abstractmethods.abstractComponents;

public class OrderPage extends abstractComponents{

	WebDriver driver;
	

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	//@FindBy(css= ".totalRow button")
	//WebElement checkoutbutton;

	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productnames;
	
	public Boolean VerifyOrderDisplay(String productName)
	{
		Boolean match= productnames.stream().anyMatch(orderproduct->orderproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}
