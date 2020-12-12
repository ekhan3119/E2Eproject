package academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	@BeforeTest
	public void initilize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

@Test(dataProvider="getData")
public void basePageNavigation(String Username, String Password, String text ) throws IOException {
		
		//one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		System.out.println(text);
		lp.getLogin().click();
	}
	
@DataProvider
public Object[][] getData() {
	//Row stands for how many different data types should run
	//columns stands for how many values per each test
	Object[][] data = new Object[2][3];
	//zero th row
	data[0][0]="nonrestricted@qa.com";
	data[0][1]= "123456";
	data[0][2] = "Restricted User";
	
	//1st row
	data[1][0]="nonrestricted@qa.com";
	data[1][1]="456788";
	data[1][2]="Non restricted";
	
	return data;
}
@AfterTest
public void teardown() {
	driver.close();
}
}