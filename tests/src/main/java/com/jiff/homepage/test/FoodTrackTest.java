package com.jiff.homepage.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jiff.incentives.BasePage;
import com.jiff.incentives.HomePage;
import com.jiff.incentives.LoginPage;

public class FoodTrackTest {
	public LoginPage login=new LoginPage();
	public HomePage home=new HomePage();
	By foodTrackGraph=By.xpath("//*[@id='js-food-summaries-modal']/div");
	@BeforeClass
	public void login(){
		login.loginPage("url","bayampuser2.2086+007@gmail.com","password1");
	}

	@Test
	public void trackFoodSyncTest(){		
		BasePage.wait(3000);
		home.trackFoodSync();
		String successMessage=BasePage.driver.findElement(By.xpath("//*[@id='toast-container']/div/div")).getText();
		Assert.assertEquals(successMessage, "Food tracking data sync successful");	

	}
	@Test
	public void trackFoodViewGraphTest(){
		BasePage.wait(3000);
		home.trackFoodViewGraph();
		BasePage.wait(4000);
		boolean actual=BasePage.isElementPresent(foodTrackGraph);
		Assert.assertEquals(actual, true);		
		BasePage.driver.findElement(home.TfGraphCloseButton).click();
	}
}
