package com.uniritter.clubedohardware;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
  
	@FindBy(id="elUserSignIn")
	private WebElement elUserSignIn;
	
	@FindBy(id="auth")
	private WebElement elUserName;

	@FindBy(id="password")
	private WebElement elUserPass;

	@FindBy(id="elSignIn_submit")
	private WebElement elUserSignSubmit;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return elUserSignIn.isDisplayed();
	}
	
	public void openLoginBox(){
		this.elUserSignIn.click();
	}
	
	public void enterUsername(String userName){
		this.elUserName.clear();
		this.elUserName.sendKeys(userName);
	}

	public void enterPassword(String password){
		this.elUserPass.clear();
		this.elUserPass.sendKeys(password);
	}

	public ReceiptPage submit(){
		elUserSignSubmit.click();
		return new ReceiptPage(driver);
	}
}
