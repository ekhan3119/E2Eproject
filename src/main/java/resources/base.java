package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/iftekharchowdhoury/eclipse-workspace/E2Eproject/src/main/java/resources/data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/iftekharchowdhoury/Documents/driver/chromedriver");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("fireFox")) {
		System.setProperty("webdriver.geco.driver","/Users/iftekharchowdhoury/Documents/driver/geckodriver");
		driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
