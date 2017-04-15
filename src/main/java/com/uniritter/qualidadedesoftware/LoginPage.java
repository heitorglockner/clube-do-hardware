package com.uniritter.qualidadedesoftware;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(xpath="//*[@id='ipsLayout_mainArea']/div[2]/div/div[1]/div/form")
	private WebElement elUserSignIn;

	@FindBy(xpath="//*[@id='ipsLayout_mainArea']/div[2]/div/div[1]/div/p")
	WebElement elErrorMessage;

	@FindBy(id="elInput_auth")
	private WebElement elUserName;

	@FindBy(id="elInput_password")
	private WebElement elUserPass;

	@FindBy(xpath="//*[@id='ipsLayout_mainArea']/div[2]/div/div[1]/div/form/ul/li[5]/div/button")
	WebElement elUserSignSubmit;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return elUserSignIn.isDisplayed();
	}

	public void enterUsername(String userName){
		this.elUserName.clear();
		this.elUserName.sendKeys(userName);
	}

	public void enterPassword(String password){
		this.elUserPass.clear();
		this.elUserPass.sendKeys(password);
	}
	
	public String getErrorMessage(){
		return elErrorMessage.getText();
	}

	public LoginPage submit() {
		assertTrue(isInitialized());

		enterUsername("heitorglockner@gmail.com");
		enterPassword("abcd1234");

		elUserSignSubmit.click();
		return new LoginPage(driver);
	}
}
