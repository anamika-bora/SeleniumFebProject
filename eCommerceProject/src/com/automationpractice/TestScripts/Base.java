package com.automationpractice.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {

	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void openApplication(String browser) {
		//
		if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass 
	public void closeApplication() {
		driver.close();
	}
}
