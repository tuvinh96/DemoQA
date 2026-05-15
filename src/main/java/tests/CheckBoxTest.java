package tests;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestCase{
	@Test
	public void verifyCheckBoxCorrectly(){
		testBase.webDriver.navigate().to("https://demoqa.com/checkbox");
		WebElement cbHome = testBase.webDriver.findElement(By.xpath("//*[contains(@class,\"rc-tree-checkbox\") and @aria-label=\"Select Home\"]"));
		String cbHomeStatus = cbHome.getAttribute("class");
//		System.out.println(cbHomeStatus);
		Assert.assertFalse(cbHomeStatus.contains("checkbox-checked"));
		cbHome.click();
		List<WebElement> elements = testBase.webDriver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		String actualText = "You have selected :";
		String expectedText = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		for (WebElement webElement : elements) {
			String selectedItem = webElement.getText();
			actualText = actualText + " " + selectedItem;

		}
//		System.out.println(actualText);
//		System.out.println(expectedText);
		Assert.assertTrue(actualText.equals(expectedText));
		WebElement expandHome = testBase.webDriver.findElement(By.xpath("//*[contains(@class,\"rc-tree-checkbox\") and @aria-label=\"Select Home\"]/preceding-sibling::span[1]"));
		expandHome.click();
		WebDriverWait wait = new WebDriverWait(testBase.webDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"rc-tree-checkbox\") and @aria-label=\"Select Desktop\"]")));
		WebElement cbDesktop = testBase.webDriver.findElement(By.xpath("//*[contains(@class,\"rc-tree-checkbox\") and @aria-label=\"Select Desktop\"]"));
		WebElement cbDocuments = testBase.webDriver.findElement(By.xpath("//*[contains(@class,\"rc-tree-checkbox\") and @aria-label=\"Select Documents\"]"));
		WebElement cbDownloads = testBase.webDriver.findElement(By.xpath("//*[contains(@class,\"rc-tree-checkbox\") and @aria-label=\"Select Downloads\"]"));
		String cbDesktopStatus = cbDesktop.getAttribute("class");
		String cbDocumentsStatus = cbDocuments.getAttribute("class");
		String cbDownloadStatus = cbDownloads.getAttribute("class");
		Assert.assertTrue(cbDesktopStatus.contains("checkbox-checked"));
		Assert.assertTrue(cbDocumentsStatus.contains("checkbox-checked"));
		Assert.assertTrue(cbDownloadStatus.contains("checkbox-checked"));
	}

}
