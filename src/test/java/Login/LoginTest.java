package Login;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Library.CustomExceptions;
import Library.SeleniumLibrary;
import Locators.LoginLocators;
import Locators.WebPageData;
import Validators.Validator;

public class LoginTest {

	SeleniumLibrary seleniumLib = new SeleniumLibrary();
	LoginLocators locator = new LoginLocators();
	WebPageData pageData = new WebPageData();
	Validator validator = new Validator();
	Sheet currentSheet;
	Workbook wb;
	FileInputStream inputStream;

	@BeforeClass
	public void BeforeClass() {
		seleniumLib.createDriver("Chrome");
	}

	@BeforeTest
	public void beforeCondition() throws IOException {
		File file = new File("src\\test\\java\\testdata\\Assignment.xlsx");
		inputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(inputStream);
		currentSheet = wb.getSheet("UserDetails");
	}

	public void login(String username, String password) throws CustomExceptions, InterruptedException {
		seleniumLib.openPage("https://www.icicibank.com");
		seleniumLib.driverWaitSeconds(2);
		seleniumLib.selectOptioninDropdownMO(locator.HP_BankingType_Login_Dropdown,
				locator.HP_PersonalBankingType_Login_Dropdown, "Personal Banking");
		seleniumLib.clickBTNtoNextPage(locator.HP_Banking_Login_BTN, pageData.PB_Login_Page_Title);
		seleniumLib.clickBTNtoNextPage(locator.LoginIntermediatePage_Continue_BTN, pageData.Login_Page_Title);
		seleniumLib.enterText(locator.LP_Username_TextBox, username);
		seleniumLib.enterText(locator.LP_Password_TextBox, password);
		seleniumLib.clickBTNtoNextPage(locator.LP_Log_In_BTN, pageData.LoggedIn_Home_Page_Title);

	}

	@Test(enabled = true, priority = 1)
	public void LoginTestCase1() throws CustomExceptions, InterruptedException {
		boolean flag = false;
		int noOfRows = currentSheet.getLastRowNum();
		for (int i = 1; i <= noOfRows; i++) {
			Row row = currentSheet.getRow(i);
			String accountNumber = row.getCell(0).toString();
			String userName = row.getCell(1).toString();
			String userId = row.getCell(2).toString();
			String password = row.getCell(3).toString();
			String balance = row.getCell(4).toString();
			login(userId, password);
			flag = validator.checkAllElements(seleniumLib, accountNumber, locator.AccountNumber_Field, balance,
					locator.AccountBalance_Field, userName, locator.UserName_Field);
			seleniumLib.clickBTNtoNextPage(locator.Logout_BTN, pageData.FeedBackPage_Title);
			if (flag == false) {
				Assert.assertTrue(true == flag);
			}
		}
		Assert.assertTrue(true == flag);
	}

	@Test(enabled = true, priority = 2)
	public void LoginTestCase2() throws CustomExceptions, InterruptedException {
		boolean flag = false;
		int noOfRows = currentSheet.getLastRowNum();
		for (int i = 1; i <= noOfRows; i++) {
			Row row = currentSheet.getRow(i);
			String accountNumber = row.getCell(0).toString();
			String userName = row.getCell(1).toString();
			String userId = row.getCell(2).toString();
			String password = row.getCell(3).toString();
			String balance = row.getCell(4).toString();
			String payeeList = row.getCell(5).toString();
			String[] payees = payeeList.split(",");
			login(userId, password);
			seleniumLib.driverWaitSeconds(10);
			seleniumLib.MOnSelect(locator.PaymentNtransfer, locator.Manage_Payees);
			seleniumLib.clickBTNtoNextPage(locator.View_Registered_Payee, pageData.Registered_Payee_Title);
			seleniumLib.clickRadioBTN(locator.Home_Bank_Payee);
			seleniumLib.clickBTNtoNextPage(locator.Continue_BTN, pageData.ICICI_Bank_Payee_Title);
			flag = validator.checkPayee(seleniumLib, payees, locator.PayeeList);
			seleniumLib.clickBTNtoNextPage(locator.Logout_BTN, pageData.FeedBackPage_Title);
			if (flag == false) {
				Assert.assertTrue(true == flag);
			}
		}
		Assert.assertTrue(true == flag);
	}
	
// Scenario 3 is done till filling the data to add new payee, as dummy data is used it will not.
	@Test(enabled = true, priority = 3)
	public void LoginTestCase3() throws CustomExceptions, InterruptedException {
		int noOfRows = currentSheet.getLastRowNum();
		for (int i = 1; i <= noOfRows; i++) {
			Row row = currentSheet.getRow(i);
			String accountNumber = row.getCell(0).toString();
			String userName = row.getCell(1).toString();
			String userId = row.getCell(2).toString();
			String password = row.getCell(3).toString();
			String balance = row.getCell(4).toString();
			String newPayee = row.getCell(6).toString();
			String newPayeeAcctNo = row.getCell(7).toString();
			login(userId, password);
			seleniumLib.driverWaitSeconds(10);
			seleniumLib.MOnSelect(locator.PaymentNtransfer, locator.Manage_Payees);
			seleniumLib.clickBTNtoNextPage(locator.Add_New_Payee, pageData.Confirm_Payee_Page_Title);
			seleniumLib.enterText(locator.newPayeeName, newPayee);
			seleniumLib.enterText(locator.newPayeeNickName, newPayee);
			seleniumLib.enterText(locator.newPayeeAcctNo, newPayeeAcctNo);
			seleniumLib.enterText(locator.newPayeeAcctNoConfirm, newPayeeAcctNo);
		}
		Assert.assertTrue(true == true);
	}

	@AfterClass void afterTestMethod() {
		
		seleniumLib.quitDriver();
		}
}
