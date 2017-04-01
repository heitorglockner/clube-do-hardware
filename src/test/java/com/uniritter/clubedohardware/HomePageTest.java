package com.uniritter.clubedohardware;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.uniritter.clubedohardware.HomePage;

public class HomePageTest {
	private WebDriver driver;

	@Before
	public void before() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("http://www.clubedohardware.com.br/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void signUp() {
		HomePage homePage = new HomePage(driver);
		homePage.submit();

		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertEquals("Heitor Glockner", receiptPage.confirmationUsername());
	}
}
