package com.uniritter.qualidadedesoftware;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePageTest extends TestBaseSetup {
	private WebDriver driver;

	@Before
	public void before() {
		driver = getDriver("noticias/smartphones/samsung-apresenta-os-novos-smartphones-galaxy-s8-e-s8-r50214");
	}

	@Test
	public void testPageTitle() {
		ArticlePage articlePage = new ArticlePage(driver);

		assertTrue(articlePage.isInitialized());

		String expectedTitle = "Samsung apresenta os novos smartphones Galaxy S8 e S8+";
		assertEquals(expectedTitle, articlePage.getPageTitle());
	}

	@Test
	public void followArticle() {
		HomePage homePage = new HomePage(driver);
		homePage.submit();
		
		ArticlePage articlePage = new ArticlePage(driver);
		assertTrue(articlePage.isInitialized());

		articlePage.followArticle();
		assertTrue(articlePage.elFollowButton.getText().contains("Seguindo"));
	}

	@Test
	public void toggleLikeArticle() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.submit();

		ArticlePage articlePage = new ArticlePage(driver);
		assertTrue(articlePage.isInitialized());
		
		if (articlePage.elLikeButton.getText().contains("Curtir")) {
			articlePage.toggleLikeArticle();

			Thread.sleep(5000);
			assertTrue(articlePage.elLikeButton.getText().contains("Descurtir"));
		} else {
			articlePage.toggleLikeArticle();

			Thread.sleep(5000);
			assertTrue(articlePage.elLikeButton.getText().contains("Curtir"));
		}
	}
}
