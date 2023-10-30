package com.test.automation.tests.scripts;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;

public class SalesForceLeadAutomation extends BaseTest {

	public static Object[] leadDropDownList() {
		Object[] leadDropDownData = { "All Open Leads",
				"My Unread Leads", "Recently Viewed Leads", "Today's Leads",
				"View - Custom 1", "View - Custom 2" };

		return leadDropDownData;
	}

	
	@Test
	public static void clickLead() throws InterruptedException {
		System.out.println(
				"************* Test case TC20 (TC20-leadsTab) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedLeadHeader = propUtility.getPropertyValue("lead.header.title", prop);

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
		
		WebElement LeadLinkElement = driver
				.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
		waitforVisibilty(LeadLinkElement, driver, 30, 5, "Lead Link");
		moveandClickAction(LeadLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Lead");
		
		WebElement LeadHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(LeadHomeElement, driver, 5, 2, "lead Header text");
		String actualLeadHeader = getTextFromElement(LeadHomeElement, "Lead Header Text");
		Assert.assertEquals(actualLeadHeader, expectedLeadHeader, "failed : lead Header title no matching");


	}
	
	@Test
	public static void LeadSelectView() throws InterruptedException {
		System.out.println(
				"************* Test case TC21 (TC21-leadsSelectView) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedLeadHeader = propUtility.getPropertyValue("lead.header.title", prop);

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
		
		WebElement LeadLinkElement = driver
				.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
		waitforVisibilty(LeadLinkElement, driver, 30, 5, "Lead Link");
		moveandClickAction(LeadLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Lead");
		
		WebElement LeadHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(LeadHomeElement, driver, 5, 2, "lead Header text");
		String actualLeadHeader = getTextFromElement(LeadHomeElement, "Lead Header Text");
		Assert.assertEquals(actualLeadHeader, expectedLeadHeader, "failed : lead Header title no matching");
		
		
		WebElement leadListElement = driver.findElement(By.xpath("//select[@id='fcf']"));

		validateDropDownwithSelectClass(leadListElement, leadDropDownList(),
				"Lead drop down list oppurtunity");
		}

	@Test
	public static void DefaultView() throws InterruptedException {
		System.out.println(
				"************* Test case TC22 (TC22-defaultView) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedLeadHeader = propUtility.getPropertyValue("lead.header.title", prop);

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
		
		WebElement LeadLinkElement = driver
				.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
		waitforVisibilty(LeadLinkElement, driver, 30, 5, "Lead Link");
		moveandClickAction(LeadLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Lead");
		
		WebElement LeadHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(LeadHomeElement, driver, 5, 2, "lead Header text");
		String actualLeadHeader = getTextFromElement(LeadHomeElement, "Lead Header Text");
		Assert.assertEquals(actualLeadHeader, expectedLeadHeader, "failed : lead Header title no matching");
		
		String selectLeadList="My Unread Leads";
		WebElement leadListElement = driver.findElement(By.xpath("//select[@id='fcf']"));
        selectByVisibleText(leadListElement, selectLeadList, "my Unread Leads");
        
        WebElement userMenuDropDown = driver.findElement(By.id("userNav"));
		waitforVisibilty(userMenuDropDown, driver, 30, 5, "waiting time");
		moveandClickAction(userMenuDropDown, "mouse hover user menu");
		
		waitUntilElementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"), "Logout");
		WebElement logOutElement = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickElement(logOutElement, "logout");
		
		switchToDefaultFrame(driver);
		
		Thread.sleep(3000);
		WebElement usernameEle1 = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle1, driver, 5, "userName Text Box");
		enterText(usernameEle1, userName, "username textbox");

		WebElement passwordEle1 = driver.findElement(By.id("password"));
		waitforVisibilty(passwordEle1, driver, 5, "password Text Box");
		enterText(passwordEle1, password, "password textbox");

		WebElement buttonEle1 = driver.findElement(By.id("Login"));
		clickElementButton(buttonEle1, "login button");

		// time
		Thread.sleep(3000);

		//String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");
		
		WebElement LeadLinkElement1 = driver
				.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
		waitforVisibilty(LeadLinkElement1, driver, 30, 5, "Lead Link");
		moveandClickAction(LeadLinkElement1, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Lead");
		
		WebElement LeadHomeElement1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(LeadHomeElement1, driver, 5, 2, "lead Header text");
		String actualLeadHeader1 = getTextFromElement(LeadHomeElement1, "Lead Header Text");
		Assert.assertEquals(actualLeadHeader1, expectedLeadHeader, "failed : lead Header title no matching");

		WebElement leadListElement1 = driver.findElement(By.xpath("//select[@id='fcf']"));
		String defaultleadText=getSelectedValueFromElement(leadListElement1,"check default value of drop down");
		System.out.println(defaultleadText +" actual ");

		WebElement GoHomeElement1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/input[1]"));
		clickElement(GoHomeElement1, "Lead PAge Go!");
		
		switchtoWindowHandle(driver.getWindowHandle(), driver);


	}
	
	@Test
	
	public static void TodaysLead() throws InterruptedException {
		System.out.println(
				"************* Test case TC23(TC22-Todays laed link) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedLeadHeader = propUtility.getPropertyValue("lead.header.title", prop);

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
		
		WebElement LeadLinkElement = driver
				.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
		waitforVisibilty(LeadLinkElement, driver, 30, 5, "Lead Link");
		moveandClickAction(LeadLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Lead");
		
		WebElement LeadHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(LeadHomeElement, driver, 5, 2, "lead Header text");
		String actualLeadHeader = getTextFromElement(LeadHomeElement, "Lead Header Text");
		Assert.assertEquals(actualLeadHeader, expectedLeadHeader, "failed : lead Header title no matching");
		
		String selectLeadList="Today's Leads";
		WebElement leadListElement = driver.findElement(By.xpath("//select[@id='fcf']"));
        selectTextByData(leadListElement, selectLeadList, "Today's Leads");
      
        switchtoWindowHandle(driver.getWindowHandle(),driver);
        
        waitUntilElementToBeClickable(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/input[1]"), "Lead button");
        
        WebElement element=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/input[1]"));
        clickElement(element, "Lead button");
	}
	
	@Test
	public static void NewButtonLeads() throws InterruptedException {
		System.out.println(
				"************* Test case TC24(TC24-click on new Button from Lead) automation Script started **********************");
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedLeadHeader = propUtility.getPropertyValue("lead.header.title", prop);
		String expectedNewLead=propUtility.getPropertyValue("new.lead.header.title", prop);

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
		
		WebElement LeadLinkElement = driver
				.findElement(By.xpath("//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"));
		waitforVisibilty(LeadLinkElement, driver, 30, 5, "Lead Link");
		moveandClickAction(LeadLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Lead");
		
		WebElement LeadHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(LeadHomeElement, driver, 5, 2, "lead Header text");
		String actualLeadHeader = getTextFromElement(LeadHomeElement, "Lead Header Text");
		Assert.assertEquals(actualLeadHeader, expectedLeadHeader, "failed : lead Header title no matching");
		
		
		WebElement NewLeadButtonElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clickElement(NewLeadButtonElement, "New button Lead");
		
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		WebElement newLeadHomeElement = driver.findElement(By.xpath("//h2[contains(text(),'New Lead')]"));
		waitforVisibilty(newLeadHomeElement, driver, 5, 2, "lead new Header text");
		String actualnewLead = getTextFromElement(newLeadHomeElement, "Lead New Header Text");
		Assert.assertEquals(actualnewLead, expectedNewLead, "failed : lead New  Header title no matching");
		
		String lastName="ABCD";
		WebElement lastNameLead=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		enterText(lastNameLead,lastName , "last name");
		
		WebElement companyNameLead=driver.findElement(By.xpath("//input[@id='lea3']"));
		enterText(companyNameLead, lastName, "companyName");
		
		WebElement saveButtonLead=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(saveButtonLead, "save button");
		
		
		
		
		switchtoWindowHandle(driver.getWindowHandle(), driver);
	
		
		WebElement headerNewLeadElement=driver.findElement(By.xpath("//h2[contains(text(),'ABCD')]"));
		String expectedData=getTextFromElement(headerNewLeadElement, "title of th enew lead page");
		Assert.assertEquals(lastName, expectedData,"failed : last name is not same as new lead page");
		
	}


}
