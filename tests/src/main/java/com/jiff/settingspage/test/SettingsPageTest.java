package com.jiff.settingspage.test;

import org.testng.annotations.Test;

import junit.framework.Assert;

import com.jiff.incentives.BasePage;
import com.jiff.incentives.HomePage;
import com.jiff.incentives.LoginPage;
import com.jiff.incentives.SettingsPage;

public class SettingsPageTest {
	HomePage home=new HomePage();
	LoginPage login=new LoginPage();
	SettingsPage settings=new SettingsPage();

	@Test(enabled=true)
	public void settingsPageUpdateNameTest(){
		updateNameMethod("Sara","chen");
		
	}
	@Test
	public void settingsPageUpdatePasswordTest(){
		updatePasswordMethod("password2","password1");
		
	}
	/*
	 * this method will update first name and last name in settings page
	 * and verifies updates are successful or not
	 */
	public void updateNameMethod(String firstName,String lastName){
		login.loginPage("url", "bayampuser2.2086+002@gmail.com", "password2");
		home.getSettingsPage();
		String email=settings.getCurrentEmail();
		settings.updateName(firstName,lastName);
		home.logout();
		login.loginPage("url", "bayampuser2.2086+002@gmail.com", "password2");
		home.getSettingsPage();
		if(!firstName.equals(null)){
		String actualFirstName=BasePage.driver.findElement(settings.settingsFirstName).getAttribute("value");
		try{
		Assert.assertEquals(firstName, actualFirstName);
		}catch(Exception e){
			System.out.println("FirstName not updated successfully");
		}
		}
		if(!(lastName.equals(null))){
		String actualLastName=BasePage.driver.findElement(settings.settingsLastName).getAttribute("value");
		try{
		Assert.assertEquals(lastName, actualLastName);
		}catch(Exception e){
			System.out.println("Last Name is not updated successfully");
		}
		}
		home.logout();
		}
	
	/*
	 * this method will update password and verifies update successful or not
	 */
	public void updatePasswordMethod(String currentPassword,String newPassword){
		
		login.loginPage("url", "bayampuser2.2086+002@gmail.com",currentPassword);
		home.getSettingsPage();
		settings.updatePassword(currentPassword, newPassword);
		home.logout();
		login.loginPage("url", "bayampuser2.2086+002@gmail.com", newPassword);
		boolean actual=BasePage.isElementPresent(home.homelink);
		try{
			Assert.assertEquals(true, actual);
		}catch(Exception e){
			System.out.println("Password is not updated successfully");
		}
		home.logout();
	}

}

