package Validators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Library.SeleniumLibrary;
import Locators.LoginLocators;

public class Validator {
	
	LoginLocators locator = new LoginLocators();
	
	public boolean checkAllElements(SeleniumLibrary seleniumLib,String accountNumber, 
			String locator1, String balance, String locator2, String userName, String locator3) {
		
		WebDriver driver = seleniumLib.driver;
		if(!((driver.findElement(By.xpath(locator3)).getText()).equals(userName))) {
			return false;
		}
		if(!((driver.findElement(By.xpath(locator2)).getText()).contains(balance))) {
			return false;
		}
		if(!((driver.findElement(By.xpath(locator1)).getText())).contains(accountNumber)) {
			return false;
		}
		return true;
	}
	
	public boolean checkPayee(SeleniumLibrary seleniumLib,String [] payees, String locator) {
		List<String> actualPayeeList = new ArrayList<String>();
		WebDriver driver = seleniumLib.driver;
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		for(WebElement element : elements) {
			actualPayeeList.add(element.getText());
		}
		if(actualPayeeList.size()==payees.length) {
			for(String name : payees) {
				if(actualPayeeList.contains(name)) {
					continue;
				}
				else
					return false;
			}
		}
		else
			return false;
		return true;
	}
}
