package com.uniritter.qualidadedesoftware;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage {
  
	@FindBy(id="elCmsPageWrap")
	WebElement elCmsPageWrap;	
	
	@FindBy(xpath="//*['@id=elCmsPageWrap']/div[1]/div[1]/div[2]/h1/span")
	WebElement elTitlePage;

	@FindBy(xpath="//*[@id='elCmsPageWrap']/div[1]/div[1]/div[1]/div/div/a[1]")
	WebElement elFollowButton;

	@FindBy(id="elRadio_follow_type_none_")
	WebElement elRadioFollowTypeNone;	

	@FindBy(xpath="/html/body/div[6]/div/form/div[2]/button")
	WebElement elFollowFormSubmitButton;
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return elCmsPageWrap.isDisplayed();
	}
	
	public String getPageTitle() {
		return elTitlePage.getText();
	}

	public void followArticle() {
		elFollowButton.click();
		elRadioFollowTypeNone.click();
		elFollowFormSubmitButton.click();
	}
}
