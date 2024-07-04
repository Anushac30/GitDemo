package Anushacompany.Abstractmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Anushacompany.pageobjects.CartPage;
import Anushacompany.pageobjects.OrderPage;

public class abstractComponents {
	WebDriver driver;
	public abstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
     //cartbutton click
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	//order button click
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderButton;
	
	
	public void waitForElementToAppear(By findBy)
	{
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));

    }
	
	
	public void waitForElementToInvisible(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public CartPage gotoCartPage()
	{
		cartButton.click();
		CartPage cp= new CartPage(driver);
		return cp;
	}
	public OrderPage gotoOrderPage()
	{
		orderButton.click();
	    OrderPage  orderspage= new OrderPage(driver);
		return  orderspage;
	}
}