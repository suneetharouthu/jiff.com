package com.jiff.firstuser.exp.test;

import org.testng.annotations.Test;

import com.jiff.incentives.BasePage;
import com.jiff.incentives.LoginPage;
import com.jiff.test.methods.IncentivesTestMethods;


public class NewUserExperienceTest extends IncentivesTestMethods {
	
	LoginPage login=new LoginPage();
	//New user with or with out spouse
	@Test
	public void newUserwithNoSpouseTest(){
		//login.loginPage("url","bayampuser2.2086+0022@gmail.com","password1"); 
		BasePage.wait(3000);
		getRegistrationTest();
		welcomePageTest();
		newUserHomePageTest();
		newUserBeActiveScreen();
		inviteSpouseTest();
		newUserTrackFoodTest();
		home.logout();
		
	}
	
	

}