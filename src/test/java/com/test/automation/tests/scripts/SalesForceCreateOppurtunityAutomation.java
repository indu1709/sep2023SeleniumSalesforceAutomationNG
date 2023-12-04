package com.test.automation.tests.scripts;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;

public class SalesForceCreateOppurtunityAutomation extends BaseTest {

	public static Object[] oppurtunityDropDownList() {
		Object[] userDropDownData = { "Closing Next Month", "My Opportunities", "New Last Week", "New This Week",
				"Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won" };

		return userDropDownData;
	}

	@Test
	public static void oppurtunityDropDown() throws InterruptedException {
		System.out.println(
				"************* Test case TC15 (opportunities drop down) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

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

		WebElement oppurtunityLinkElement = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]" + ""));
		waitforVisibilty(oppurtunityLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(oppurtunityLinkElement, "mouse hover account ");

		Thread.sleep(3000);

		WebElement oppurtunityLinkElement1 = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/a[1]"));
		clickElement(oppurtunityLinkElement1, "oppurtunity");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement oppurtunityListElement = driver.findElement(By.id("fcf"));

		validateDropDownwithSelectClass(oppurtunityListElement, oppurtunityDropDownList(),
				"drop down list oppurtunity");

	}

	@Test
	public static void CreateOppurtunity() throws InterruptedException {
		System.out.println(
				"************* Test case TC16 (Create a new Opty) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		// String expectedAccountHeader =
		// propUtility.getPropertyValue("acount.header.title", prop);

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

		WebElement AccountLinkElement = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]" + ""));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		Thread.sleep(3000);

		WebElement oppurtunityLinkElement = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/a[1]"));
		clickElement(oppurtunityLinkElement, "oppurtunity");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement createNewOppElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clickElement(createNewOppElement, "oppurtunity");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		String oppName = "peppa";
		WebElement oppNameElement = driver.findElement(By.xpath("//input[@id='opp3']"));
		enterText(oppNameElement, oppName, "opp Nmae");

		String oppAccountName = "Induja";
		WebElement oppAccountNameElement = driver.findElement(By.xpath("//input[@id='opp4']"));
		enterText(oppAccountNameElement, oppAccountName, "opp AccountNmae");

		// Calendar

		driver.findElement(By.xpath("//input[@id='opp9']")).click();
		waitUntilPresenceofElementLocatedBy(By.id("datePicker"), "calendar");

		WebElement monthElement = driver.findElement(By.xpath("//select[@id='calMonthPicker']"));
		selectByVisibleText(monthElement, "December", "month");

		WebElement yearElement = driver.findElement(By.xpath("//select[@id='calYearPicker']"));
		selectByVisibleText(yearElement, "2024", "month");

		WebElement dayElement = driver.findElement(By.xpath("//td[contains(text(),'30')]"));
		clickElement(dayElement, "click on date");

		Thread.sleep(100);

		WebElement stageElement = driver.findElement(By.xpath("//select[@id='opp11']"));
		selectByVisibleText(stageElement, "Prospecting", "stage Data");

		WebElement probabilityPercentElement = driver.findElement(By.xpath("//input[@id='opp12']"));
		enterText(probabilityPercentElement, "10", "probability %");

		WebElement LeadSourceElement = driver.findElement(By.xpath("//select[@id='opp6']"));
		selectByVisibleText(LeadSourceElement, "Web", "Lead Source");

		WebElement primaryCampaignSourceElement = driver.findElement(By.xpath("//input[@id='opp17']"));
		enterText(primaryCampaignSourceElement, "Source", "primary");

		Thread.sleep(100);

	}

	@Test
	public static void CreateOppurtunityPipeLink() throws InterruptedException {
		System.out.println(
				"************* Test case TC17 (Test Opportunity Pipeline Report) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedReportHeader = propUtility.getPropertyValue("report.header.title", prop);
		String expectedPipelineHeader = propUtility.getPropertyValue("oppurtunity.pipeline.header.title", prop);

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

		WebElement AccountLinkElement = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]" + ""));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		Thread.sleep(3000);

		WebElement oppurtunityLinkElement = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/a[1]"));
		clickElement(oppurtunityLinkElement, "oppurtunity");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement oppurtunityReportElement = driver.findElement(By.xpath("//h3[contains(text(),'Reports')]"));
		waitforVisibilty(oppurtunityReportElement, 10, "Report oppurtunity HeaderName");
		String actualReportHeader = getTextFromElement(oppurtunityReportElement, "Report Header Text");
		Assert.assertEquals(actualReportHeader, expectedReportHeader, "failed : report Header title no matching");

		WebElement oppurtunitypipelineLinkElement = driver
				.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		clickElement(oppurtunitypipelineLinkElement, "oppurtunity pipeLine");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement OppurtunityPipelineElement = driver
				.findElement(By.xpath("//h1[contains(text(),'Opportunity Pipeline')]"));
		waitforVisibilty(OppurtunityPipelineElement, 10, "  oppurtunity pipeline HeaderName");
		String actualStuckHeader = getTextFromElement(OppurtunityPipelineElement,
				" oppurtunity pipeline Report Header Text");
		Assert.assertEquals(actualStuckHeader, expectedPipelineHeader,
				"failed : Stuck oppurtunity Header title no matching");

	}

	@Test
	public static void StuckOppurtunityLink() throws InterruptedException {
		System.out.println(
				"************* Test case TC18 (Test Stuck Opportunities Report) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedReportHeader = propUtility.getPropertyValue("report.header.title", prop);
		String expectedStuckOppurtunityHeader = propUtility.getPropertyValue("stuck.oppurtunity.header.title", prop);

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

		WebElement AccountLinkElement = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]" + ""));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		Thread.sleep(3000);

		WebElement oppurtunityLinkElement = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/a[1]"));
		clickElement(oppurtunityLinkElement, "oppurtunity");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement oppurtunityReportElement = driver.findElement(By.xpath("//h3[contains(text(),'Reports')]"));
		waitforVisibilty(oppurtunityReportElement, 10, "Report oppurtunity HeaderName");
		String actualReportHeader = getTextFromElement(oppurtunityReportElement, "Report Header Text");
		Assert.assertEquals(actualReportHeader, expectedReportHeader, "failed : report Header title no matching");

		WebElement StuckOppurtunityLinkElement = driver
				.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		clickElement(StuckOppurtunityLinkElement, " stuck oppurtunity link");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement StuckOppurtunityElement = driver
				.findElement(By.xpath("//h1[contains(text(),'Stuck Opportunities')]"));
		waitforVisibilty(StuckOppurtunityElement, 10, "Report Stuck oppurtunity HeaderName");
		String actualStuckHeader = getTextFromElement(StuckOppurtunityElement, "Stuck oppurtunity Report Header Text");
		Assert.assertEquals(actualStuckHeader, expectedStuckOppurtunityHeader,
				"failed : Stuck oppurtunity Header title no matching");

	}

	@Test
	public static void QuarterlySummaryLink() throws InterruptedException {
		System.out.println(
				"************* Test case TC19 (Test Quarterly Summary Report) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedQuartelySummaryHeader = propUtility.getPropertyValue("quartely.summary.header.title", prop);
		String expectedOppurtunityReportHeader = propUtility.getPropertyValue("oppurtunity.report.header.title", prop);

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

		WebElement AccountLinkElement = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]" + ""));
		waitforVisibilty(AccountLinkElement, driver, 30, 5, "waiting time");
		moveandClickAction(AccountLinkElement, "mouse hover account ");

		Thread.sleep(3000);

		WebElement oppurtunityLinkElement = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/a[1]"));
		clickElement(oppurtunityLinkElement, "oppurtunity");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement QuartelySummaryElement = driver.findElement(By.xpath("//h3[contains(text(),'Quarterly Summary')]"));
		waitforVisibilty(QuartelySummaryElement, 10, "Quartely Summary  HeaderName");
		String actualQuarterlySummaryHeader = getTextFromElement(QuartelySummaryElement,
				"Quartely Summary  HeaderName Text");
		Assert.assertEquals(actualQuarterlySummaryHeader, expectedQuartelySummaryHeader,
				"failed : Quartely Summary Header title no matching");

		String Intervaldata = "Current FQ";
		WebElement IntervalElement = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		selectByVisibleText(IntervalElement, Intervaldata, "Interval select");

		WebElement IncludeElement = driver.findElement(By.xpath("//select[@id='open']"));
		selectByVisibleText(IncludeElement, "Open Opportunities", "Include select");

		WebElement runReportElement = driver.findElement(By.xpath("//tbody/tr[3]/td[1]/input[1]"));
		clickElement(runReportElement, "run Report");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement oppurtunityReportElement = driver
				.findElement(By.xpath("//h1[contains(text(),'Opportunity Report')]"));
		waitforVisibilty(oppurtunityReportElement, 10, "oppurtunity Report    HeaderName");
		String actualOppurtunityReportHeader = getTextFromElement(oppurtunityReportElement,
				"oppurtunity Report    HeaderName Text");
		Assert.assertEquals(actualOppurtunityReportHeader, expectedOppurtunityReportHeader,
				"failed : Oppurtunity Report Header title no matching");

	}

}
