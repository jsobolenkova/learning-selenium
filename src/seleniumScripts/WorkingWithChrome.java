package seleniumScripts;

import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {
	
	ChromeDriver driver; 
	
	String url = "http://demo.guru99.com/v4";
	
	// Method 
	public void invokeBrowser () {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public void getTitle() {
		
		String titleOfThePage = driver.getTitle();
		System.out.println("Title Of The Page - " + titleOfThePage);
	
	}
	
	public void closeBrowser() {
		driver.quit();  //  method closes all browser windows and ends the WebDriver session.
//		 driver.close(); - close() closes only the current window and WebDriver session remains active. 
	
	}
	
	public static void main(String[] args) {
		
		WorkingWithChrome wc = new WorkingWithChrome();
		wc.invokeBrowser();
		
		wc.getTitle();
		
		wc.closeBrowser();
	}
	
}
