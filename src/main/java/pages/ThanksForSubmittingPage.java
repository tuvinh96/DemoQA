package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThanksForSubmittingPage extends Page{
	public String lblXpath = "//td[text()='@param']/following-sibling::td";
	
	public ThanksForSubmittingPage(WebDriver dr) {
		super(dr);
	}
	
	public String getActualText(String fieldName) {
		String newLblXpath = base.replaceXpath(lblXpath, fieldName);
		By locator = By.xpath(newLblXpath);
		String actualResult = base.getTextByLocator(locator);
		return actualResult;
	}
	
}
