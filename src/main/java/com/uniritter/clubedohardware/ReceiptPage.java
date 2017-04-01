package com.uniritter.clubedohardware;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceiptPage extends PageObject {
	@FindBy(id="elUserLink")
	private WebElement elUserNameLogged;

	@FindBy(id="elNavTheme")
	private WebElement elNavTheme;

	@FindBy(xpath="/html/body")
	private WebElement body;
	
	public ReceiptPage(WebDriver driver) {
		super(driver);
	}

	public void waitUntilFieldIsLocated(String fieldID, int timeout) {
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.id(fieldID)));
	}
	
	public String confirmationUsername(){
		waitUntilFieldIsLocated("elUserLink", 10);
		return elUserNameLogged.getText();
	}

	public boolean isInitialized() {
		return elUserNameLogged.isDisplayed();
	}
	
	public void changeTheme() {
		elNavTheme.click();
	}
}