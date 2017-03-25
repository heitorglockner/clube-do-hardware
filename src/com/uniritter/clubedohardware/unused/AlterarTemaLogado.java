package com.uniritter.clubedohardware;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class AlterarTemaLogado {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201631802\\Desktop\\trabalho\\testes\\clube-do-hardware\\geckodriver.exe");

	  driver = new FirefoxDriver();
	  baseUrl = "http://www.clubedohardware.com.br/";
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Test
  public void testAlterarTemaLogado() throws Exception {
    driver.get(baseUrl);
    fluentWait(By.id("elUserSignIn"));
    driver.findElement(By.id("elUserSignIn")).click();
    driver.findElement(By.id("auth")).clear();
    driver.findElement(By.id("auth")).sendKeys("heitorglockner@gmail.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("09021989");
    driver.findElement(By.id("elSignIn_submit")).click();
    
    fluentWait(By.id("elNavTheme"));
	driver.findElement(By.id("elNavTheme")).click();
	driver.findElement(By.xpath("(//button[@name='id'])[4]")).click();

    assertEquals("rgba(27, 28, 30, 1)",
    		getCssValue_BodyBackgroundColor());
  }

	public String getCssValue_BodyBackgroundColor(){
		WebElement body = driver.findElement(By.cssSelector("body.ipsApp"));
		return getBackgroundColor(body);
	}

	public String getBackgroundColor(WebElement element) {
		//Output will return as 400 for font-weight : normal, and 700 for font-weight : bold
		return element.getCssValue("background-color");
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
