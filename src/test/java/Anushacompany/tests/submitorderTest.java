package Anushacompany.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Anushacompany.TestComponents.BaseTest;
import Anushacompany.pageobjects.CartPage;
import Anushacompany.pageobjects.CheckoutPage;
import Anushacompany.pageobjects.ConfirmationPage;
import Anushacompany.pageobjects.LandingPage;
import Anushacompany.pageobjects.OrderPage;
import Anushacompany.pageobjects.Productpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitorderTest extends BaseTest {

	String productName= "ZARA COAT 3";
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitorder(HashMap<String,String> input) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		
		String cname="India";
		
		Productpage pp=lp.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> products=pp.getProductList();
		pp.addProductToCart(input.get("product"));
		CartPage cp = pp.gotoCartPage();
	
		Boolean match=cp.VerifyProductDisplay(input.get("product"));
		//anymatch will be used to get any product which matched
		Assert.assertTrue(match);
		
		CheckoutPage checkoutpage= cp.goToCheckout();
		checkoutpage.selectdropdown(cname);
		 ConfirmationPage confirmpage = checkoutpage.submitOrder();
        
       String msg= confirmpage.getConfirmationMsg();
       AssertJUnit.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
       
	}
	
	@Test(dependsOnMethods="submitorder")
	
	public void OrderCheckingTest() 
	
	{
		Productpage pp=lp.loginApplication("anushac30@gmail.com", "Santhosh14$Nikki");
		OrderPage orderspage= pp.gotoOrderPage();
		Assert.assertTrue (orderspage.VerifyOrderDisplay(productName));
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//HashMap<String, String> map= new HashMap<String, String>();
		//map.put("email", "anushac30@gmail.com");
		//map.put("password", "Santhosh14$Nikki");
		//map.put("product",  "ZARA COAT 3");
		
		//HashMap<String, String> map1= new HashMap<String, String>();
		//map1.put("email", "anubb@gmail.com");
		//map1.put("password", "Nikhilesh5$");
		//map1.put("product", "ADIDAS ORIGINAL");
		List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+ "//src//test//java//Anushacompany//data//PurchaseOrder.json");
        
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}
 //@@DataProvider
	//public Object[][] getData() 
	//{
		//return new Object[][]  {{"anushac30@gmail.com", "Santhosh14$Nikki", "ZARA COAT 3"},{"anubb@gmail.com" , " Nikhilesh5$", "ADIDAS ORIGINA"}}
	//}
}



