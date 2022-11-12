package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	static WebDriver driver;

	// 1.open Chrome Browser
	public static void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	// 2.open Chrome Browser and get url
	public static void getUrlByChrome(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}

	// 3.open FireFox Browser
	public static void openFireFox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	// 4.open IE Browser
	public static void openIe() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	// 5.open Safari Browser
	public static void openSafari() {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
	}

	// 6.open Opera Browser
	public static void openOpera() {
		WebDriverManager.operadriver().setup();
		driver = (WebDriver) new OperaDriverManager();
	}

	// 7.open url
	public static void getUrl(String url) {
		driver.get(url);
	}

	// 8.Maximize window
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 9.Minimize window
	public static void minimizeWindow() {
		driver.manage().window().minimize();
	}

	// 10.get Current Url
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 11.Get Page Tittle
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 12.Quit
	public static void quit() {
		driver.quit();
	}

	// 13.Locate Element by Id
	public static WebElement locateById(String id) {
		WebElement findElementId = driver.findElement(By.id(id));
		return findElementId;
	}

	// 14.Locate Element by Name
	public static WebElement locateByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}

	// 15.Locate Element by ClassName
	public static WebElement locateByClassName(String className) {
		WebElement findElement = driver.findElement(By.className(className));
		return findElement;
	}

	// 16.Locate Element by Xpath
	public static WebElement locateByXpath(String xpath) {
		WebElement findElementXpath = driver.findElement(By.xpath(xpath));
		return findElementXpath;
	}

	// 17.Locate Element by TagName
	public static WebElement locateByTagName(String tagName) {
		WebElement findElement = driver.findElement(By.tagName(tagName));
		return findElement;
	}

	// 18.Locate Element by LinkText
	public static WebElement locateByLinkText(String linkText) {
		WebElement findElement = driver.findElement(By.linkText(linkText));
		return findElement;
	}

	// 19.Locate Element by PartialLinkText
	public static WebElement locateByPartialLinkText(String partialLinkText) {
		WebElement findElement = driver.findElement(By.partialLinkText(partialLinkText));
		return findElement;
	}

	// 20.Locate Element by Css Selector
	public static WebElement locateByCssSelector(String cssSelector) {
		WebElement findElement = driver.findElement(By.cssSelector(cssSelector));
		return findElement;
	}

	// 21.Click
	public static void click(WebElement element) {
		element.click();
	}

	// 22.Clear
	public static void clear(WebElement element) {
		element.clear();
	}

	// 23.Input Text
	public static void sendKeys(WebElement element, String input) {
		element.sendKeys(input);
	}

	// 24.Get Text
	public static String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}

	// 25.Get Attribute by value
	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;
	}

	// 26.Get Attribute by AttributeName
	public static String getAttributeByAttributeName(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		System.out.println(attribute);
		return attribute;
	}

	// 27.Thread.Sleep
	public static void sleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	// 28.Mouse Hover Action Move to element
	public static Actions moveToElement(WebElement target) {
		Actions actions = new Actions(driver);
		actions.moveToElement(target).perform();
		return actions;
	}

	// 29.Drag and Drop
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// 30.Right Click
	public static void rightClick(WebElement target) {
		Actions actions = new Actions(driver);
		actions.contextClick(target).perform();
	}

	// 31.Double Click
	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// 32. Key Down Action
	public static void keyDownActions(CharSequence key) {
		Actions action = new Actions(driver);
		action.keyDown(key);
	}

	// 33. Key Up Action
	public static void keyUpActions(CharSequence key) {
		Actions action = new Actions(driver);
		action.keyUp(key);
	}

	// 33.Send keys with key Code
	public static void sendKeysActions(WebElement element, String keysToSend, CharSequence keysdotCODE) {
		Actions action = new Actions(driver);
		element.sendKeys(keysToSend, keysdotCODE);
	}

	// 34.Key Press and Release By Robot Class
	public static void keyPressReleaseRobot(int keyEventdotVK_CODE) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keyEventdotVK_CODE);
		robot.keyRelease(keyEventdotVK_CODE);
	}

	// 35.Key Press By Robot Class
	public static void keyPressRobot(int keyEventdotVK_CODE) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keyEventdotVK_CODE);
	}

	// 36.Key Press By Robot Class
	public static void keyReleaseRobot(int keyEventdotVK_CODE) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(keyEventdotVK_CODE);
	}

	// 37.Accept Alert
	public static void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 38.Dismiss Alert
	public static void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 39.JS Set Text
	public static Object jsInsertText(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].setAttribute('value'," + text + ")", element);
		return executeScript;
	}

	// 40.JS get Text
	public static Object jsGetText(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].getAttribute('value')", element);
		String text = (String) executeScript;
		System.out.println(text);
		return executeScript;
	}

	// 41.JS Click
	public static void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	// 42.JS Scroll Down
	public static void jsScrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 43.JS Scroll Up
	public static void jsScrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 44.Take ScreenShot
	public static File screenShot() {
		TakesScreenshot s = (TakesScreenshot) driver;
		File screenshotAs = s.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	// 45.Take ScreenShot of a Web Element
	public static File screenShotWebElement(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	// 46. Create File
	public static File createNewFile(String location) {
		File file = new File(location);
		return file;
	}

	// 47.Copy and Paste File or ScreenShot
	public static File copyAndPasteFileOrScreenshot(File srcFile, String targetFilePath) throws IOException {
		// File srcFile = new File(SourceFileRef);
		File destFile = new File(targetFilePath);
		FileUtils.copyFile(srcFile, destFile);
		return destFile;
	}

	// 48.Navigate to
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	// 49.Navigate Back
	public static void navigateBack(String url) {
		driver.navigate().back();
	}

	// 50.Navigate Forward
	public static void navigateForward(String url) {
		driver.navigate().forward();
	}

	// 51.Refresh
	public static void refresh(String url) {
		driver.navigate().refresh();
	}

	// 52.Drop down SelectByValue
	public static void selectByValue(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 53.Drop down SelectByIndex
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 54.Drop down SelectByVisibleText
	public static String selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		return text;
	}

	// 55.Drop down Get All Options
	public static List<WebElement> getAllOptionsInDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// 56.Drop down Get All Selected Options
	public static void getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		select.getAllSelectedOptions();
	}

	// 57.Drop down Get First Selected Options
	public static void getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	// 58.Checking the multiple selection is available Boolean
	public static boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		System.out.println(multiple);
		return multiple;
	}

	// 59.Drop down Deselect By Index
	public static void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 60.Drop down Deselect By Value
	public static void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 61.Drop down Deselect By Visible Text
	public static void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 62.Drop down Deselect All
	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// 63. Switch Frame By Name Or Id
	public static void SwitchToFrameByNameOrId(String NameOrId) {
		driver.switchTo().frame(NameOrId);
	}

	// 64. Switch Frame By Index
	public static void SwitchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 65. Switch Frame By Web Element
	public static void switchToFrameByWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// 66. Switch to Parent Frame
	public static void ParentFrame() {
		driver.switchTo().defaultContent();
	}

	// 67.Get Window Handle
	public static String getWindowHandle() {
		String parentWin = driver.getWindowHandle();
		return parentWin;
	}

	// 68.Get Window Handles
	public static Set<String> getWindowHandles() {
		Set<String> AllWinId = driver.getWindowHandles();
		return AllWinId;
	}

	// 69.Switch window By Index
	public static void SwitchWindowByIndexlist(int index) {
		Set<String> setAllWinId = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		boolean addAll = list.addAll(setAllWinId);
		System.out.println(addAll);
		String window = list.get(index);
		driver.switchTo().window(window);
	}

	// 70.Switch window By Name or By Handle or By Index
	public static void switchToWindow(String nameOrHandleOrIndex) {
		driver.switchTo().window(nameOrHandleOrIndex);
	}

	// 71.Switch window to Child Window
	public static void SwitchToChildWindow() {
		String parentWin = driver.getWindowHandle();
		Set<String> AllWinId = driver.getWindowHandles();
		for (String Child : AllWinId) {
			if (!parentWin.equals(Child)) {
				driver.switchTo().window(Child);
			} else {
				System.out.println("No Child Window Available");
			}
		}
	}

	// 72.Close
	public static void close() {
		driver.close();
	}

	// 73.Implicity Wait
	public static void implicityWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// 74.Explicity Wait
	public static WebElement explicityWaitElementVisibility(Duration timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	// 75.Fluent Wait visibilityOfElementLocated
	public static Wait<WebDriver> fluentWaitByElementReturnWait(int totSec, int polSec, WebElement webElement)
			throws Exception {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(totSec))
				.pollingEvery(Duration.ofSeconds(polSec)).ignoring(Exception.class);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
		return wait;

	}

	// 76.Fluent Wait visibilityOfElementLocated Return Type element
	public static WebElement fluentWaitByElementReturnElement(int totSec, int polSec, WebElement webElement)
			throws Exception {
		WebElement Element1 = (WebElement) ((FluentWait<WebDriver>) driver).withTimeout(Duration.ofSeconds(totSec))
				.pollingEvery(Duration.ofSeconds(polSec)).ignoring(Exception.class);
		WebElement element = ((FluentWait<WebDriver>) Element1)
				.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
		return element;
	}

	// 77.FluentWait by xpath
	public static WebElement fluentWaitXpath(int totSec, int polSec, final String xpathExpression) throws Exception {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(totSec))
				.pollingEvery(Duration.ofSeconds(polSec)).ignoring(Exception.class);
		WebElement xelement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpathExpression));
			}
		});
		return xelement;
	}

	// 78.Print All Headings and Row from WebTable
	public static void WebTableHeadingsAndRowsByTagName(String tagName) {
		List<WebElement> List = driver.findElements(By.tagName(tagName));
		for (WebElement tag : List) {
			System.out.println(tag.getText());
		}
	}

	// 79.Print particular Row from WebTable
	public static String WebTablePrintParticularRow(String tagName, int index) {
		List<WebElement> List = driver.findElements(By.tagName(tagName));
		WebElement webElement = List.get(index);
		String text = webElement.getText();
		System.out.println(text);
		return text;
	}

	// 80.Read Excel
	public static String excelRead(String Path, String Sheet, int row, int cell) throws IOException {
		String value = null;
		File f = new File(Path);
		FileInputStream Fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(Fin);
		Sheet s = w.getSheet(Sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType cellType = c.getCellType();
		if (cellType == CellType.STRING) {

			value = c.getStringCellValue();
			System.out.println(value);

		} else if (cellType == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
				String format = sim.format(dateCellValue);
				System.out.println(format);
			} else {
				// double numericCellValue = c.getNumericCellValue();
				long l = (long) c.getNumericCellValue();
				value = String.valueOf(l);
				System.out.println(value);
			}
		}
		return value;

	}

	// 81.excelWrite
	public static void excelWrite(String Path, String Sheet, int row, int cell, String value) throws IOException {
		File f = new File(Path);
		FileInputStream Fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(Fin);
		Sheet s = w.getSheet(Sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		c.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
	}

	// 82.Create File or Folder
	public static File createNewFileOrFolder(String FileOrFolderPath) {
		File f = new File(FileOrFolderPath);
		return f;
	}

	// 83.Write in file
	public static void writeInFile(File f, String data) throws IOException {
		FileUtils.write(f, data, true);
		System.out.println("File Write Done");
	}

	// 84.overWrite in file
	public static void OverwriteInFile(File f, String data) throws IOException {
		FileUtils.write(f, data, false);
		System.out.println("File Overwrited");
	}

	// 85.Read file
	public static List<String> ReadFile(File f) throws IOException {
		List<String> readLines = FileUtils.readLines(f);
		return readLines;
	}

	// 86.Read File to String
	public static String readFileToString(File f) throws IOException {
		String text = FileUtils.readFileToString(f);
		return text;
	}

	// 87. Postman Rest Assured

	static RequestSpecification reqspec;
	static Response response;

	public static void addHeader(String key, String value) {
		reqspec = RestAssured.given().header(key, value);
	}

	public static void addPathParam(String key, String value) {
		reqspec = reqspec.pathParam(key, value);
	}

	public static void addQueryParam(String key, String value) {
		reqspec = reqspec.queryParam(key, value);
	}

	public static void addBody(String body) {
		reqspec = reqspec.body(body);
	}

	public static Response requestType(String type, String endpoint) {

		switch (type) {

		case "GET":
			response = reqspec.log().all().get(endpoint);
			break;

		case "POST":
			response = reqspec.log().all().post(endpoint);
			break;

		case "PUT":
			response = reqspec.log().all().put(endpoint);
			break;

		case "DELETE":
			response = reqspec.log().all().delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	public static int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		return statusCode;
	}

	public static String getResBodyAsString(Response response) {
		String asString = response.asString();
		System.out.println(asString);
		return asString;
	}

	public static String getResBodyAsPrettyString(Response response) {
		String asprettyString = response.asPrettyString();
		System.out.println(asprettyString);
		return asprettyString;

	}

	public static void basicAuth(String userName, String passWord) {
		reqspec = reqspec.auth().preemptive().basic(userName, passWord);

	}

	public static void addHeaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);
	}

	public static void addBody(Object body) {
		reqspec = reqspec.body(body);

	}

	public static void addFormDData(String key, File file) {
		reqspec = reqspec.multiPart(key, file);

	}
	public static String getProjectLoc() {
		String path = System.getProperty("user.dir");
		return path;
		
	}
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream(getProjectLoc()+"\\Config\\config.properties"));
//		
//		FileInputStream Stream=new FileInputStream(System.getProperty("user.dir")+"\\Config\\confiq.properties");
//		Properties prop=new Properties();
//		prop.load(Stream);
//		Object object = prop.get(key);
//		String value =(String)object;
				
//		String value = (String)properties.get(key);
		return (String)properties.get(key);
		
	}
	
	
}
