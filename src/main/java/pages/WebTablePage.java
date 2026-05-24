package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.models.RegistrationForm;

public class WebTablePage extends Page{
	public By txtSearchBox = By.id("searchBox");
	public By lbFirstName = By.xpath("//tbody/tr[1]/td[1]");
	public By lbLastName = By.xpath("//tbody/tr[1]/td[2]");
	public By lbAge = By.xpath("//tbody/tr[1]/td[3]");
	public By lbEmail = By.xpath("//tbody/tr[1]/td[4]");
	public By lbSalary = By.xpath("//tbody/tr[1]/td[5]");
	public By lbDepartment = By.xpath("//tbody/tr[1]/td[6]");
	public By btnAdd = By.id("addNewRecordButton");
	public By btnSubmit = By.id("submit");
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public By txtAge = By.id("age");
	public By txtSalary = By.id("salary");
	public By txtDepartment = By.id("department");
	public By lbSearchResult = By.tagName("tbody");
	
	public WebTablePage(WebDriver dr) {
		super(dr);
	}
	
	public void createData(RegistrationForm registrationform) {
		WebDriverWait wait = new WebDriverWait(base.webDriver, Duration.ofSeconds(5));
		base.clickOnElement(btnAdd);
		wait.until(ExpectedConditions.presenceOfElementLocated(btnSubmit));
		base.inputText(txtFirstName, registrationform.firstName);
		base.inputText(txtLastName, registrationform.lastName);
		base.inputText(txtAge, registrationform.age);
		base.inputText(txtEmail, registrationform.email);
		base.inputText(txtSalary, registrationform.salary);
		base.inputText(txtDepartment, registrationform.department);
		base.clickOnElement(btnSubmit);

	}
	
	public void searchByText(String searchText) {
		base.inputText(txtSearchBox, searchText);
		base.inputText(txtSearchBox, Keys.ENTER);
	}
	
	public String getSearchResult(String searchText, String columnName) {
		String result = "";
		switch (columnName) {
		case "firstName": {
			result = base.getTextByLocator(lbFirstName);
			break;
		}
		case "lastName": {
			result = base.getTextByLocator(lbLastName);
			break;
		}
		case "age": {
			result = base.getTextByLocator(lbAge);
			break;
		}
		case "email": {
			result = base.getTextByLocator(lbEmail);
			break;
		}
		case "salary": {
			result = base.getTextByLocator(lbSalary);
			break;
		}
		case "department": {
			result = base.getTextByLocator(lbDepartment);
			break;
		}
		default:
			System.out.println("No column to search");
			break;
		}
	return result;
	}

}
