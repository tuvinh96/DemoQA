package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage extends Page {
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
//	public By rdGender = By.xpath("//*[@for='gender-radio-2']");
	public String rdGender = "//label[text()='@param']";
	public By txtMobile = By.id("userNumber");
	public By txtDateOfBirth = By.id("dateOfBirthInput");
	public By ddlYear = By.xpath("//*[@class='react-datepicker__year-select']");
	public By ddlMonth = By.xpath("//*[@class='react-datepicker__month-select']");
	public String lblDay = "//div[@role='row'][@param1]//div[text()='@param2']";
	public By cbSubject = By.id("subjectsInput");
	public String chkHobbies = "//label[text()='@param']";
	public By txtPicture = By.id("uploadPicture");
	public By txtCurrentAddress = By.id("currentAddress");
	public By cbState = By.xpath("//*[@id='state']//input");
	public By cbCity = By.xpath("//*[@id='city']//input");
	public By btnSubmit = By.id("submit");

	public PracticeFormPage(WebDriver dr) {
		super(dr);

	}

	public ThanksForSubmittingPage inputData(String firstName, String lastName, String email, String gender,
			String mobileNumber, String dateOfBirth, String subject, String hobbies, String picture,
			String currentAddress, String state, String city) {
		base.inputText(txtFirstName, firstName);
		base.inputText(txtLastName, lastName);
		base.inputText(txtEmail, email);
		base.selectRadioButton(rdGender, gender);
		base.inputText(txtMobile, mobileNumber);
		selectDateOfBirth(dateOfBirth);
		base.fillComboBox(cbSubject, subject);
		base.selectCheckBox(chkHobbies, hobbies);
		base.inputText(txtPicture, picture);
		base.inputText(txtCurrentAddress, currentAddress);
		base.fillComboBox(cbState, state);
		base.fillComboBox(cbCity, city);
//		base.clickOnElement(btnSubmit);
		return new ThanksForSubmittingPage(driver);
	}

	public void submitForm() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		base.clickOnElement(btnSubmit);
		wait.until(ExpectedConditions.attributeContains(By.id("userForm"), "class", "was-validated"));
	}

	public void selectDateOfBirth(String dateOfBirth) {
		String[] dateOfBirths = dateOfBirth.split(" ");
		base.clickOnElement(txtDateOfBirth);
		base.selectDropDownBoxByVisibleText(ddlYear, dateOfBirths[2].toString());
		base.selectDropDownBoxByVisibleText(ddlMonth, dateOfBirths[1].toString());
		String newDayXpath = lblDay.replace("@param1", "3").replace("@param2", dateOfBirths[0]);
		base.clickOnElement(By.xpath(newDayXpath));
	}

}
