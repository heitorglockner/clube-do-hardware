package com.uniritter.clubedohardware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ReceiptPageTest extends TestBaseSetup {
	private static WebDriver driver;

	@Before
	public void before() {
		driver = getDriver();
	}

	@Test()
	public void changeThemeToNight() {
		HomePage homePage = new HomePage(driver);
		homePage.submit();

		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertTrue(receiptPage.isInitialized());
		receiptPage.changeThemeToNight();

		String bodyBgColor = receiptPage.body.getCssValue("backgroud-color").toString();
		assertEquals("#1b1c1e", bodyBgColor);
	}

	@Test()
	public void changeThemeToDefalt() {
		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertTrue(receiptPage.isInitialized());
		receiptPage.changeThemeToDefault();

		String bodyBgColor = receiptPage.body.getCssValue("backgroud-color").toString();
		assertEquals("#ebeef2", bodyBgColor);
	}
}
