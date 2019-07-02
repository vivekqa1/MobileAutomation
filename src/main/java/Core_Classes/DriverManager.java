package Core_Classes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	
	static AndroidDriver driver;
	
	private static HashMap<String, URL> hosts;
	
	private static String appPackage = "com.divum.MoneyControl";
	
	private static DesiredCapabilities getCaps(String platformName) {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(platformName.equalsIgnoreCase("Android")) {
		
		capabilities.setCapability("appPackage", "com.divum.MoneyControl");
		capabilities.setCapability("platformName", "Android"); 
		capabilities.setCapability("platformVersion","9");
		capabilities.setCapability("deviceName","Nexus_6P");
		capabilities.setCapability("app","C:\\Users\\vparmar\\Downloads\\moneycontrol.apk");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("fullReset","false");
		capabilities.setCapability("appActivity","com.moneycontrol.handheld.SplashActivity");
		
		return capabilities;
	
		}
		
		if(platformName.equalsIgnoreCase("iOS")) {
			
			
			capabilities.setCapability("appPackage", "com.divum.MoneyControl");
			capabilities.setCapability("platformName", "iOS"); 
			capabilities.setCapability("platformVersion","9");
			capabilities.setCapability("deviceName","Nexus_6P");
			capabilities.setCapability("app","C:\\Users\\vparmar\\Downloads\\moneycontrol.apk");
			capabilities.setCapability("noReset","true");
			capabilities.setCapability("fullReset","false");
			capabilities.setCapability("appActivity","com.moneycontrol.handheld.SplashActivity");
			return capabilities;
			
		}
		
		return capabilities;
		
	}
	
	private static URL host(String platformName) throws MalformedURLException {
		
		if(hosts == null) {
			
			hosts = new HashMap<String, URL>();
			hosts.put(platformName, new URL("http://127.0.0.1:4723/wd/hub"));
		}
		return hosts.get(platformName);
	}
	
	public static void createDriver() {
		
		 driver = new AndroidDriver(host(device), getCaps());
		
	}

	public static void killDriver() {
		
		driver.quit();
	}
	
	
}
