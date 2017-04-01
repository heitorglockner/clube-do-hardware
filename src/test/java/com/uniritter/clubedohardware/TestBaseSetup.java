package com.uniritter.clubedohardware;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBaseSetup {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public static String detectOS() {
		String os = System.getProperty("os.name").toLowerCase();

		String driverpath = null;
		if (os.contains("mac")) {
			driverpath = "chromedriver";
		} else if (os.contains("win")) {
			driverpath = "chromedriver.exe";
		}
	
		return driverpath;
	}
	
	@Before
	public void initializeTestBaseSetup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");

		System.setProperty("webdriver.chrome.driver", detectOS());

		driver = new ChromeDriver(options);
		driver.get("http://www.clubedohardware.com.br/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
