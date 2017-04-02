package com.uniritter.qualidadedesoftware;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBaseSetup {
	private WebDriver driver;

	public WebDriver getDriver(String url) {
		initializeTestBaseSetup(url);

		return driver;
	}

	public static String detectOS() {
		String os = System.getProperty("os.name").toLowerCase();

		String driverpath = null;
		if (os.contains("mac")) {
			driverpath = "chromedriver_mac";
		} else if (os.contains("win")) {
			driverpath = "chromedriver.exe";
		} else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			driverpath = "chromedriver_linux";
		}
	
		return driverpath;
	}

	public void initializeTestBaseSetup(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");

		System.setProperty("webdriver.chrome.driver", detectOS());

		driver = new ChromeDriver(options);
		driver.get("http://www.clubedohardware.com.br/" + url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
