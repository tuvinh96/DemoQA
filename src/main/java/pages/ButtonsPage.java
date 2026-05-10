package pages;

import org.openqa.selenium.WebDriver;

public class ButtonsPage extends Page {
	public String btnClick = "//button[text()='@param']";

	public ButtonsPage(WebDriver dr) {
		super(dr);
	}
	public void clickButton(String text) {
		base.clickButtonByText(btnClick, text);
	}

}
