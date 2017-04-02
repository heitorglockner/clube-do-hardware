package com.uniritter.clubedohardware;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage {
  
	@FindBy(className="jmHugeTitle")
	private WebElement elTitlePage;

	public ArticlePage(WebDriver driver) {
		super(driver);
	}

	//	public boolean isInitialized() {
	//		return elUserSignIn.isDisplayed();
	//	}

	public boolean isInitialized() {
		return elTitlePage.isDisplayed();
	}
	
	public String getPageTitle() {
		return elTitlePage.getText();
	}
}
