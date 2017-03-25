package com.uniritter.clubedohardware;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class LoginComDadosInvalidos {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201631802\\Desktop\\trabalho\\testes\\clube-do-hardware\\geckodriver.exe");

    driver = new FirefoxDriver();
    baseUrl = "http://www.clubedohardware.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginComDadosInvalidos() throws Exception {
    driver.get(baseUrl);
    fluentWait(By.id("elUserSignIn"));
    driver.findElement(By.id("elUserSignIn")).click();
    driver.findElement(By.id("auth")).clear();
    driver.findElement(By.id("auth")).sendKeys("fweihghwefgwerg");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("rgfgewgfuyfweguyfewg");
    driver.findElement(By.id("elSignIn_submit")).click();

    fluentWait(By.cssSelector("p.ipsMessage.ipsMessage_error"));
    assertEquals("O Nome de usuário ou endereço de e-mail que você informou não pertence a nenhuma conta. Certifique-se que tenha digitado corretamente.",
    		driver.findElement(By.cssSelector("p.ipsMessage.ipsMessage_error")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public WebElement fluentWait(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		while (true) {
			if (!foo.isDisplayed()) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
				}
			} else {
				break;
			}
		}

		return foo;
	}
}
