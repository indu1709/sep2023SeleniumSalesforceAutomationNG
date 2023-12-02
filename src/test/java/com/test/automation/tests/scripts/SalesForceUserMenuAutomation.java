package com.test.automation.tests.scripts;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;



public class SalesForceUserMenuAutomation extends BaseTest {

	public static Object[] dataForLogin() {
		Object[] userDropDownData = new Object[5];
		userDropDownData[0] = ("My Profile");
		userDropDownData[1] = ("My Settings");
		userDropDownData[2] = ("Developer Console");
		userDropDownData[3] = ("Switch to Lightning Experience");
		userDropDownData[4] = ("Logout");

		return userDropDownData;
	}

	@Test
	public static void userMenuDropDown() throws InterruptedException {
		System.out.println(
				"************* Test case TC05 (select User menu drop down) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

		Thread.sleep(1000);
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		waitforVisibilty(passwordEle, driver, 5, "password Text Box");
		enterText(passwordEle, password, "password textbox");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		// time
		Thread.sleep(5000);

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");

		WebElement userMenuDropDown = driver.findElement(By.id("userNav"));
		waitforVisibilty(userMenuDropDown, driver, 30, 5, "waiting time");
		moveandClickAction(userMenuDropDown, "mouse hover user menu");

		List<WebElement> optionList = driver.findElements(By.id("userNav-menuItems"));

		// Object[] data=dataForLogin();
		// for (int i = 0; i < data.length; i++)
		{
			for (WebElement option : optionList) {
				System.out.println(option.getText() + "-->" + 1);
				System.out.println();

				// Assert.assertEquals(option.getText(), data[i]);

			}
		}

	}

	@Test
	public static void userMenuDropDown_Profile() throws InterruptedException {
		System.out.println(
				"************* Test case TC06 (Profile User menu drop down) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

		waitUntilPageLoads();

		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		waitforVisibilty(passwordEle, driver, 5, "password Text Box");
		enterText(passwordEle, password, "password textbox");
		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		// time
		Thread.sleep(3000);

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");

		WebElement userMenuDropDown = driver.findElement(By.id("userNav"));
		waitforVisibilty(userMenuDropDown, driver, 30, 5, "waiting time");
		moveandClickAction(userMenuDropDown, "mouse hover user menu");

		WebElement profileElement = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(profileElement, "profile Element");

		WebElement profilePageElement = driver.findElement(By.id("chatterTab"));
		waitforVisibilty(profilePageElement, 10, "profile page Opened");
		// **********************Edit Contact and Edit
		// Profile****************************************
		WebElement contactElement = driver
				.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]"));
		clickElement(contactElement, "contact pencil");

		WebElement contactInfoFrame = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		waitforVisibilty(contactInfoFrame, driver, 40, 5, "contact from edit profile");
		driver.switchTo().frame(contactInfoFrame);

		Thread.sleep(1000);
		WebElement AboutTabElement = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		clickElement(AboutTabElement, "About Tab from edit profile");

		WebElement lastNameElement = driver.findElement(By.xpath("//input[@id='lastName']"));
		waitforVisibilty(lastNameElement, driver, 40, 5, "last");
		String lastame = "Saravana";
		enterText(lastNameElement, lastame, "last Name");

		WebElement saveAllElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		clickElementButton(saveAllElement, "Save All from Edit Profile");

		switchToDefaultFrame(driver);
		WebElement UserProfileNAme = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
		String text = getTextFromElement(UserProfileNAme, "user profile name");
		boolean matched = false;
		if (text.contains(lastame)) {
			matched = true;
		}
		Assert.assertEquals(matched, true, "last name is not changed from edit profile");

		// **********************************Post Link*******************************

		WebElement postLinkElement = driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
		clickElement(postLinkElement, "Post Link");

		WebElement postLinkFrame = driver.findElement(By.xpath(
				"//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/iframe[1]"));
		waitforVisibilty(postLinkFrame, driver, 10, "post link");
		switchToFrame(postLinkFrame, "post Link body");

		WebElement postLinkBody = driver.findElement(By.cssSelector("body"));
		waitforVisibilty(postLinkBody, driver, 5, 2, "post link Text");
		clickElement(postLinkBody, "Post link text");

		postLinkBody.sendKeys("Good Morning");

		switchToDefaultFrame(driver);
		WebElement shareElement = driver.findElement(By.name("publishersharebutton"));
		clickElement(shareElement, "share post");

		// ********************update my profile**********************************

		WebElement uploadpicElement = driver.findElement(By.id("photoSection"));
		moveToElementAction(uploadpicElement, "upload");

		WebElement updatepicElement = driver.findElement(By.id("uploadLink"));
		clickElement(updatepicElement, "udate");
		Thread.sleep(2000);

		WebElement uploadPhotoFrameElement = driver.findElement(By.xpath("//[@id=\"uploadPhotoContentId\"]"));
		driver.switchTo().frame(uploadPhotoFrameElement);

		Thread.sleep(2000);

		WebElement uploadPicLinkElement = driver.findElement(By.id(""));
		uploadPicLinkElement.sendKeys("");

		WebElement saveButtonElement = driver.findElement(By.xpath(""));
		clickElementButton(saveButtonElement, "upload File");

	}

	@Test
	public static void developerConsole_UserMenu() throws InterruptedException {
		System.out.println(
				"************* Test case TC09 (Log out from User menu drop down) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

		// waitUntilPageLoads();
		Thread.sleep(1000);
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, password, "password textbox");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		// time
		Thread.sleep(5000);

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");

		WebElement userMenuDropDown = driver.findElement(By.id("userNav"));
		waitforVisibilty(userMenuDropDown, driver, 30, 5, "waiting time");
		moveandClickAction(userMenuDropDown, "mouse hover user menu");

		WebElement developerElement = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		clickElement(developerElement, "developer Console");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		Thread.sleep(3000);

		quitBrowser(driver);
	}

	@Test(dataProvider = "getData")
	public static void LogOut_UserMenu(Object[] userDropDownData) throws InterruptedException {
		System.out.println(
				"************* Test case TC08 (select developer console from User menu drop down) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

		// waitUntilPageLoads();
		Thread.sleep(1000);
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");
		enterText(usernameEle, userName, "username textbox");

		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, password, "password textbox");

		WebElement buttonEle = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle, "login button");

		// time
		Thread.sleep(5000);

		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");

		WebElement userMenuDropDown = driver.findElement(By.id("userNav"));
		waitforVisibilty(userMenuDropDown, driver, 30, 5, "waiting time");
		moveandClickAction(userMenuDropDown, "mouse hover user menu");

		List<WebElement> optionList = driver.findElements(By.id("userNav-menuItems"));

		for (WebElement ele : optionList) {
			System.out.println(ele.getText());
		}

		WebElement logOutElement = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickElement(logOutElement, "logout");

		quitBrowser(driver);
	}
}
