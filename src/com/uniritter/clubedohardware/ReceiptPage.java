package com.uniritter.clubedohardware;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage {
	@FindBy(id="elUserLink")
	private WebElement elUserNameLogged;

	public ReceiptPage(WebDriver driver) {
		super();
	}

	public boolean isInitialized() {
		return elUserNameLogged.isDisplayed();
	}

	public String confirmationUsername(){
		return elUserNameLogged.getText();
	}
}