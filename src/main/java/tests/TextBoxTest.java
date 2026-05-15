package tests;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
//	@Test
//	public void submitDataSuccessfully() {
//		System.setProperty("webdriver.chrome.driver",
//				"F:\\Study\\01_AutomationClass202604\\03_Practices\\02Projects\\Git\\DemoQA\\DemoQA\\driver\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver webDriver = new ChromeDriver(options);
//		webDriver.get("https://demoqa.com/text-box");
//		webDriver.manage().window().maximize();
//		webDriver.findElement(By.id("userName")).sendKeys("test");
//		webDriver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
//		webDriver.findElement(By.id("currentAddress")).sendKeys("test address");
//		webDriver.findElement(By.id("permanentAddress")).sendKeys("test perma address");
//		webDriver.findElement(By.id("submit")).click();
//
//	}

	@Test
	public void emailFormatIsWrong() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"F:\\Study\\01_AutomationClass202604\\03_Practices\\02Projects\\Git\\DemoQA\\DemoQA\\driver\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver webDriver = new ChromeDriver(options);
//		webDriver.get("https://demoqa.com/text-box");
//		webDriver.manage().window().maximize();
		testBase.webDriver.navigate().to("https://demoqa.com/text-box");
		testBase.webDriver.findElement(By.id("userName")).sendKeys("Quang Vinh");
		testBase.webDriver.findElement(By.id("userEmail")).sendKeys("testgmail.com");
		testBase.webDriver.findElement(By.id("currentAddress")).sendKeys("Khe Hoi, Thuong Tin");
		testBase.webDriver.findElement(By.id("permanentAddress")).sendKeys("Thuong Tin, Ha Noi");
		testBase.webDriver.findElement(By.id("submit")).click();
		Thread.sleep(200);
//		WebDriverWait wait = new WebDriverWait(testBase.webDriver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(By.id("userEmail"), "class", "field-error"));
		WebElement txtEmail = testBase.webDriver.findElement(By.id("userEmail"));
		String borderEmail = txtEmail.getCssValue("border-top-color");
//		System.out.println(borderEmail);
		Assert.assertTrue(borderEmail.contains("255, 0, 0"));
		Assert.assertTrue(testBase.webDriver.findElements(By.xpath("//p[@class=\"mb-1\"]")).isEmpty());
	}

}
