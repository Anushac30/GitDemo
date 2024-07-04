package Anushacompany.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anushacompany.Abstractmethods.abstractComponents;

public class Productpage extends abstractComponents{
	
	WebDriver driver;
	
	public Productpage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	//
//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));;
	@FindBy(css= ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productslist= By.cssSelector(".mb-3");
	By addtocart= By.cssSelector("button[class='btn w-10 rounded']");
    By toastcontainer= By.cssSelector("#toast-container");
  
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productslist);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{

		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).
				          getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName) throws InterruptedException
	{
	 WebElement prod=getProductByName(productName);
		prod.findElement(addtocart).click();
		waitForElementToAppear(toastcontainer);
		waitForElementToInvisible(spinner);
	}
	

}
