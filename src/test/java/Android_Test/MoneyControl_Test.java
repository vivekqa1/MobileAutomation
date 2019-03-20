package Android_Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class MoneyControl_Test {

	AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appPackage", "com.divum.MoneyControl");
		capabilities.setCapability("platformName", "Android"); 
		capabilities.setCapability("platformVersion","9");
		capabilities.setCapability("deviceName","Nexus_6P");
		capabilities.setCapability("app","C:\\Users\\vparmar\\Downloads\\moneycontrol.apk");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("fullReset","false");
		capabilities.setCapability("appActivity","com.moneycontrol.handheld.SplashActivity");
		

	// This package name of your app (you can get it from apk info app)
	 // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void loginTest() throws Exception {
		
		Thread.sleep(2000);
	   //locate the Text on the calculator by using By.name()
	   WebElement loginIcon=driver.findElement(By.id("com.divum.MoneyControl:id/header_user_icon_img"));
	   loginIcon.click();
	   Thread.sleep(2000);
	   
	   WebElement userName=driver.findElement(By.id("com.divum.MoneyControl:id/loginEmailET"));
	   userName.sendKeys("testing");
	   Thread.sleep(2000);
	
	   driver.hideKeyboard();
	   
	   WebElement password =driver.findElement(By.id("com.divum.MoneyControl:id/loginePassET"));
	   password.sendKeys("testing");
	   Thread.sleep(2000);
	   
	   driver.hideKeyboard();
	   
	   WebElement logInButton=driver.findElement(By.id("com.divum.MoneyControl:id/loginBtn"));
	   logInButton.click();
	  
	}

	@AfterClass
	public void teardown() throws InterruptedException{
		//close the app
		 Thread.sleep(9000);
		 driver.quit();
	}

}
