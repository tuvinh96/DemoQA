package tests;

import org.testng.annotations.Test;

import pages.ButtonsPage;

public class ButtonsTest extends TestCase {
	@Test
	public void clickClickMe() {
		String btnClickMe = "Right Click Me";
		ButtonsPage buttonsPage = new ButtonsPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/buttons");
		buttonsPage.clickButton(btnClickMe);

	}

}
