package common;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public WebDriver webDriver;
	int longTimeOut;

	public void openWeb(String browserName, String url) {
		String projectPath = System.getProperty("user.dir");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			webDriver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {

		}
		webDriver.get(url);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void inputText(By locator, CharSequence... inputText) {
		waitForElement(locator, longTimeOut);
		WebElement element = webDriver.findElement(locator);
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(inputText);
		}
		else {
			System.out.println("element not visible");
		}
	}

	public void selectRadioButton(String xpath, String text) {
		String newXpath = replaceXpath(xpath, text);
		webDriver.findElement(By.xpath(newXpath)).click();

	}

	public void selectCheckBox(String xpath, String text) {
		if (text.contains(",")) {
			String[] data = text.split(",");
			for (String eachElement : data) {
				String newXpath = replaceXpath(xpath, eachElement.trim());
				webDriver.findElement(By.xpath(newXpath)).click();
			}
		}

	}

	public String replaceXpath(String originalXpath, String inputText) {
		String result = originalXpath.replace("@param", inputText);
		return result;
	}

	/**
	 * method to fill one or multiple value to a combo box
	 * 
	 * @param locator:
	 * @param text
	 */
	public void fillComboBox(By locator, String text) {
		if (text.contains(",")) {
			String[] valueOfComboBox = text.split(",");
			for (String value : valueOfComboBox) {
				String newValue = value.trim();
				inputText(locator, newValue);
				inputText(locator, Keys.ENTER);
			}
		} else {
			inputText(locator, text);
			inputText(locator, Keys.ENTER);
		}
	}

	/**
	 * Left click
	 * 
	 * @param locator
	 */
	public void clickOnElement(By locator) {
		waitForElement(locator, longTimeOut);
		WebElement element = webDriver.findElement(locator);
		if (element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("element not visible");
		}
	}

	/**
	 * Click by text
	 * 
	 * @param xpath
	 * @param text
	 */
	public void clickButtonByText(String xpath, String text) {
		String newXPath = replaceXpath(xpath, text);
		Actions action = new Actions(webDriver);
		if (text.equalsIgnoreCase("Click Me")) {
			webDriver.findElement(By.xpath(newXPath)).click();
		} else if (text.equalsIgnoreCase("Right Click Me")) {
			WebElement element = webDriver.findElement(By.xpath(newXPath));
			action.contextClick(element).perform();
		} else if (text.equals("Double Click Me")) {
			WebElement element = webDriver.findElement(By.xpath(newXPath));
			action.doubleClick(element).perform();
		}
	}

	/**
	 * Contect click (right click)
	 * 
	 * @param locator
	 */
	public void rightClick(By locator) {
		waitForElement(locator, longTimeOut);
		WebElement element = webDriver.findElement(locator);
		if (element.isDisplayed()) {
			Actions action = new Actions(webDriver);
			action.contextClick(element).perform();
		} else {
			System.out.println("element not visible");
		}
	}

	/**
	 * Double click
	 * 
	 * @param locator
	 */
	public void doubleClick(By locator) {
		waitForElement(locator, longTimeOut);
		WebElement element = webDriver.findElement(locator);
		if (element.isDisplayed()) {
			Actions action = new Actions(webDriver);
			action.doubleClick(element).perform();
		} else {
			System.out.println("element not visible");
		}
	}

	public void selectDropDownBoxByVisibleText(By locator, String text) {
		waitForElement(locator, longTimeOut);
		WebElement dropdownElement = webDriver.findElement(locator);
		if (dropdownElement.isDisplayed()) {
			Select select = new Select(dropdownElement);
			select.selectByContainsVisibleText(text);
		} else {
			System.out.println("element not visible");
		}
	}

	public String getTextByLocator(By locator) {
		String result = "";
		waitForElement(locator, longTimeOut);
		WebElement element = webDriver.findElement(locator);
		if (element.isDisplayed()) {
			result = element.getText();
		}
		return result;
	}

	public void goToPage(String url) {
		webDriver.navigate().to(url);
	}

	public void waitForElement(By locator, int timeBySecond) {

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeBySecond));
		boolean elementDisplayed = false; // element is not displayed
		int maxRetries = 5;
		int retry = 0;
		while (elementDisplayed && (retry < maxRetries)) {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (element.isDisplayed()) {
				elementDisplayed = true;
			} else {
				retry++;
			}
		}
	}
}
