package com.test.automation.tests.scripts;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;

public class SalesForceLoginAutomationScript extends BaseTest {

	@Test
	public static void login_To_SalesForce2() throws InterruptedException {

		System.out.println(
				"************* Test case SFDC (Login to Salesforce - 2 ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title",prop);
      
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, password, "password textbox");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		Thread.sleep(3000);
		String actualTitle = getPageTitle();

		Assert.assertEquals(actualTitle, expected, "test Case failed");

	}

	@Test
	public static void login_Error_Message1()

	{
		System.out.println(
				"************* Test case SFDC (Login Error Message - 1 ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Password.not.entered",prop);

		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		clearElement(passwordEle, "Password text box");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		WebElement loginErrorMsg = driver.findElement(By.id("error"));
		waitforVisibilty(loginErrorMsg, 5, "login error");

		String actual = getTextFromElement(loginErrorMsg, "loginError Message");
		Assert.assertEquals(actual, expected, "Failed : Testcase");
	}

	@Test
	public static void Check_RemeberMe3() throws InterruptedException {

		System.out.println(
				"************* Test case SFDC (Check Remember - 3 ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Password.not.entered",prop);

		waitUntilPageLoads();
		
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, password, "password textbox");

		WebElement rememberCheckbox = driver.findElement(By.id("rememberUn"));
		checkBoxElement(rememberCheckbox, "remember me");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		// time
		Thread.sleep(5000);

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");

		WebElement userMenuDropDown = driver.findElement(By.id("userNav"));
		waitforVisibilty(userMenuDropDown, driver, 30, 5,"waiting time");
		moveandClickAction(userMenuDropDown,"mouse hover user menu");
		

		WebElement logoutElement = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(5)"));
		clickElementButton(logoutElement,"logout");
		
		Thread.sleep(3000);

		WebElement user = driver.findElement(By.id("username"));
		String inputUser = user.getAttribute("value");

		Assert.assertEquals(inputUser, userName,"Test Case failed");
	}

	@Test
	public static void Forgot_Password4A() throws InterruptedException {
		System.out.println("************* Test case SFDC (Forgot Password - 4 A ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String expected = propUtility.getPropertyValue("Password.not.entered",prop);

		waitUntilPageLoads();

		WebElement forgotPasswordEle = driver.findElement(By.id("forgot_password_link"));
		clickElement(forgotPasswordEle,"forgot Password link");
		
		
		WebElement userNameElement = driver.findElement(By.id("un"));
		waitforVisibilty(userNameElement, driver, 5, "userName Text Box");
		enterText(userNameElement, userName, "username textbox");	
		
		WebElement continueElement = driver.findElement(By.id("continue"));
		clickElementButton(continueElement,"continue Element button");

		WebElement headerElement = driver.findElement(By.id("header"));
		String actual=getTextFromElement(headerElement, "header");
		
		Assert.assertEquals(actual, expected,"testCase failed");
			}

	@Test
	private static void Forgot_Password4B() throws InterruptedException {
		System.out.println("************* Test case SFDC (Invalid Username Password - 4 B ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Password.not.entered",prop);

		waitUntilPageLoads();
		
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, password, "password textbox");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		

		WebElement InvalidError = driver.findElement(By.id("error"));

		waitforVisibilty(InvalidError,30, "login error");
        String actual=getTextFromElement(InvalidError, "invalid Password");
        Assert.assertEquals(actual, expected,"failed :: testCase 4B");
		
			}


}
