package com.jiff.loginpage.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jiff.incentives.BasePage;
import com.jiff.incentives.HomePage;
import com.jiff.incentives.LoginPage;

public class LoginPageTest {
	public BasePage base = new BasePage();
	public LoginPage login = new LoginPage();
	public HomePage home = new HomePage();

	/*@AfterClass
	public void logout(){
		home.logout();
		//BasePage.driver.close();		
	}
	*/

	@Test(enabled = true)
	public void homePageTest() {
		System.out.println("homePageTest");
		// login to jiff.com
		login.loginPage("url","bayampuser2.2086+002@gmail.com","password1"); 
		BasePage.wait(3000);
		// checks logo is present or not
		boolean result = home.isLogoPresent(); 
		Assert.assertEquals(result, true, "Logo not found");

		// checks jiff image is present or not		
		result = home.isJiffImageIsPresent(); 
		Assert.assertEquals(result, true, "Jiff image not found");

		/*// checks User name is present with "Hello or not
		String userName = home.isUserNamePresent(); 
		Assert.assertEquals(userName, "Hello Maisie Meier",
				"User Name not found");
*/
		/* checks catalog link in the menu is landing into
		 * store/product page
		 */ 
		String actualResult = home.catalogNavigation(); 
		Assert.assertEquals(actualResult, "DEVICE CATALOG");
	}

}
