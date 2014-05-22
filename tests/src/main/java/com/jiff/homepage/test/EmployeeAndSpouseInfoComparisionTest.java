package com.jiff.homepage.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jiff.incentives.HomePage;
import com.jiff.incentives.LoginPage;

public class EmployeeAndSpouseInfoComparisionTest {

	HomePage home=new HomePage();
	LoginPage login=new LoginPage();

	// Opens browser and login
	@BeforeTest
	public void login() {
		login.loginPage("url","bayampuser2.2086+007@gmail.com", "password1");
	}

	@AfterTest
	public void logout(){
		home.logout();
		//BasePage.driver.close();
	}


	@Test
	public void employeeAndSpouswInfoComparisionTest(){
		employeeAndSpouseInfoComparision();
	}




	public void employeeAndSpouseInfoComparision(){

		home.getEmployeeInfo();
		home.logout();
		login.loginPage("url", "bayampuser2.2086+007s@gmail.com", "password1");
		home.getSpouseInfo();
		employeeAndSpouseInfoValidations();
		

	}
	public void employeeAndSpouseInfoValidations(){
		System.out.println("This is Employee And Spouse Info Validations");
		try{
			Assert.assertEquals(home.employee_totalEarnings, home.spouse_totalEarnings);
			System.out.println("Total Eranings are same");

		}catch(Exception e){
			System.err.println("Total Eranings are not same");
		}

		try{
			Assert.assertEquals(home.employee_currentMonth, home.spouse_currentMonth);
			System.out.println("currentMonth is  same");

		}catch(Exception e){
			System.err.println("currentMonth is not same");
		}
		try{
			Assert.assertEquals(home.employee_currentMonthYear,home. spouse_currentMonthYear);
			System.out.println("currentMonthYear is  same");

		}catch(Exception e){
			System.err.println("currentMonthYear is not same");
		}
		try{
			Assert.assertEquals(home.employee_daysLeft, home.spouse_daysLeft);
			System.out.println("daysLeft is  same");

		}catch(Exception e){
			System.err.println("daysLeft is not same");
		}
		/*try{
			//Assert.assertEquals(home.employee_stepsLeftToGoal, home.spouse_stepsLeftToGoal);
			//System.out.println("steps Left To Goal is  same");

			}catch(Exception e){
				System.err.println("stepsLeftToGoal is not same");
			}*/
		try{
			//Assert.assertEquals(home.employee_tfDaysLeftToGoal,home.spouse_tfDaysLeftToGoal);
			//System.out.println("Track food DaysLeftToGoal is  same");

		}catch(Exception e){
			System.err.println("Track foodDaysLeftToGoal is not same");
		}
		try{
			Assert.assertEquals(home.employee_empAVGsteps, home.spouse_empAVGsteps);
			System.out.println("employee AVG steps  is  same");

		}catch(Exception e){
			System.err.println("employee AVG steps is not same");
		}
		try{
			Assert.assertEquals(home.employee_empAVGtf, home.spouse_empAVGtf);
			System.out.println("employee AVG track food  is  same");

		}catch(Exception e){
			System.err.println("employee AVG track food is not same");
		}
		try{
			Assert.assertEquals(home.employee_spouseAVGsteps, home.spouse_spouseAVGsteps);
			System.out.println("Spouse AVG steps  is  same");

		}catch(Exception e){
			System.err.println("Spouse AVG steps is not same");
		}
		try{
			Assert.assertEquals(home.employee_spouseAvgtf, home.spouse_spouseAvgtf);
			System.out.println("Spouse AVG track food  is  same");

		}catch(Exception e){
			System.err.println("Spouse AVG track food is not same");
		}
		try{
			Assert.assertEquals(home.employee_myEarningsText, home.spouse_myEarningsText);
			System.out.println("myEarningsText  is  same");

		}catch(Exception e){
			System.err.println("myEarningsText is not same");
		}
		try{
			Assert.assertEquals(home.employee_EarningsPageElements, home.spouse_EarningsPageElements);
			System.out.println("Earning page elements are same");
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
