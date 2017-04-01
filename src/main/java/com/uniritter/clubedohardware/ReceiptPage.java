package com.uniritter.clubedohardware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceiptPage extends BasePage {
	@FindBy(id="elUserLink")
	private WebElement elUserNameLogged;

	@FindBy(id="elNavTheme")
	private WebElement elNavTheme;
	
	@FindBy(xpath="//*[@id='elNavTheme_menu']/li[1]/form/button")
	private WebElement elNavThemeDefault;
	
	@FindBy(xpath="//*[@id='elNavTheme_menu']/li[4]/form/button")
	private WebElement elNavThemeNight;
	
	@FindBy(tagName="body")
	WebElement body;
	
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
	
	public void changeThemeToDefault() {
		elNavTheme.click();
		elNavThemeDefault.click();
	}
	
	public void changeThemeToNight() {
		elNavTheme.click();
		elNavThemeNight.click();
	}
}