package com.uniritter.clubedohardware;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
	WebElement elUserSignIn, elUserName, elUserPass, elUserSignSubmit, elUserNameLogged;

	private WebDriver driver;

	@Test
	public void signUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.clubedohardware.com.br/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.isInitialized());

		homePage.openLoginBox();
		homePage.enterUsername("heitorglockner@gmail.com");
		homePage.enterPassword("09021989");

		ReceiptPage receiptPage = homePage.submit();
//		assertTrue(receiptPage.isInitialized());

		assertEquals("Heitor Glockner", receiptPage.confirmationUsername());
	}
}
