package com.uniritter.qualidadedesoftware;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTest extends TestBaseSetup {
	private WebDriver driver;
	
	@Before
	public void before() {
		driver = getDriver("");
	}

	@Test
	public void signUp() {
		HomePage homePage = new HomePage(driver);
		homePage.submit();

		ReceiptPage receiptPage = new ReceiptPage(driver);
		assertEquals("Heitor Glockner", receiptPage.confirmationUsername());
	}

	@Test
	public void signUpWithIncorretData() {
		HomePage homePage = new HomePage(driver);
		homePage.submitWithIncorrectData();

		LoginPage loginPage = new LoginPage(driver);
		assertEquals("O Nome de usuário ou endereço de e-mail que você informou não pertence a nenhuma conta. Certifique-se que tenha digitado corretamente.", loginPage.getErrorMessage());
	}
}
