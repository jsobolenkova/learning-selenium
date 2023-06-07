package guru99Application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Guru99ApplicationTest {
	WebDriver driver;
	String url = "http://demo.guru99.com/v4/";
	
	@AfterClass
	public void closeBrowser() {
		 driver.quit(); // method closes all browser windows and ends the WebDriver session. 
	}

	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test (priority = 0)
	public void verifyTitleOfThePage() {
		String expectedTitle = "Guru99 Bank Home Page";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test (priority = 2)
	public void verifyLoginToGuru99Application() {
		WebElement userId = driver.findElement(By.name("uid"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("btnLogin"));
		
		userId.sendKeys("mngr507692"); 
		userPassword.sendKeys("UjagynA");
		
		loginButton.click();
		
		String expectedUrl = "https://demo.guru99.com/v4/manager/Managerhomepage.php";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl); 
	}
	
	@Test
	public void acceptPrivacyPolicy() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement saveButton = driver.findElement(By.id("save"));
		saveButton.click();
	}

	@Test
	public void addCustomer() {
		WebElement addCustomerLink = driver.findElement(By.xpath("//a[contains(@href,'addcustomerpage.php')]")); // it is best to locate buttons via links rather than text
		addCustomerLink.click();
		
		WebElement genderLink = driver.findElement(By.xpath("//input[@value='f']"));
		genderLink.click();
		
		WebElement submitButton = driver.findElement(By.name("sub"));
		
		
		driver.findElement(By.name("name")).sendKeys("Saurabh Dhingra");
		driver.findElement(By.name("dob")).sendKeys("06.06.1989");
		driver.findElement(By.name("addr")).sendKeys("Gurgaon");
		driver.findElement(By.name("city")).sendKeys("Gurugram");
		driver.findElement(By.name("state")).sendKeys("Haryana");
		driver.findElement(By.name("pinno")).sendKeys("122001");
		driver.findElement(By.name("telephoneno")).sendKeys("97834523576");
		driver.findElement(By.name("emailid")).sendKeys("abc@xyze.com"); // needs to be unique at every run 
		driver.findElement(By.name("password")).sendKeys("poiy@123");
		
		submitButton.click(); 
	} 
	
	@Test
	public void GetCustomerId() {
		String customerID = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]td[2]")).getText();
		
		System.out.println("Customer Id" + customerID);
	}
		

	
	@Test (priority = 3)
	public void verifyLogOutButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement logoutButton = driver.findElement(By.xpath("//a[contains(@href,'Logout.php')]")); 
		
		logoutButton.click();
	}
	
}
