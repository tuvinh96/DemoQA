package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import common.TestBase;

public class TestCase {
	TestBase testBase = new TestBase();
	@BeforeTest
	public void setUp() {
		testBase.openWeb("chrome", "https://demoqa.com/");
	}
	
//	@AfterTest
	public void tearDown() {
		testBase.webDriver.quit();
	}
}
