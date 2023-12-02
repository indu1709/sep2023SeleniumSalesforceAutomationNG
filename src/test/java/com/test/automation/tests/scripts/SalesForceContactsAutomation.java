package com.test.automation.tests.scripts;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.exec.LogOutputStream;
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
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);
		String expectedNewContact = propUtility.getPropertyValue("contact.new.header.title", prop);

		login();
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
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);
		String viewContactExpected = propUtility.getPropertyValue("contact.new.view.header.title", prop);

		login();
		WebElement ContactLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(ContactLinkElement, driver, 30, 5, "waiting time Conatct Link");
		moveandClickAction(ContactLinkElement, "mouse hover account ");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"), "Contact");

		WebElement ContactHomeElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		waitforVisibilty(ContactHomeElement, driver, 5, 2, "Contact Header text");
		String actualContactHeader = getTextFromElement(ContactHomeElement, "Contact Header Text");
		Assert.assertEquals(actualContactHeader, expectedContactHeader, "failed : Contact Header title no matching");

		WebElement createNewViewContactElement = driver
				.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitforVisibilty(createNewViewContactElement, driver, 30, 5, "create new View contact Link");
		clickElement(createNewViewContactElement, "new button");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		WebElement createViewContactElement = driver.findElement(By.xpath("//h2[contains(text(),'Create New View')]"));
		waitforVisibilty(createViewContactElement, driver, 5, 2, "create new view Contact Header text");
		String viewContactActual = getTextFromElement(createViewContactElement, "create new view Contact Header Text");
		Assert.assertEquals(viewContactActual, viewContactExpected, "failed : Contact New  Header title no matching");

		String viewName = "Nandhu";
		String viewUniqueName = "George";
		WebElement viewNameContactElement = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewNameContactElement, viewName, "view name");

		WebElement viewUniqueElement = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(viewUniqueElement, viewUniqueName, "view Unique Name");

		WebElement saveButtonLead = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(saveButtonLead, "save button");

		switchtoWindowHandle(driver.getWindowHandle(), driver);

		waitUntilPresenceofElementLocatedBy(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/form[1]/div[1]/div[1]/img[1]"),
				"select dropdown");

		WebElement contactListElement = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/form[1]/div[1]/div[1]/select[1]"));
		selectTextByData(contactListElement, viewName, "view Contact dropdown");

	}

	@Test
	public static void checkCreatedContact() throws InterruptedException, IOException {
		System.out.println(
				"************* Test case TC27(Check recently created contact in the Contact Page) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);

		Thread.sleep(5000);
		login();
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
		String expectedContactHeader = propUtility.getPropertyValue("contact.header.title", prop);

		login();
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

		WebElement listofContactdropdownElement = driver
				.findElement(By.xpath("//select[@id='00BHr00000DyLS8_listSelect']"));
		String actualValue = getSelectedValueFromElement(listofContactdropdownElement, "selected value");
		Assert.assertEquals(actualValue, "My Contacts", "failed :test case selected value is not displayed");

	}

	@Test
	public static void ViewRecentContactsTC29() throws Exception {
		System.out.println(
				"************* Test case TC29(view Recent Contacts) automation Script started **********************");
		login();

		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(opportunitiesBtn, driver, 30, 5, "waiting time Conatct Link");

		opportunitiesBtn.click();
		Thread.sleep(2000);

		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitforVisibilty(promptEle, driver, 30, 5, "prompt element");
			promptEle.click();
		}

		// List<WebElement> li_rows
		// =driver.findElements(By.xpath("//table[contains(@class,'list')]//tbody/tr"));
		// System.out.println("rows count" +li_rows.size());
		// first contact link
		WebElement firstContactEle = driver.findElement(By.xpath("//table/tbody/tr[2]/th[1]"));
		waitforVisibilty(firstContactEle, driver, 40, 5, "Elemnt present");
		String str = driver.findElement(By.xpath("//table/tbody/tr[2]/th[1]")).getText();
		System.out.println("contact Name in link : " + str);

		driver.findElement(By.linkText(str)).click();
		Thread.sleep(3000);
		logout();

		Thread.sleep(2000);
		quitBrowser(driver);

	}

	// UniqueViewNameErrorTC30

	@Test
	public static void UniqueViewNameErrorTC30() throws Exception {
		System.out.println(
				"************* Test case TC30(UniqueViewNameErrorTC30) automation Script started **********************");

		login();

		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(opportunitiesBtn, driver, 30, 5, "waiting time Conatct Link");
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitforVisibilty(promptEle, driver, 40, 5, "prompt Element alert present");

			promptEle.click();
		}
		
		WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitforVisibilty(newView,driver, 40, 5, "new View Element present");
		newView.click();
		Thread.sleep(1000);
		
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("view1");
		Thread.sleep(1000);
		
		WebElement uniqueViewName = driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueViewName.clear();
		uniqueViewName.sendKeys("UniqueName : ABCD");
		Thread.sleep(1000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		waitforVisibilty(saveBtn,driver, 40, 5, "new View Element present");
		saveBtn.click();
		
		WebElement errorEle = driver.findElement(By.xpath("//div[contains(text(),'The View Unique Name field can only contain unders')]"));
		System.out.println("Error Msg is : "+errorEle.getText());
		
		Thread.sleep(3000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser(driver);


	}
//CreateNewViewCancelTC31
	
	@Test
	public static void CreateNewViewCancelTC31() throws Exception {
		System.out.println(
				"************* Test case TC31(CreateNewViewCancelTC31) automation Script started **********************");

		login();

		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(opportunitiesBtn, driver, 30, 5, "waiting time Conatct Link");
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
				WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
				if (promptEle.isDisplayed()) {
					waitforVisibilty(promptEle, driver, 40, 5, "prompt Element alert present");
					promptEle.click();
				}
				
				WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
				waitforVisibilty(newView,driver, 40, 5, "new View");
				newView.click();
				Thread.sleep(1000);
				
				WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
				viewName.sendKeys("ABCD");
				Thread.sleep(1000);
				
				WebElement uniqueViewName = driver.findElement(By.xpath("//input[@id='devname']"));
				uniqueViewName.click();
				uniqueViewName.clear();
				Thread.sleep(1000);
				uniqueViewName.sendKeys("EFGH");
				Thread.sleep(3000);
				
				WebElement cancelBtn = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']"));
				waitforVisibilty(cancelBtn,driver, 40, 5, "Cancel button");
				cancelBtn.click();
				
				Thread.sleep(3000);
				logout();
				
				Thread.sleep(2000);
				quitBrowser(driver);
		
	}
	
	//ContactsSaveandNewTC32
	@Test
	public static void ContactsSaveandNewTC32() throws Exception {
		System.out.println(
				"************* Test case TC32(ContactsSaveandNewTC32) automation Script started **********************");

		login();

		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitforVisibilty(opportunitiesBtn, driver, 30, 5, "waiting time Conatct Link");
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
				WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
				if (promptEle.isDisplayed()) {
					waitforVisibilty(promptEle, driver, 40, 5, "prompt Element alert present");
					promptEle.click();
				}
				
				WebElement newView = driver.findElement(By.xpath("//input[contains(@name,'new')]"));
				waitforVisibilty(newView,driver, 40, 5, "new View");
				newView.click();
				Thread.sleep(1000);
				
				WebElement lastName = driver.findElement(By.id("name_lastcon2"));
				waitforVisibilty(lastName,driver, 40, 5, "last name");
				lastName.sendKeys("Indian");
				Thread.sleep(1000);
				
				WebElement accountName = driver.findElement(By.xpath("//input[@id='con4']"));
				//accountName.sendKeys("Global Media");
				accountName.sendKeys("primary");
				Thread.sleep(3000);
				
				WebElement saveAndNew = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']"));
				waitforVisibilty(saveAndNew,driver, 40, 5, "save name");
				saveAndNew.click();
				
				WebElement errorMsg = driver.findElement(By.xpath("//div[@id='errorDiv_ep']"));
				System.out.println("ContactsSaveandNewTC32 Error : " + errorMsg.getText());
				
				Thread.sleep(4000);
				logout();
				
				Thread.sleep(2000);
				quitBrowser(driver);
			

	}
}
