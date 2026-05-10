package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page {
	public By chkHome = By.id("//span[contains(@class,'rc-tree-checkbox')]");
	public By tglExpand = By.id("//span[contains(@class,'rc-tree-switcher')]");

	public CheckBoxPage(WebDriver dr) {
		super(dr);

	}

}
