package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.PracticeFormPage;
import pages.ThanksForSubmittingPage;

public class PracticeFormTest extends TestCase {
	@Test(dataProvider = "PracticeForm_TC01")
	public void submitDataSuccessfully_DataProvider(String firstName, String lastName, String email, String gender,
			String mobileNumber, String dateOfBirth,
			String subject, String hobbies, String picture, String currentAddress,
			String state, String city) {
		String picturePath = System.getProperty("user.dir") + "\\testcase\\TestData\\"+ picture;
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

		ThanksForSubmittingPage thanksForSubmittingPage = practiceFormPage.inputData(firstName, lastName, email, gender,
				mobileNumber, dateOfBirth, subject, hobbies, picturePath, currentAddress, state, city);
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

	@DataProvider(name = "PracticeForm_TC01")
	public String[][] readDataForForm() {
		String[][] data = null;
		Utils utils = new Utils();
		data = utils.readDataFromCSV("PracticeForm_TC01.csv");
		return data;
	}
}
