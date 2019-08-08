package co.edureka.selenium.webdriver.basic;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WindowHandlerBStack {

	public static final String USERNAME = "mireshsonkamble1";
	public static final String AUTOMATE_KEY = "YAyjQiCwR6QUF6DGvSBM";
	public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub/";

	public static void main(String[] args) throws Exception {
		
	    
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "75.0 beta");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("name", "Bstack-[Java] Sample Test");
		
		System.getProperties().put("http.proxyHost", "127.0.0.1");
		System.getProperties().put("http.proxyPort", "8118");
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
		
		ArrayList<String> tabs= new ArrayList<String> (driver.getWindowHandles());

		for (int i=0;i<tabs.size();i++){
			System.out.println(tabs.get(i));
		}

		driver.switchTo().window(tabs.get(1));

		System.out.println(driver.getTitle());

		driver.close();


		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle());

		driver.quit();


	}

}
