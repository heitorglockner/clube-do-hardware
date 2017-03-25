package com.uniritter.clubedohardware;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginSemDados {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");

	driver = new ChromeDriver();
	baseUrl = "http://www.clubedohardware.com.br/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginSemDados() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("elUserSignIn")).click();
    driver.findElement(By.id("elSignIn_submit")).click();
    assertEquals("Este campo é obrigatório", driver.findElement(By.cssSelector("li.ipsType_warning")).getText());
    try {
      assertEquals("Este campo é obrigatório", driver.findElement(By.cssSelector("#password_errors > li.ipsType_warning")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
