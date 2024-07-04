package Anushacompany.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Anushacompany.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stadaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname= "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();//if you get error showing for this line then press command+shift+O to add the packages
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage lp= new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("anushac30@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Santhosh14$Nikki");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).
				          getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartproducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match= cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		//anymatch will be used to get any product which matched
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        List<WebElement> options=driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
        for(WebElement countryname: options) //enhanced for loop
		{
			if(countryname.getText().equalsIgnoreCase("India"))
					{
				countryname.click();
				break;
					
					}
		}
        driver.findElement(By.cssSelector(".action__submit")).click();
       String msg= driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
       

}
}