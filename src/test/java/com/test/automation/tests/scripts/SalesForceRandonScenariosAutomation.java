package com.test.automation.tests.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;

public class SalesForceRandonScenariosAutomation extends BaseTest {
	@Test
	public static void ValidateUserNameLinkTC33() throws Exception {
		System.out.println(
				"************* Test case TC33(ValidateUserNameLinkTC33) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String firstName = propUtility.getPropertyValue("login.valid.firstName", prop);
		String lastName = propUtility.getPropertyValue("login.valid.lastName", prop);

		login();

		WebElement homeEle = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
		homeEle.click();
		Thread.sleep(3000);
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitforVisibilty(promptEle, driver, 30, 5, "prompt element");
			promptEle.click();
		}

		// span[@id='userNavLabel']
		WebElement usernameLink = driver.findElement(By.linkText(firstName + " " + lastName));
		waitforVisibilty(usernameLink, driver, 30, 5, "userName Link");
		usernameLink.click();

		Thread.sleep(3000);
		quitBrowser(driver);

	}

	// EditedLastNameTC34

	@Test
	public static void EditedLastNameTC34() throws Exception {
		System.out.println(
				"************* Test case TC34(EditedLastNameTC34) automation Script started **********************");

		login();
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitforVisibilty(userNavBtn, driver, 30, 5, "waiting time");
		moveandClickAction(userNavBtn, "mouse hover user menu");
		Thread.sleep(2000);

		WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		waitforVisibilty(myProfile,driver, 30, 5, "waiting time");
		myProfile.click();
		Thread.sleep(2000);

		waitUntilPresenceofElementLocatedBy((By.xpath("//a[@class='contactInfoLaunch editLink']//img")),"Edit Link");
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		Thread.sleep(2000);

		// WebElement aboutFrameEle = driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.id("aboutTab")).click();
		Thread.sleep(2000);

		WebElement lastNameEle = driver.findElement(By.id("lastName"));
		lastNameEle.click();
		lastNameEle.clear();
		lastNameEle.sendKeys("ABCD");

		WebElement saveAllEle = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveAllEle.click();
		Thread.sleep(2000);

		WebElement userNavBtn1 = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitforVisibilty(userNavBtn, driver, 30, 5, "waiting time");
		System.out.println("user Menu button text: " + userNavBtn1.getText());
		String userNameStr1 = (userNavBtn1.getText().split(" "))[1];
		Thread.sleep(2000);

		WebElement userNavlabel = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
		waitforVisibilty(userNavlabel, driver, 30, 5, "waiting time");

		System.out.println("userName text in MyProfile Page: " + userNavlabel.getText());
		String userNameStr2 = (userNavlabel.getText().split(" "))[1];

		Thread.sleep(2000);

		String updatedStr = "ABCD";
		System.out.println("updated name : " + updatedStr);
		if (userNameStr1.equals(updatedStr) && userNameStr2.equals(updatedStr)) {
			System.out.println("Success : Last Name is updated in all places");
		} else {
			System.out.println("Failed : Last Name is not updated.");
		}

		Thread.sleep(2000);
		quitBrowser(driver);

	}
	
	//RemoveTabsTC35
	
	@Test
	public static void RemoveTabsTC35() throws Exception {
		System.out.println(
				"************* Test case TC35(RemoveTabsTC35) automation Script started **********************");

		login();
		
		WebElement plusTab = driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
		waitforVisibilty(plusTab,20,"plusTab");
		plusTab.click();
		Thread.sleep(2000);
		
		WebElement customizeTab =  driver.findElement(By.xpath("//input[@name='customize']"));
		waitforVisibilty(customizeTab,30,"customizeTab");
		customizeTab.click();
		Thread.sleep(2000);

		Select selectedTabs = new Select(driver.findElement(By.xpath("//select[@id='duel_select_1']")));
		selectedTabs.selectByIndex(1);
		
		
		WebElement removeBtn = driver.findElement(By.xpath("//img[contains(@class,'leftArrowIcon')]"));
		waitforVisibilty(removeBtn,30,"removeBtn");
		removeBtn.click();
		Thread.sleep(2000);
		
		
		WebElement saveBtn = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		waitforVisibilty(saveBtn, 20, "Save Button");
		saveBtn.click();
		Thread.sleep(3000);
		logout();
		Thread.sleep(3000);
		login();
		Thread.sleep(4000);
		logout();
		Thread.sleep(3000);
		quitBrowser(driver);

	}

	
	//BlockDateForEventTC36
	
	@Test
	public static void BlockDateForEventTC36() throws Exception {
		System.out.println(
				"************* Test case TC36(BlockDateForEventTC36) automation Script started **********************");

		login();
		WebElement homeBtn = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		waitforVisibilty(homeBtn,20,"home btn");
		homeBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitforVisibilty(promptEle,30,"prompt element");
			promptEle.click();
		}
		
