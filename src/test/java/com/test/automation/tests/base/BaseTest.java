package com.test.automation.tests.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.w3c.dom.html.HTMLDListElement;

import com.google.common.io.Files;
import com.test.automation.tests.utility.PropertiesUtility;

public class BaseTest {

	protected static WebDriver driver = null;

	static WebDriverWait wait = null;

	protected static String username;

	protected static String password;
	protected static String HomePageTitleexpected;

	@BeforeMethod
	@Parameters("browsername")
	public static void setUpBeforeTestMethod(@Optional("firefox") String browser_name) {
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String url = propUtility.getPropertyValue("url", prop);
		username = propUtility.getPropertyValue("login.valid.userid", prop);
		password = propUtility.getPropertyValue("login.valid.password", prop);
		HomePageTitleexpected = propUtility.getPropertyValue("Home.page.title", prop);

		launchbrowser(browser_name);
		maximizeBrowser();
		gotoUrl(url);

	}

	protected static void login() throws InterruptedException {
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitforVisibilty(usernameEle, driver, 5, "userName Text Box");

		usernameEle.sendKeys(username);

		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='password']"));

		passwordEle.sendKeys(password);

		WebElement loginEle = driver.findElement(By.xpath("//input[@id='Login']"));
		loginEle.click();

		Thread.sleep(3000);
		String actualTitle = getPageTitle();
		Assert.assertEquals(actualTitle, HomePageTitleexpected, " login Unsucessful");
	}

	
	protected static void logout() throws Exception {
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitforVisibilty(userNavBtn,driver,30,5,"click on User Nav Menu");
		userNavBtn.click();
		
		WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		waitforVisibilty(logoutBtn,driver,30,5,"click on logout");
		logoutBtn.click();
		Thread.sleep(2000);
		
	}

	@AfterMethod
	public static void tearDownAfterTestMethod() {
		closeBrowser();
		System.out.println("*****************automation script closed ******************");
	}

	public static void launchbrowser(String browserName) {
		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
			break;
		case "chrome":
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
			break;
		default:
			System.out.println("you have not entered the browser");
			break;
		}

	}

	public static void gotoUrl(String url) {
		driver.get(url);
		System.out.println(url + "is entered");

	}

	public static void maximizeBrowser() {

		driver.manage().window().maximize();
		System.out.println("maximize the window");
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	// ***************browser closed and quit ********************************8
	public static void closeBrowser() {
		driver.close();
		System.out.println("browser closed");

	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		System.out.println("All the browsers are closed");
	}

	// ********************************************************************

	public static void enterText(WebElement givenWebElement, String data, String objectName) {
		if (givenWebElement.isDisplayed()) {
			clearElement(givenWebElement, objectName);
			givenWebElement.sendKeys(data);
			System.out.println(" data is entered in the " + objectName);
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	protected static void clearElement(WebElement givenWebElement, String objectName) {
		if (givenWebElement.isDisplayed()) {
			givenWebElement.clear();
			System.out.println(objectName + " is cleared");
		} else {
			System.out.println(objectName + " is not displayed");
		}

	}

	public static void clickElementButton(WebElement buttonElement, String objectName) {
		if (buttonElement.isEnabled() || buttonElement.isDisplayed()) {
			buttonElement.click();
			System.out.println(objectName + " is clicked");
		} else {
			System.out.println(objectName + " element is not enabled");
		}

	}

	public static String getTextFromElement(WebElement element, String objectName) {
		String data = element.getText();
		System.out.println(data + "text extracted from " + objectName);
		return data;
	}

	public static void clickElement(WebElement element, String objectName) {
		element.click();
		System.out.println(objectName + " is clicked");
	}

	public static String getAttributeValueFromElement(WebElement element, String objectName) {
		String data = element.getAttribute("value");
		System.out.println(data + "text extracted from " + objectName);
		return data;
	}

	// **********************Building alert Reusable method
	// *********************************

	public static Alert switchToAlert() {

		Alert alert = driver.switchTo().alert();
		System.out.println(" switched to alert");
		return alert;

	}

	public static void AcceptAlert(Alert alert) {
		System.out.println(" Alert accepted");
		alert.accept();
	}

	public static String getAlertText(Alert alert, String objName) {
		System.out.println(" extracting text in the  " + objName + "alert");
		String text = alert.getText();
		System.out.println("text is extracted from alert box is  " + text);

		return text;
	}

	public static void dismissAlert() {
		Alert alert = switchToAlert();
		alert.dismiss();
		System.out.println("alert dismissed");
	}

	public static void sendDatatoAlert(WebElement element, String keys, String objectName) {

		driver.switchTo().alert().sendKeys(keys);

		System.out.println(objectName + " is clicked");

	}

	// *************************Action class reusable
	// methods*************************

	public static void waitUntilPageLoads() {
		System.out.println("waiting until page loads within 30 sec maximum");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static void moveToElementAction(WebElement element, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		System.err.println("cursor moved to web element " + objName);
	}

	public static void moveandClickAction(WebElement element, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		System.err.println("cursor moved to web element " + objName);
	}

	public static void ContextClickActions(WebElement elemenet, String objName) {
		Actions action = new Actions(driver);
		action.contextClick(elemenet).build().perform();
		System.out.println("right click performed on Web Element  " + objName);
	}
	// ************************Select class reusable//
	// methods**************************************

	public static void selectTextByData(WebElement element, String text, String objName) {
		waitforVisibilty(element, 5, objName);
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		System.out.println(objName + "  selected  " + text);

	}

	public static void selectByIndexData(WebElement element, int index, String objName) {
		waitforVisibilty(element, 5, objName);
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
		System.out.println(objName + "  selected with index  " + index);
	}

	public static void selectByVisibleText(WebElement element, String data, String objName) {
		waitforVisibilty(element, 5, objName);
		Select selectElement = new Select(element);
		List<WebElement> op = selectElement.getOptions();
		int size = op.size();
		for (int i = 0; i < size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
			if (options.equals(data)) {
				selectElement.selectByVisibleText(data);

			}
		}
	}

	public static String getSelectedValueFromElement(WebElement element, String objectName) {
		waitforVisibilty(element, 5, objectName);
		Select selectElement = new Select(element);
		WebElement selectEle = selectElement.getFirstSelectedOption();
		String selectedString = selectEle.getText();
		return selectedString;

	}

	public static void selectValueByData(WebElement element, String text, String objName) {
		waitforVisibilty(element, 5, objName);
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
		System.out.println(objName + "  selected ");
	}

	public static boolean findTextByData(WebElement elements, String text, boolean matched) {
		Select select = new Select(elements);
		List<WebElement> elementList = select.getOptions();

		for (WebElement element : elementList) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(text))
				;
			matched = true;
			break;
		}
		return matched;
	}

	// ****************************************************************************************************************

	public static void waitforVisibilty(WebElement webElement, WebDriver driver, int time, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		System.out.println(objectName + "is waiting for visibility  for explicit wait");
	}

	//Fluent wait
	public static void waitforVisibilty(WebElement element, WebDriver driver, int time, int pollingtime,
			String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOf(element));

		System.out.println(objectName + "is waiting for visibility  for fluent wait");
	}

	public static void waitUntilPresenceofElementLocatedBy(By locator, String objName) {
		System.out.println("waiting for an web element " + objName + " for its visibility");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void waitUntilElementToBeClickable(By locator, String objName) {
		System.out.println("waiting for an web element " + objName + " to be clickable");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static void waitforVisibilty(WebElement objectElememt, int time, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(objectElememt));
	}

	public static void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// ******************************************************************************************************
	public static void waitForAlertPresent(int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void switchToWindowOpened(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
		}

		System.out.println(" switch to new Window");
	}

	public static WebElement selectFromListUsingText(List<WebElement> list, String text) {
		WebElement element = null;
		for (WebElement ele : list) {
			if (ele.getText().equalsIgnoreCase(text)) {
				System.out.println(" selected = " + ele.getText());
				element = ele;
				break;
			}
		}

		return element;
	}

//*******************************************************************************************************************************	

	public static void takescreenshot(WebDriver driver, String filePath) throws IOException {
		TakesScreenshot screencapture = (TakesScreenshot) driver;
		File src = screencapture.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		Files.copy(src, destination);
	}

	public static void takescreenshotOfElement(WebElement Element, String filePath) throws IOException {

		File src = Element.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		Files.copy(src, destination);
	}
//*************************************************************************************************************************************

	public static void checkBoxElement(WebElement element, String objName) {
		boolean isSelected = element.isSelected();

		if (isSelected == false) {
			element.click();
		}

	}

	// ***************************************switch to
	// frame*************************************************************************

	public static void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
		System.out.println("we can switch back to the Main frame");
	}

	public static void switchToFrameID(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
		System.out.println("we can switch back to the given frame index");
	}

	public static void switchToFrame(WebElement element, String objectName) {
		driver.switchTo().frame(element);
		System.out.println("switching frame to " + objectName);
	}

	public static void goToParentFrame() {
		driver.switchTo().parentFrame();
		System.out.println("Control back to Parent Frame");
	}

	public static void switchToFrame(String frameId) {
		driver.switchTo().frame(frameId);
		System.out.println("switched control to frame");
	}

	public static void checkIfFrameAvailableAndSwitch(WebElement element, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	// *******************************************************************************************************************
	public static void switchtoWindowHandle(String windowHandle, WebDriver driver) {
		// String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}

	public static void validateDropDownwithSelectClass(WebElement element, Object[] expected, String objectName) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			Assert.assertEquals(options.get(i).getText(), expected[i]);
		}

	}

	// *************************************************************************************************************************
	public static String getTodayDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddhhmm");
		LocalDateTime now = LocalDateTime.now();
		String s = now.format(dtf);
		return s;
	}

}
