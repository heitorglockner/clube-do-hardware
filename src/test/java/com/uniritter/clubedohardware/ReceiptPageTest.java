package com.uniritter.clubedohardware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReceiptPageTest extends HomePageTest {
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

	@Test()
	public void changeTheme() {
		HomePage homePage = new HomePage(driver);
		homePage.submit();

		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertTrue(receiptPage.isInitialized());
		receiptPage.changeTheme();

		assertTrue(receiptPage.isInitialized());
		String bodyBgColor = receiptPage.body.getCssValue("backgroud-color").toString();
		assertEquals("#1b1c1e", bodyBgColor);
	}
}
