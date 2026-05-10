package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestCase{
	@Test
	public void verifyCheckboxSuccessfully() {
		testBase.webDriver.navigate().to("https://demoqa.com/checkbox");
		testBase.webDriver.findElement(By.xpath("//span[@class='rct-title' and text()='Home']/ancestor::span[@class='rct-text']//span[contains(@class,'rct-checkbox')]")).click();
//		testBase.webDriver.findElement(tglExpand).click();
	}

}
