package com.test.automation.tests.scripts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;

public class SeleniumCreateAccountAutomation extends BaseTest {

	@Test
	public static void createAccount() throws InterruptedException {
		System.out.println(
				"************* Test case TC10 (Create an Account) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedAccountHeader = propUtility.getPropertyValue("acount.header.title", prop);

		Thread.sleep(5000);
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

		WebElement AccountLinkElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		waitUntilPresenceofElementLocatedBy(By.xpath("//h1[contains(text(),'Accounts')]"), "header");

		WebElement accountLink = driver.findElement(By.xpath("//h1[contains(text(),'Accounts')]"));
		waitforVisibilty(accountLink, driver, 5, 2, "account Header text");
		String actualAccountHeader = getTextFromElement(accountLink, "account Header Text");
		Assert.assertEquals(actualAccountHeader, expectedAccountHeader, "failed : account Header title no matching");

		WebElement newAccountElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clickElementButton(newAccountElement, "new ");

		String expectedNewAccountHeader = "Account Edit";
		WebElement accountNewLink = driver.findElement(By.xpath("//h2[contains(text(),'Account Edit')]"));
		waitforVisibilty(accountNewLink, driver, 5, 2, "account Header text");
		String actualNewAccountHeader = getTextFromElement(accountNewLink, "account Header Text");
		Assert.assertEquals(actualNewAccountHeader, expectedNewAccountHeader,
				"failed : account Header title no matching");

		WebElement accountNameElement = driver.findElement(By.id("acc2"));
		waitforVisibilty(accountNameElement, driver, 5, "userName Text Box");
		enterText(accountNameElement, "Nans", "username textbox");

		WebElement accountTypeElement = driver.findElement(By.xpath("//select[@id='acc6']"));

		selectValueByData(accountTypeElement, "Technology Partner", "Type of account");

		WebElement customerPriority = driver.findElement(By.xpath("//select[@id='00NHr00000IHF9D']"));

		selectValueByData(customerPriority, "High", "set Customer Prority");

		//
	}

	@Test
	public static void createNewView() throws InterruptedException {
		System.out.println(
				"************* Test case TC11 (Create an Account) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedAccountHeader = "Create New View";

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

		WebElement AccountLinkElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		Thread.sleep(2000);

		WebElement newViewElement = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitforVisibilty(newViewElement, 20, "link view");
		clickElementButton(newViewElement, "new View  ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement viewHeaderElement = driver.findElement(By.xpath("//h2[contains(text(),'Create New View')]"));
		waitforVisibilty(viewHeaderElement, 10, "View HeaderName");
		String actualViewHeader = getTextFromElement(viewHeaderElement, "account Header Text");
		Assert.assertEquals(actualViewHeader, expectedAccountHeader, "failed : account Header title no matching");

		WebElement viewNameElement = driver.findElement(By.xpath("//input[@id='fname']"));
		waitforVisibilty(viewNameElement, 10, "View Name");
		String viewName = "she123";
		enterText(viewNameElement, viewName, "view Name");

		WebElement viewUniqueNameElement = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(viewUniqueNameElement, "n", "view Name");

		Thread.sleep(1000);

		WebElement saveElement = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		waitforVisibilty(saveElement, 20, "save button");
		clickElementButton(saveElement, "save button");
		switchToDefaultFrame(driver);

		WebElement viewSelectListElement = driver.findElement(By.xpath("//select[@id='00BHr00000EChmD_listSelect']"));
		waitforVisibilty(viewSelectListElement, driver, 50, 5, "viewList");
		System.out.println(viewSelectListElement.getText());

		boolean matchedView = findTextByData(viewSelectListElement, viewName, false);

		Assert.assertEquals(matchedView, true, "test case passsed");
	}

	@Test
	public static void EditView() throws InterruptedException {
		System.out.println("************* Test case TC12 (Edit view) automation Script started **********************");

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

		WebElement AccountLinkElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		Thread.sleep(2000);
		WebElement viewListElement = driver.findElement(By.xpath("//select[@id='fcf']"));
		String viewName = "indus13";
		selectTextByData(viewListElement, viewName, "view List");

		WebElement elementList = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[2]/a[1]"));
		clickElement(elementList, "Edit");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement viewNameElement = driver.findElement(By.xpath("//input[@id='fname']"));
		waitforVisibilty(viewNameElement, 10, "View Name");
		String expectedViewName = getAttributeValueFromElement(viewNameElement, "view");

		System.out.println(expectedViewName);
		Assert.assertEquals(viewName, expectedViewName, "passed : 2 Edit view Conditions in Test Case");
		enterText(viewNameElement, "New induS13 ", "view nAme");

		WebElement viewFeildElement1 = driver.findElement(By.xpath("//select[@id='fcol1']"));
		selectTextByData(viewFeildElement1, "Account Name", "feild type to Account Name");

		WebElement operatorElement1 = driver.findElement(By.xpath("//select[@id='fop1']"));
		selectByVisibleText(operatorElement1, "contains", "operatoe elemnet drop down");

		WebElement valueFeildElement1 = driver.findElement(By.xpath("//input[@id='fval1']"));
		enterText(valueFeildElement1, "a", "value feild");

		WebElement saveViewElement = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElementButton(saveViewElement, "save button");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		Thread.sleep(2000);
		WebElement viewSelectListElement = driver.findElement(By.xpath("//select[@id='00BHr00000EChmD_listSelect']"));
		waitforVisibilty(viewSelectListElement, driver, 50, 5, "viewList");
		System.out.println(viewSelectListElement.getText());

		String changedName = "New induS13";
		boolean matchedView = findTextByData(viewSelectListElement, changedName, false);

		Assert.assertEquals(matchedView, true, "test case passsed");

	}

	@Test
	public static void mergeAccount() throws InterruptedException {
		System.out.println(
				"************* Test case TC13 (Merge Accounts) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedAccountMergeTitle = propUtility.getPropertyValue("account.merge.title", prop);

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

		WebElement AccountLinkElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		waitUntilElementToBeClickable(By.id("toolsContent"), "tool");
		WebElement mergeAccountElement = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		moveandClickAction(mergeAccountElement, "mouse merge hover account ");

		Thread.sleep(1000);
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		WebElement findAccountElement = driver.findElement(By.xpath("//input[@id='srch']"));
		enterText(findAccountElement, "in", "find the account to be merged");

		WebElement findAccountSearchElement = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/input[2]"));
		clickElement(findAccountSearchElement, "search Account");

		WebElement account1Eleemnt = driver.findElement(By.xpath("//input[@id='cid0']"));
		waitforVisibilty(account1Eleemnt, 20, "account to be merged");
		checkBoxElement(account1Eleemnt, "account 1");

		WebElement account2Element = driver.findElement(By.xpath("//input[@id='cid1']"));
		waitforVisibilty(account2Element, 20, "account to be merged");
		checkBoxElement(account2Element, "account 2");

		WebElement NextElement = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[5]/div[1]/input[1]"));
		clickElement(NextElement, "next Account");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement AccountTobeMergedPage = driver
				.findElement(By.xpath("//h2[contains(text(),'Step 2. Select the values to retain')]"));
		String actualAccountMergeTitle = getTextFromElement(AccountTobeMergedPage, "actual Title");

		Assert.assertEquals(actualAccountMergeTitle, expectedAccountMergeTitle, "account Merge page : checked");

		WebElement mergeElement = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[2]"));
		clickElement(mergeElement, "merge");

		switchToAlert().accept();

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		Thread.sleep(2000);
		WebElement viewSelectListElement = driver.findElement(By.xpath("//select[@id='00BHr00000EChmD_listSelect']"));
		waitforVisibilty(viewSelectListElement, driver, 50, 5, "viewList");
		System.out.println(viewSelectListElement.getText());

		//check
	}

	@Test
	public static void accountReport() throws InterruptedException {
		System.out.println(
				"************* Test case TC14 ( Accounts Report) automation Script started **********************");
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

		WebElement AccountLinkElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		waitUntilPresenceofElementLocatedBy(By.linkText("Accounts with last activity > 30 days"), "account link");
		WebElement AccountactivityElement = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		waitforVisibilty(AccountactivityElement, driver, 30, 5, "activity account link");
		moveandClickAction(AccountactivityElement, "account activity link");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		waitUntilPresenceofElementLocatedBy(By.xpath("//input[@id='ext-gen20']"), "date feild ");
		WebElement dateFeildElement = driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		moveandClickAction(dateFeildElement, "mouse hover user menu");

		WebElement createdDateElement = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
		clickElement(createdDateElement, "created Date Element");

		waitUntilPresenceofElementLocatedBy(By.xpath("//img[@id='ext-gen152']"), "date feild ");
		WebElement fromDateElement = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		clickElement(fromDateElement, "from date img");

		waitUntilPresenceofElementLocatedBy(By.xpath("//div[@id='ext-comp-1043']"), "date feild ");
		waitUntilElementToBeClickable(By.xpath("//button[@id='ext-gen293']"), "today");
		WebElement todayElement = driver.findElement(By.xpath("//button[@id='ext-gen293']"));
		moveandClickAction(todayElement, "today date");

		//// td[@id='ext-gen292']

	}

}
