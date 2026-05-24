package tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.PracticeFormPage;
import pages.ThanksForSubmittingPage;
import tests.models.StudentRegistration;

public class PracticeFormTest extends TestCase {
	@Test(dataProvider = "PracticeForm_TC01")
	public void submitDataSuccessfully_DataProvider(String firstName, String lastName, String email, String gender,
			String mobileNumber, String dateOfBirth, String subject, String hobbies, String picture,
			String currentAddress, String state, String city) {
		String picturePath = System.getProperty("user.dir") + "\\testcase\\TestData\\" + picture;
//		String firstName = "Vinh";
//		String lastName = "Tu";
//		String email = "vinhqt170796@gmail.com";
//		String gender = "Female";
//		String mobileNumber = "0972358327";
//		String dateOfBirthYear = "1996";
//		String dateOfBirthDayAndMonth = "17 July";
//		String dateOfBirth = dateOfBirthDayAndMonth + " " + dateOfBirthYear;
//		String subject = "Maths, English, Chemistry";
//		String hobbies = "Sports, Reading, Music";
//		String projectPath = System.getProperty("user.dir");
//		String fileName = "UA5A6606.jpg";
//		String picture = projectPath + "\\testcase\\TestData\\" + fileName;
//		String currentAddress = "Thuong Tin, Ha Noi";
//		String state = "NCR";
//		String city = "Noida";

		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");

		ThanksForSubmittingPage thanksForSubmittingPage = practiceFormPage.inputData_1(firstName, lastName, email, gender,
				mobileNumber, dateOfBirth, subject, hobbies, picturePath, currentAddress, state, city);
		practiceFormPage.submitForm();

		String actualStudentName = thanksForSubmittingPage.getActualText("Student Name");
		String expectedStudentName = firstName + " " + lastName;
		assertEquals(actualStudentName, expectedStudentName);
		String actualEmail = thanksForSubmittingPage.getActualText("Student Email");
		assertEquals(actualEmail, email);
		String actualGender = thanksForSubmittingPage.getActualText("Gender");
		assertEquals(actualGender, gender);
		String actualMobileNumber = thanksForSubmittingPage.getActualText("Mobile");
		assertEquals(actualMobileNumber, mobileNumber);
		String actualDateOfBirth = thanksForSubmittingPage.getActualText("Date of Birth");
//		int firstSpace = dateOfBirth.indexOf(" ");
//		int secondSpace = dateOfBirth.indexOf(" ", firstSpace + 1);
		String[] dateOfBirths = dateOfBirth.split(" ");
		String expectedDateOfBirth = dateOfBirths[0] + " " + dateOfBirths[1] + "," + dateOfBirths[2];
		assertEquals(actualDateOfBirth, expectedDateOfBirth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subjects");
		assertEquals(actualSubject, subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies, hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture, picture);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress, currentAddress);
		String actualStateAndCity = thanksForSubmittingPage.getActualText("State and City");
		String givenStateAndCity = state + " " + city;
		assertEquals(actualStateAndCity, givenStateAndCity);

	}

	@Test(dataProvider = "PracticeForm_TC01_1")
	public void submitDataSuccessfully(StudentRegistration studentRegistration) {
//		String picturePath = System.getProperty("user.dir") + "\\testcase\\TestData\\" + studentRegistration.picture;
		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");

		ThanksForSubmittingPage thanksForSubmittingPage = practiceFormPage.inputData(studentRegistration);
		practiceFormPage.submitForm();

		String actualStudentName = thanksForSubmittingPage.getActualText("Student Name");
		String expectedStudentName = studentRegistration.firstName + " " + studentRegistration.lastName;
		assertEquals(actualStudentName, expectedStudentName);
		String actualEmail = thanksForSubmittingPage.getActualText("Student Email");
		assertEquals(actualEmail, studentRegistration.email);
		String actualGender = thanksForSubmittingPage.getActualText("Gender");
		assertEquals(actualGender, studentRegistration.gender);
		String actualMobileNumber = thanksForSubmittingPage.getActualText("Mobile");
		assertEquals(actualMobileNumber, studentRegistration.mobileNumber);
		String actualDateOfBirth = thanksForSubmittingPage.getActualText("Date of Birth");
		String[] dateOfBirths = studentRegistration.dateOfBirth.split(" ");
		String expectedDateOfBirth = dateOfBirths[0] + " " + dateOfBirths[1] + "," + dateOfBirths[2];
		assertEquals(actualDateOfBirth, expectedDateOfBirth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subjects");
		assertEquals(actualSubject, studentRegistration.subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies, studentRegistration.hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture, studentRegistration.picture);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress, studentRegistration.currentAddress);
		String actualStateAndCity = thanksForSubmittingPage.getActualText("State and City");
		String givenStateAndCity = studentRegistration.state + " " + studentRegistration.city;
		assertEquals(actualStateAndCity, givenStateAndCity);
	}
	
	@Test
	public void TC02() {
		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
		practiceFormPage.submitForm();
//		//Fail case
//		Thread.sleep(100);
//		pass case
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement txtFirstNameBorder = testBase.webDriver.findElement(By.id("firstName"));
		String firstNameBorder = txtFirstNameBorder.getCssValue("border-top-color");
		System.out.println(firstNameBorder);
		Assert.assertTrue(firstNameBorder.contains("220, 53, 69"));
	}
	
	@DataProvider(name = "PracticeForm_TC01")
	public String[][] readDataForForm() {
		String[][] data = null;
		Utils utils = new Utils();
		data = utils.readDataFromCSV("PracticeForm_TC01.csv");
		return data;
	}
	
	@DataProvider(name = "PracticeForm_TC01_1")
	public StudentRegistration[] readDataForFormUsingObject() {
		String[][] data = null;
		Utils utils = new Utils();
		data = utils.readDataFromCSV("PracticeForm_TC01.csv");
		StudentRegistration studentRegistration = new StudentRegistration();
		studentRegistration.firstName = data[0][0];
		studentRegistration.lastName = data[0][1];
		studentRegistration.email = data[0][2];
		studentRegistration.gender = data[0][3];
		studentRegistration.mobileNumber = data[0][4];
		studentRegistration.dateOfBirth = data[0][5];
		studentRegistration.subject = data[0][6];
		studentRegistration.hobbies = data[0][7];
		studentRegistration.picture = data[0][8];
		studentRegistration.currentAddress = data[0][9];
		studentRegistration.state = data[0][10];
		studentRegistration.city = data[0][11];
		StudentRegistration[] studentRegistrations = new StudentRegistration[1];
		studentRegistrations[0] = studentRegistration;
		return studentRegistrations;
	}
}
