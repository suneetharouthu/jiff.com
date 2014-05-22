package com.jiff.test.methods;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiff.incentives.BasePage;
import com.jiff.incentives.HomePage;
import com.jiff.incentives.NewHomePage;
import com.jiff.incentives.SignUpPage;
import com.jiff.incentives.WelcomePage;

public class IncentivesTestMethods {
	public BasePage base=new BasePage();
	WebDriver driver=BasePage.driver;
	public HomePage home=new HomePage();
	public NewHomePage newHome=new NewHomePage();
	public SignUpPage newUser=new SignUpPage();
	public WelcomePage welcomePage=new WelcomePage();

	public void getRegistrationTest(){
		newUser.getRegistrationPage();			
		boolean result=BasePage.isElementPresent(newUser.inviteCode);
		try{
			Assert.assertEquals(result, true);
		}catch(Exception e){
			System.err.println("InviteCode is not found");
		}
		newUser.newUserRegistration("username","password","token");
	}

	//This test will validate welcome page after user registration
	public void welcomePageTest(){	
		

		//validation for welcome page
		BasePage.wait(4000);
		boolean result;//=BasePage.isElementPresent("//*[@id='body']/section/div/a/span");	

		//Assert.assertEquals(true, result);

		//checks home link present or not
		result=BasePage.isElementPresent(home.homelink);
		try{
			Assert.assertEquals(result,true);
		}catch(Exception e){
			System.err.println("getRegistrationPageTest: homelink is not present");
		}


		//checks catalog link present or not
		result=BasePage.isElementPresent(home.catalogLink);
		try{
			Assert.assertEquals(result,true);
		}catch(Exception e){
			System.err.println("getRegistrationPageTest: catalogLink is not present");
		}

		//checks feedback link present or not
		result=BasePage.isElementPresent(home.feedBackLink);
		try{
			Assert.assertEquals(result,true);
		}catch(Exception e){
			System.err.println("getRegistrationPageTest: feedBackLink is not present");
		}

		/*//checks hello message
			String actualResult=driver.findElement(By.xpath("//*[@id='body']/nav/header/div[1]/div[3]/div/ul/li/a")).getText();
			Assert.assertEquals(actualResult, "Hello Timothy Hardy");

		/*
		 * Do validations for "Get gear" and "Set and achieve goals"
		 */

		//checks company image is present or not
		result=BasePage.isElementPresent(welcomePage.companyImage);
		try{
			Assert.assertEquals(result,true);
		}catch(Exception e){
			System.err.println("getRegistrationPageTest: companyImage is not present");
		}
		//checks initial getpaid
		String[] intialActualEarnings=welcomePage.getPaid();
		String[] initialexpectedEarnings=welcomePage.intialExpectedEarnings();
		try{
			Assert.assertEquals(intialActualEarnings[0], initialexpectedEarnings[0]);
		}catch(Exception e){
			System.err.println("welcomepage: scored amount in get paid is not correct");
		}
		try{
			Assert.assertEquals(intialActualEarnings[1], initialexpectedEarnings[1]);
		}catch(Exception e){
			System.err.println("welcomepage: Earn an aadditionla amont in get paid is not correct");
		}
		welcomePage.newUserHomePage();
		//Do validations for text also
	}

	/*
	 * validations for Home Screen
	 */
	public void newUserHomePageTest(){
		System.out.println("newUserHomePageTest");
		
		BasePage.wait(3000);
		//checks earnings gauge is present or not
		boolean actual=BasePage.isElementPresent(home.earningsGauge);
		try{
			Assert.assertEquals(actual, true);
			System.out.println("newUserHomePage: earningsGauge is present");
		}catch(Exception e){
			System.err.println("newUserHomePage: earningsGauge is not found");
		}


		//checks month selector is present or not
		actual=BasePage.isElementPresent(home.monthSelector);
		try{
			Assert.assertEquals(actual, true);
			System.out.println("newUserHomePage: monthSelector is present");
		}catch(Exception e){
			System.err.println("newUserHomePage: monthSelector is not found");
		}

		//check current month is active in month selector

		//check BeActive is present or not
		actual=BasePage.isElementPresent(home.beActive);
		try{
			Assert.assertEquals(actual, true);
			System.out.println("newUserHomePage:beActive is present");
		}catch(Exception e){
			System.err.println("newUserHomePage:beActive is not found");
		}


		//checks Track Food is present or not
		actual=BasePage.isElementPresent(home.trackFood);
		try{
			Assert.assertEquals(actual, true);
			System.out.println("newUserHomePage:trackFood is present");
		}catch(Exception e){
			System.err.println("newUserHomePage:trackFood is not found");
		}

		//checks Invite spouse if applicable
		String spouseStatus=base.isEmployeeHasSpouse();
		System.out.println("spouseStatus is"+spouseStatus);
		if(spouseStatus.equals("true")){
			actual=BasePage.isElementPresent(home.inviteEmail);
			try{
				Assert.assertEquals(actual, true);
				System.err.println("newUserHomePage:inviteEmail is present");
			}catch(Exception e){
				System.err.println("newUserHomePage:inviteEmail is not present");
			}
		}
		else{
			System.out.println("spouse is not applicable");
		}

		//Checks spouse Screen if userStatus is spouse
		String userStatus=base.getUserStatus();
		System.out.println("userStatus is"+userStatus);
		if(userStatus.equals("spouse")){
			actual=BasePage.isElementPresent(home.spouseScreenOne);
			try{
				Assert.assertEquals(actual, true);
			}catch(Exception e){
				System.err.println("newUserHomePage:spouseScreenOne is not found");
			}

			actual=BasePage.isElementPresent(home.spouseScreenTwo);
			try{
				Assert.assertEquals(actual, true);
			}catch(Exception e){
				System.err.println("newUserHomePage:spouseScreenTwo is not found");
			}
		}		
	}

