package com.test.automation.tests.scripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;

public class SalesForceContactsAutomation extends BaseTest {

	@Test
	public static void createNewContact() throws InterruptedException {
		System.out.println(
				"************* Test case TC25 (Create new contact) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);
		String expectedNewContact = propUtility.getPropertyValue("contact.new.header.title", prop);

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

		WebElement ContactLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(ContactLinkElement, driver, 30, 5, "waiting time Conatct Link");
		moveandClickAction(ContactLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Contact");

		WebElement ContactHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(ContactHomeElement, driver, 5, 2, "Contact Header text");
		String actualContactHeader = getTextFromElement(ContactHomeElement, "Contact Header Text");
		Assert.assertEquals(actualContactHeader, expectedContactHeader, "failed : Contact Header title no matching");

		WebElement ContactNewLinkElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		waitforVisibilty(ContactNewLinkElement, driver, 30, 5, "New contact Link");
		clickElement(ContactNewLinkElement, "new button");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement newContactElement = driver.findElement(By.xpath("//h2[contains(text(),'New Contact')]"));
		waitforVisibilty(newContactElement, driver, 5, 2, "lead new Header text");
		String actualnewContact = getTextFromElement(newContactElement, "Contact New Header Text");
		Assert.assertEquals(actualnewContact, expectedNewContact, "failed : Contact New  Header title no matching");

		String lastNAme = "Saravana";
		WebElement lastNameElement = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		enterText(lastNameElement, lastNAme, "last name of contact");
		String accName = "indu";
		WebElement AccountNameElement = driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(AccountNameElement, accName, "Account name of contact");

		WebElement saveButtonelement = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(saveButtonelement, "save button");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement headerNewContactElement = driver.findElement(By.xpath("//h2[contains(text(),'Saravana')]"));
		String expectedData = getTextFromElement(headerNewContactElement, "title of th enew lead page");
		Assert.assertEquals(lastNAme, expectedData, "failed : last name is not same as new lead page");

	}
	
	@Test
	public static void createNewViewContact() throws InterruptedException {
		System.out.println(
				"************* Test case TC26 (Create new View contact) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);
		String viewContactExpected = propUtility.getPropertyValue("contact.new.view.header.title", prop);

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

		WebElement ContactLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(ContactLinkElement, driver, 30, 5, "waiting time Conatct Link");
		moveandClickAction(ContactLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Contact");

		WebElement ContactHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(ContactHomeElement, driver, 5, 2, "Contact Header text");
		String actualContactHeader = getTextFromElement(ContactHomeElement, "Contact Header Text");
		Assert.assertEquals(actualContactHeader, expectedContactHeader, "failed : Contact Header title no matching");

		WebElement createNewViewContactElement = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitforVisibilty(createNewViewContactElement, driver, 30, 5, "create new View contact Link");
		clickElement(createNewViewContactElement, "new button");
		
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		WebElement createViewContactElement = driver.findElement(By.xpath("//h2[contains(text(),'Create New View')]"));
		waitforVisibilty(createViewContactElement, driver, 5, 2, "create new view Contact Header text");
		String viewContactActual = getTextFromElement(createViewContactElement, "create new view Contact Header Text");
		Assert.assertEquals(viewContactActual, viewContactExpected, "failed : Contact New  Header title no matching");
		
		String viewName="Nandhu";
		String viewUniqueName="George";
		WebElement viewNameContactElement=driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewNameContactElement,viewName , "view name");
		
		WebElement viewUniqueElement=driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(viewUniqueElement, viewUniqueName, "view Unique Name");
		
		WebElement saveButtonLead=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(saveButtonLead, "save button");
		
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/form[1]/div[1]/div[1]/img[1]"), "select dropdown");
		
		WebElement contactListElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/form[1]/div[1]/div[1]/select[1]"));
		selectTextByData(contactListElement, viewName, "view Contact dropdown");
		

	}

	@Test
	public static void checkCreatedContact() throws InterruptedException, IOException {
		System.out.println(
				"************* Test case TC27(Check recently created contact in the Contact Page) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);
		

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

		WebElement ContactLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(ContactLinkElement, driver, 30, 5, "waiting time Conatct Link");
		moveandClickAction(ContactLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Contact");

		WebElement ContactHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(ContactHomeElement, driver, 5, 2, "Contact Header text");
		String actualContactHeader = getTextFromElement(ContactHomeElement, "Contact Header Text");
		Assert.assertEquals(actualContactHeader, expectedContactHeader, "failed : Contact Header title no matching");
		
		WebElement createdContactListElement = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		selectTextByData(createdContactListElement, "Recently Created", "created Contact");
       takescreenshot(driver, "contact");
		
	}

	@Test
	public static void checkMyContact() throws InterruptedException, IOException {
		System.out.println(
				"************* Test case TC28(Check 'My contacts' view in the Contact Page) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);
		

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

		WebElement ContactLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(ContactLinkElement, driver, 30, 5, "waiting time Conatct Link");
		moveandClickAction(ContactLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Contact");

		WebElement ContactHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(ContactHomeElement, driver, 5, 2, "Contact Header text");
		String actualContactHeader = getTextFromElement(ContactHomeElement, "Contact Header Text");
		Assert.assertEquals(actualContactHeader, expectedContactHeader, "failed : Contact Header title no matching");
		
		WebElement ContactLinkdropdownElement = driver.findElement(By.xpath("//select[@id='fcf']"));
		selectByVisibleText(ContactLinkdropdownElement, "My Contacts", "drop down list");
		
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		
		
		WebElement listofContactdropdownElement=driver.findElement(By.xpath("//select[@id='00BHr00000DyLS8_listSelect']"));
		String actualValue=getSelectedValueFromElement(listofContactdropdownElement, "selected value");
		Assert.assertEquals(actualValue, "My Contacts","failed :test case selected value is not displayed");
		
		
	}


}