		WebElement todaysDate =  driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]"));
		waitforVisibilty(todaysDate,20,"todays Date");
		System.out.println("username date link : " + todaysDate.getText());
		driver.findElement(By.linkText(todaysDate.getText())).click();
		Thread.sleep(2000);
		
		
		WebElement eightpmBtn = driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
		waitforVisibilty(eightpmBtn,30,"eight pm button");
		eightpmBtn.click();
		Thread.sleep(2000);
		
		
		WebElement comboboxBtn = driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]"));
		waitforVisibilty(comboboxBtn,30,"combo button");
		comboboxBtn.click();
		Thread.sleep(2000);
		String handleWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String[] window = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(window[1]);
		
		driver.manage().window().maximize();
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//a[contains(text(),'Other')]"),"Other link");
		Thread.sleep(1000);
		WebElement secondWindEle = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		String OtherText = secondWindEle.getText();
		driver.close();
		driver.switchTo().window(handleWindow);
		Thread.sleep(3000);
		
		WebElement subjectEle = driver.findElement(By.xpath("//input[@id='evt5']"));
		waitforVisibilty(subjectEle, 20, "Save Button");
		subjectEle.sendKeys(OtherText);
		Thread.sleep(2000);
		
		
		//System.out.println(driver.getTitle());
		WebElement EndDate = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		waitforVisibilty(EndDate, 20, "End Date Button");
		EndDate.click();
		Thread.sleep(2000);
		
		WebElement Enddatadropdown = driver.findElement(By.xpath("//div[@id='timePickerItem_42']"));
		waitforVisibilty(Enddatadropdown, 20, "End Data  Button");
		Enddatadropdown.click();
		
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]"));
		waitforVisibilty(saveBtn, 20, "Save Button");
		saveBtn.click();
		Thread.sleep(2000);

		Thread.sleep(3000);
		quitBrowser(driver);

		
	}
	
	//ReccuranceBlockDateTC37
	@Test
	public static void ReccuranceBlockDateTC37() throws Exception {
		System.out.println(
				"************* Test case TC36(ReccuranceBlockDateTC37) automation Script started **********************");

		login();
		
		WebElement homeBtn = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		waitforVisibilty(homeBtn,20,"home btn");

		homeBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitforVisibilty(promptEle,20,"prompt Element Button");
			promptEle.click();
		}
		
		WebElement todaysDate =  driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]"));
		waitforVisibilty(todaysDate,30,"todays Date");
		System.out.println("username date link : " + todaysDate.getText());
		driver.findElement(By.linkText(todaysDate.getText())).click();
		Thread.sleep(2000);
		
		
		WebElement eightpmBtn = driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]"));
		waitforVisibilty(eightpmBtn,driver,30,5,"eight pm ");
		eightpmBtn.click();
		Thread.sleep(2000);
		
		
		WebElement comboboxBtn = driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]"));
		waitforVisibilty(comboboxBtn,20,"Combo Button");
		comboboxBtn.click();
		Thread.sleep(2000);
		String handleWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String[] window = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(window[1]);
		
		driver.manage().window().maximize();
		
		waitUntilPresenceofElementLocatedBy(By.xpath("//a[contains(text(),'Other')]"),"Other link");
		Thread.sleep(1000);
		WebElement secondWindEle = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		String OtherText = secondWindEle.getText();
		driver.close();
		driver.switchTo().window(handleWindow);
		Thread.sleep(3000);
		
		WebElement subjectEle = driver.findElement(By.xpath("//input[@id='evt5']"));
		waitforVisibilty(subjectEle,20,"Subject Elemnt");
		subjectEle.sendKeys(OtherText);
		Thread.sleep(2000);
		
		
		//System.out.println(driver.getTitle());
		WebElement EndDate = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		waitforVisibilty(EndDate,20,"EndDate");
		EndDate.click();
		Thread.sleep(2000);
		
		WebElement Enddatadropdown = driver.findElement(By.xpath("//div[@id='timePickerItem_38']"));
		waitforVisibilty(Enddatadropdown,25,"data drop down");
		Enddatadropdown.click();
		
		
		WebElement reccurrence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		waitforVisibilty(reccurrence,25,"recurrance");
		reccurrence.click();
		Thread.sleep(2000);
		
		
		WebElement updateWeekly = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		waitforVisibilty(updateWeekly,30,"update weekly");
		updateWeekly.click();
		Thread.sleep(2000);
		
		
		WebElement reccurrenceForEvery = driver.findElement(By.xpath("//input[@id='wi']"));
		waitforVisibilty(reccurrenceForEvery,20,"recur Element");
		reccurrenceForEvery.click();
		reccurrenceForEvery.clear();
		reccurrenceForEvery.sendKeys("1");
		Thread.sleep(2000);
		
		
		//input[@id='RecurrenceEndDateOnly']
	    int noOfDays = 14; //i.e two weeks
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());            
	    calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
	    Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    String newDate = dateFormat.format(date);
	    System.out.println("two weeks from today : " + newDate);
	  
	    WebElement reccEndDate = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
	    waitforVisibilty(reccEndDate,30,"rec End Date");
		reccEndDate.sendKeys(newDate);
		Thread.sleep(2000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]"));
		waitforVisibilty(saveBtn,30,"save Button");
		saveBtn.click();
		Thread.sleep(2000);
		
		
		WebElement monthView = driver.findElement(By.xpath("//img[contains(@class,'monthViewIcon')]"));
		waitforVisibilty(monthView,30,"month View");
		monthView.click();
		Thread.sleep(3000);
		
		
		WebElement nextMonth = driver.findElement(By.xpath("//img[contains(@class,'nextCalArrow')]"));
		waitforVisibilty(nextMonth,20,"Next Month");
		nextMonth.click();
		Thread.sleep(5000);
		quitBrowser(driver);


	}

}