	//Validations for BeActiveScreen 
	public void newUserBeActiveScreen(){
		System.out.println("beActiveScreen");
		//do validation for text at beActiveScreen
		//do validations for list when you click choose button
		//checks earnings potential
		Map<String, List<String>> actualincentivePayoutList=home.activeIncentivePayouts();
		Map<String, List<String>> expectedIncentivePayoutList=BasePage.activityGoalsModalTableWithExpecteData();
		try{
			Assert.assertEquals(actualincentivePayoutList,expectedIncentivePayoutList);
			System.out.println("beActiveScreen:incentive payouts is as expected");
		}catch(Exception e){
			System.err.println("beActiveScreen:incentive payouts not same as expected");
		}

		String[] actualChooseOnemenuList=newHome.getActualActiveScreenChooseOneList();
		String[] expectedChooseOnemenuList=base.getexpectedActiveScreenChooseOneList();
		try{
			Assert.assertEquals(actualChooseOnemenuList, expectedChooseOnemenuList);
		}catch(Exception e){
			System.out.println("ChooseOneList is not as expected");
			for(int i=0;i<4;i++){
				System.out.println(actualChooseOnemenuList[i]+" ");
			}
		}
		newHome.skipNow();
		String actualText=BasePage.driver.findElement(By.xpath("//*[@id='js-period-2014-05-01']/div[1]/div[1]/div/div[2]/p")).getText();
		try{
			Assert.assertEquals(actualText, "I'm skipping activity tracking");
			System.out.println("val=2");
		}catch(Exception e){
			System.err.println("beActiveScreen:skipnow validation failed, text is not matching with expected");
		}

		boolean actual=BasePage.isElementPresent(newHome.changeItButton);
		try{
			Assert.assertEquals(actual,true);
			System.out.println("beActiveScreen:changeItButton is present");
		}catch(Exception e){
			System.err.println("beActiveScreen:changeItButton is not present");
		}

		newHome.changeIt();
		actual= BasePage.isElementPresent(newHome.chooseOneButton);

		try{
			Assert.assertEquals(actual,true);
			System.out.println("beActiveScreen:chooseOneButton is present");
		}catch(Exception e){
			System.err.println("beActiveScreen:chooseOneButton is not present");
		}

		newHome.useMyOwnActivityTracker();
		BasePage.wait(3000);
		try{
			Assert.assertEquals(BasePage.driver.getTitle(),"Incentives by Jiff");
		}catch(Exception e){
			System.out.println("linking MyOwnActivityTracker is failed" );
		}
		//check for popup window that connected your device connected successfully
		//validate steps inBeActive Screen	

		
	}
	//validations for send an invite email to a spouse
	public void inviteSpouseTest(){
		boolean actual=false;
		//checks Invite spouse if applicable
		String spouseStatus=base.isEmployeeHasSpouse();
		System.out.println("spouseStatus is"+spouseStatus);
		if(spouseStatus.equals("true")){
			actual=BasePage.isElementPresent(home.inviteEmail);			
			try{
				Assert.assertEquals(actual, true);
				newHome.inviteSpouse("bayampuser2.2086@gmail.com");
				System.out.println("eamil send successfully");
			}catch(Exception e){
				System.err.println("newUserHaomePage:inviteEmail is not found");
			}
		}
	}


	//validations for TrackFood screen
	public void newUserTrackFoodTest(){
		System.out.println("newUserTrackFoodTest");
		boolean result=false;

		//checks Skip button
		newHome.TFSkipNow();
		result =BasePage.isElementPresent(newHome.TFchangeItButton);
		try{
			Assert.assertEquals(result, true);
			System.out.println("TFSkip is successful");
		}catch(Exception e){
			System.err.println("Track food change it button is not present");
		}
		//checks set up track 
		newHome.setUpTrackFood();
		BasePage.wait(3000);

		result=BasePage.isElementPresent(home.TFweeklyGoal);

		try{
			Assert.assertEquals(result, true);
			System.out.println("Track food weekly goal is present");
		}catch(Exception e){
			System.err.println("Track food weekly goal is not present");
		}

	}





}



