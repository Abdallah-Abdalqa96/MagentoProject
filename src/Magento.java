import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Magento {
	
	
	WebDriver driver = new ChromeDriver() ;
	String mywebsite = "https://magento.softwaretestingboard.com/" ;
	
	@BeforeTest
	public void setup () {
		driver.get(mywebsite); 
		driver.manage().window().maximize(); 
		
	}
	
	
	
	@Test(priority = 1,enabled = true)
	public void signup() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement CreateAnAccount =  driver.findElement(By.linkText("Create an Account")) ;
		CreateAnAccount.click();
        Thread.sleep(1000);

        WebElement FirstName =driver.findElement(By.id("firstname"));
        FirstName.sendKeys("Test");
        Thread.sleep(1000);

        WebElement LastName = driver.findElement(By.id("lastname"));
        LastName.sendKeys("User");
        
        Thread.sleep(1000);

        WebElement EmailAddress = driver.findElement(By.id("email_address"));
        EmailAddress.sendKeys("testuser@example.com");
        
        Thread.sleep(1000);

        WebElement PassWord =  driver.findElement(By.id("password"));
        PassWord.sendKeys("Password123!");
        Thread.sleep(1000);

        WebElement PasswordConfirmation =  driver.findElement(By.id("password-confirmation"));
        PasswordConfirmation.sendKeys("Password123!");
        Thread.sleep(1000);

        WebElement CreateanAccount = driver.findElement(By.cssSelector("button[title='Create an Account']"));
        CreateanAccount.click();
        //test
        //String expectedName = "Test User";
        //String actualName = driver.findElement(By.cssSelector(".customer-name")).getText();
        //org.testng.Assert.assertEquals(expectedName,actualName); 
        Thread.sleep(2000);
		
	
	}
	@Test(priority = 2,enabled = true)
	public void signin() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(1000);

	    driver.findElement(By.id("email")).sendKeys("testuser@example.com"); // Replace with valid email
        Thread.sleep(1000);

	    driver.findElement(By.id("pass")).sendKeys("Password123!");
        Thread.sleep(1000);

	    driver.findElement(By.cssSelector("button[title='Sign In']")).click();
        Thread.sleep(3000);

	    // التحقق من النتيجة
	    String expectedName = "Test User";
	    String actualName = driver.findElement(By.cssSelector(".customer-name")).getText();
	    assert actualName.contains(expectedName) : "Expected: " + expectedName + ", but got: " + actualName;
        Thread.sleep(3000);
    }
    
		
	
	@Test(priority = 3,enabled = true) 
	public void subscribe() throws InterruptedException {
		
		driver.findElement(By.id("newsletter")).sendKeys("testuser" + System.currentTimeMillis() + "@example.com");
	    driver.findElement(By.cssSelector("button[title='Subscribe']")).click();

	    // التحقق من النتيجة
	    String expectedMessage = "Thank you for your subscription.";
	    String actualMessage = driver.findElement(By.cssSelector(".message-success")).getText();
	    assert actualMessage.contains(expectedMessage) : "Expected: " + expectedMessage + ", but got: " + actualMessage;
        Thread.sleep(3000);

    }
	@Test(priority = 4,enabled = true) 
	public void addRandomItems() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/gear/fitness-equipment.html");
	    List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("button[title='Add to Cart']"));

	    for (int i = 0; i < 3; i++) {
	        addToCartButtons.get(i).click();

	        // التحقق من النتيجة لكل منتج
	        String expectedMessage = "You added";
	        String actualMessage = driver.findElement(By.cssSelector(".message-success")).getText();
	        assert actualMessage.contains(expectedMessage) : "Expected: " + expectedMessage + ", but got: " + actualMessage; 
	        
	        Thread.sleep(2000);

	    }
    }

	@Test(priority = 5,enabled = false)	
	public void sortByPrice() {
		
        driver.get("https://magento.softwaretestingboard.com/women/tops-women/tanks-women.html?product_list_order=name");
        WebElement sortDropdown = driver.findElement(By.id("sorter"));
        sortDropdown.click();
        driver.findElement(By.xpath("//option[text()='Price']")).click();

        // Get prices
        WebElement firstPrice = driver.findElement(By.cssSelector(".price:first-of-type"));
        WebElement lastPrice = driver.findElement(By.cssSelector(".price:last-of-type"));

       // double firstPriceValue = Double.parseDouble(firstPrice.getText().replace("$", ""));
        //double lastPriceValue = Double.parseDouble(lastPrice.getText().replace("$", ""));

        //assert firstPrice < lastPrice : "Expected first price < last price, but got: firstPrice=" + firstPrice + ", lastPrice=" + lastPrice;
	        
    }

   // @AfterClass
    //public void tearDown() {
      //  driver.quit();
    }

		
	
	
	


