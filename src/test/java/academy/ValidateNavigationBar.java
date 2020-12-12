package academy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;


import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {

@BeforeTest
public void initilize() throws IOException {
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
}
	
@Test
public void basePageNavigation() throws IOException{
	
	LandingPage l = new LandingPage (driver);
	Assert.assertTrue(l.getNavBar().isDisplayed());
	
}
@AfterTest
public void teardown() {
	driver.close();
}
 
}
