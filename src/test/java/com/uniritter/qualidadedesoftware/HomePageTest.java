package com.uniritter.qualidadedesoftware;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTest extends TestBaseSetup {
	private WebDriver driver;
	
	@Before
	public void before() {
		driver = getDriver("");
	}

	@Test
	public void signUp() {
		HomePage homePage = new HomePage(driver);
		homePage.submit();

		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertEquals("Heitor Glockner", receiptPage.confirmationUsername());
	}
}