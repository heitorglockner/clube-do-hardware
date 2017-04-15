package com.uniritter.qualidadedesoftware;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTest extends TestBaseSetup {
	private WebDriver driver;
	
	@Before
	public void before() {
		driver = getDriver("login");
	}

	@Test
	public void signUp() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submit();

		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertEquals("Heitor Glockner", receiptPage.confirmationUsername());
	}
}