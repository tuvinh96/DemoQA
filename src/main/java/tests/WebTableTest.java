package tests;

import static org.testng.Assert.assertEquals;

import java.awt.RenderingHints.Key;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.WebTablePage;
import tests.models.RegistrationForm;

public class WebTableTest extends TestCase {
	@Test(testName = "SearchFunction", dataProvider = "WebTable_TC01")
	public void searchBy(RegistrationForm registrationForm) {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.searchByText(registrationForm.searchText);
		String searchResult = webTablePage.base.getTextByLocator(webTablePage.lbSearchResult);
		if (searchResult.isEmpty()||searchResult.isBlank()) {
			webTablePage.createData(registrationForm);
			webTablePage.searchByText(registrationForm.searchText);
		}
//		String s = webTablePage.getSearchResult(registrationForm.searchText, registrationForm.searchBy);
//		System.out.println(s);
		assertEquals(webTablePage.getSearchResult(registrationForm.searchText, registrationForm.searchBy),registrationForm.searchText);
	}
//	@Test
//	public void searchByFirstName() {
//		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
//		String firstName = "Alden";
//		webTablePage.base.goToPage("https://demoqa.com/webtables");
//		webTablePage.base.inputText(webTablePage.txtSearchBox, firstName);
//		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
//		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbFirstName), firstName);
//	}
//	
//	@Test
//	public void searchByLastName() {
//		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
//		String lastName = "Gentry";
//		webTablePage.base.inputText(webTablePage.txtSearchBox, lastName);
//		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
//		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbLastName), lastName);
//	}
//	
//	public void searchByAge() {
//		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
//		String age = "";
//		webTablePage.base.inputText(webTablePage.txtSearchBox, age);
//		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
//		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbAge), age);
//		
//	}
//	
//	public void searchByEmail() {
//		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
//		String email = "";
//		webTablePage.base.inputText(webTablePage.txtSearchBox, email);
//		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
//		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbAge), email);
//	}
//	
//	public void searchBySalary() {
//		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
//		String salary = "";
//		webTablePage.base.inputText(webTablePage.txtSearchBox, salary);
//		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
//		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbAge), salary);
//	}

	@Test(testName = "SearchFunction", dataProvider = "WebTable_TC01")
	public void searchByDepartment(RegistrationForm registrationForm) {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.searchByText(registrationForm.searchText);
		if (webTablePage.base.getTextByLocator(webTablePage.lbSearchResult).isEmpty()
				|| webTablePage.base.getTextByLocator(webTablePage.lbSearchResult).isBlank()) {
			webTablePage.createData(registrationForm);
		}
//		try {
//			Thread.sleep(300);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbDepartment), registrationForm.department);
	}

	@DataProvider(name = "WebTable_TC01")
	public RegistrationForm[] readDataForNewRecord() {
		Utils utils = new Utils();
		String[][] data = utils.readDataFromCSV("WebTable_TC01.csv");
		RegistrationForm[] registrationForms = new RegistrationForm[data.length];
		for (int i = 0; i < data.length; i++) {
			RegistrationForm registrationForm = new RegistrationForm();
			registrationForm.firstName = data[i][0];
			registrationForm.lastName = data[i][1];
			registrationForm.age = data[i][2];
			registrationForm.email = data[i][3];
			registrationForm.salary = data[i][4];
			registrationForm.department = data[i][5];
			registrationForm.searchBy = data[i][6];
			registrationForm.searchText = data[i][7];
			registrationForms[i] = registrationForm;
		}
		return registrationForms;
	}
}
