package Locators;

public class LoginLocators {

	/* Home Page - HP */

	public static String HP_BankingType_Login_Dropdown = "//li[contains(@class,'product-personal-login')]/a/span[@class='pl-login-box']";

	public static String HP_PersonalBankingType_Login_Dropdown = "//li[contains(@class,'product-personal-login')]/a/following::nav//a[contains(text(),'Personal Banking')]";

	public static String HP_Banking_Login_BTN = "//li[contains(@class,'product-personal-login-new')]/a/span[@class='pl-login-ornage-box']";

	public static String LoginIntermediatePage_Continue_BTN = "//div[@class='primier_banners desktop-only clearfix']//a[contains(text(),'Continue to Login')]";
	
	/* Pop Up */
	
	public static String HP_PopUp = "//div[@class='push-popup desktop-only']//div[@id='push-modal-content']";
	
	public static String HP_PopUp_Close = "//div[@class='push-popup desktop-only']//div[@id='push-modal-content']/div[@id='push-modal-close']";
	
	/* Login Page */
	
	public static String LP_Username_TextBox = "//input[@title='User Id']";
	
	public static String LP_Password_TextBox = "//input[@title='Password']";
	
	public static String LP_Log_In_BTN = "//input[@title='Log In']";
	
	/*Logged-In Page */
	
	public static String UserName_Field = "//p[@id='LoginName']";
	
	public static String AccountBalance_Field = "//span[@class='widget-currency-integer']";
	
	public static String AccountNumber_Field = "//select[contains(@name,'AccountSummaryFG.SEL_ACC_NUM')]/following::div/div[@class='selectedTxt']";
	
	public static String Logout_BTN = "//a[@title='Log Out']";
	
	public static String PaymentNtransfer = "//li[@id='PAYMENTS__TRANSFER']";
	
	public static String Manage_Payees = "//li[@id='PAYMENTS__TRANSFER']//a[@id='Manage-Payees']";
	
	public static String View_Registered_Payee = "//input[@id='VIEW_REGISTERED_PAYEE']";
	
	public static String Add_New_Payee = "//input[@id='ADD_ICICI_BANK_PAYEE']";
	
	public static String Home_Bank_Payee = "//input[@title='Home Bank Payee List']";
	
	public static String Continue_BTN = "//input[@id='CONTINUE_PAYEE_LIST']";
	
	public static String PayeeList = "//table[@id='HostCounterPartyListing']//tr//td//span[contains(@id,'HREF_CounterPartyListFG.PAYEE_NAME_CUSTOM')]";
	
	public static String newPayeeName = "//input[contains(@name,'CounterPartyCRUDFG.BNF_NAME')]";
	
	public static String newPayeeNickName = "//input[contains(@name,'CounterPartyCRUDFG.BNF_NICK_NAME')]";
	
	public static String newPayeeAcctNo = "//input[contains(@name,'CounterPartyCRUDFG.BNF_ACCT_NUMBER')]";
	
	public static String newPayeeAcctNoConfirm = "//input[contains(@name,'CounterPartyCRUDFG.RE_ACCOUNT_NUMBER')]";
	
	public static String submit_BTN ="//input[contains(@id,'CONTINUE') and contains(@value,'NEXT')]";
	
	
}