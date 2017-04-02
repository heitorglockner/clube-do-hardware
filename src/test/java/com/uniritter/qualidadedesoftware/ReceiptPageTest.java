package com.uniritter.qualidadedesoftware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ReceiptPageTest extends TestBaseSetup {
	private static WebDriver driver;

	@Before
	public void before() {
		driver = getDriver("");

		HomePage homePage = new HomePage(driver);
		homePage.submit();
	}

	@Test()
	public void changeThemeToNight() throws InterruptedException {
		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertTrue(receiptPage.isInitialized());
		receiptPage.changeThemeToNight();

		if(receiptPage.body.isDisplayed()) {
			Thread.sleep(5000);
			String bodyColor = receiptPage.body.getCssValue("color").toString();
			assertEquals("rgba(200, 200, 200, 0.870588)", bodyColor);
		}
	}

	@Test()
	public void changeThemeToDefault() throws InterruptedException {
		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertTrue(receiptPage.isInitialized());
		receiptPage.changeThemeToDefault();

		if(receiptPage.body.isDisplayed()) {
			Thread.sleep(5000);
			String bodyColor = receiptPage.body.getCssValue("color").toString();
			assertEquals("rgba(0, 0, 0, 0.870588)", bodyColor);
		}
	}
}
