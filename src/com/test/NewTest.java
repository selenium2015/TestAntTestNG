package com.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	WebDriver driver;
	
//	WebDriver driver=new FirefoxDriver();
	WebElement userName;
	WebElement passWd;
	WebElement loginButton;
	
  @Parameters({"name","password"})
  @Test
  public void testLogin(String name,String password) {
		userName=driver.findElement(By.id("input1"));
		passWd=driver.findElement(By.id("input2"));
		loginButton=driver.findElement(By.id("signin"));		
		
		userName.sendKeys(name);
		passWd.sendKeys(password);
		loginButton.click();
  }
  @BeforeClass
  public void beforeClass() throws Exception {
		
		/**
		 * 使用selenium Grid模式
		 */
		DesiredCapabilities firefoxCap=DesiredCapabilities.firefox();
		
		firefoxCap.setBrowserName("firefox");
		//如果不知道浏览器版本、操作系统，建议不指定该信息
//		firefoxCap.setVersion("35.0.1");
//		firefoxCap.setPlatform(Platform.valueOf("VISTA"));
		
		driver=new RemoteWebDriver(new URL("http://192.168.1.25:4444/wd/hub"), firefoxCap);	  
	  
	  driver.get("http://passport.cnblogs.com/user/signin");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
