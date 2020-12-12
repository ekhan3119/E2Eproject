package academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObject.LandingPage;

import resources.base;

public class ValidateTitle extends base{
@BeforeTest
	public void initilize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test()
	public void basePageNavigation() throws IOException {

			//one is inheritance
			// creating object to that class and invoke methods of it
			LandingPage l = new LandingPage(driver);
			Assert.assertEquals(l.getTitle().getText(), "Featured Courses");
				
			
		}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
