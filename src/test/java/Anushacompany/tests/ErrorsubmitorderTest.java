package Anushacompany.tests;

import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Anushacompany.TestComponents.BaseTest;
import Anushacompany.pageobjects.CartPage;
import Anushacompany.pageobjects.Productpage;

public class ErrorsubmitorderTest extends BaseTest {

	@Test(groups={"ErrorHandling"},retryAnalyzer= Anushacompany.TestComponents.Retry.class)
	public void LoginErrorValidations() throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		
	
		
		lp.loginApplication("anuhhac30@gmail.com", "Santhosh12$Nikki");
		//.ng-tns-c4-10.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		Assert.assertEquals("Incorrect email or password.",lp.getErrormessage());
		
	}
	@Test 
	public void productErrorValidation() throws InterruptedException, IOException
	{
		String productName= "ZARA COAT 3";
		
		
		Productpage pp=lp.loginApplication("anubb@gmail.com", "Nikhilesh5$");
		
		List<WebElement> products=pp.getProductList();
		pp.addProductToCart(productName);
		CartPage cp = pp.gotoCartPage();
	
		Boolean match=cp.VerifyProductDisplay("ZARA COAT 33");
		//anymatch will be used to get any product which matched
		Assert.assertFalse(match);
	}

}