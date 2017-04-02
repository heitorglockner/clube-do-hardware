package com.uniritter.clubedohardware;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage extends BasePage {
	@FindBy(id="elUserLink")
	private WebElement elUserNameLogged;

	@FindBy(id="elNavTheme")
	private WebElement elNavTheme;
	
	@FindBy(xpath="//*[@id='elNavTheme_menu']/li[1]/form/button")
	private WebElement elNavThemeDefault;
	
	@FindBy(xpath="//*[@id='elNavTheme_menu']/li[4]/form/button")
	private WebElement elNavThemeNight;
	
	@FindBy(css="body")
	WebElement body;
	
	public ReceiptPage(WebDriver driver) {
		super(driver);
	}

	public String confirmationUsername(){
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