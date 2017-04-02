package com.uniritter.clubedohardware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.uniritter.clubedohardware.ArticlePage;

public class ArticlePageTest extends TestBaseSetup {
	private WebDriver driver;

	@Before
	public void before() {
		getDriver("noticias/smartphones/samsung-apresenta-os-novos-smartphones-galaxy-s8-e-s8-r50214");
	}

	@Test
	public void testePageTitle() {
		ArticlePage articlePage = new ArticlePage(driver);
		assertTrue(articlePage.isInitialized());

		String expectedTitle = "Samsung apresenta os novos smartphones Galaxy S8 e S8+";
		assertEquals(expectedTitle, articlePage.getPageTitle());
	}
}
