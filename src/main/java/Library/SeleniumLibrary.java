package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Locators.LoginLocators;

public class SeleniumLibrary {

	LoginLocators locator = new LoginLocators();

	public static WebDriver driver;

	public void createDriver(String browserName) {
		System.out.println("This is awesome");
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\java\\resource\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "src\\test\\java\\resource\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "src\\test\\java\\resource\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src\\test\\java\\resource\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public void openPage(String url) throws CustomExceptions, InterruptedException {
		driver.get(url);
		Thread.sleep(10);
		try {
			if (driver.findElement(By.xpath(locator.HP_PopUp)).isDisplayed()) {
				closePopUp(locator.HP_PopUp, locator.HP_PopUp_Close);
			}
		} catch (Exception e) {
		}
	}

	public void closePopUp(String popUpLocator, String closeLocator) throws CustomExceptions {
		driver.findElement(By.xpath(closeLocator)).click();
		if (driver.findElement(By.xpath(locator.HP_PopUp)).isDisplayed()) {
			throw new CustomExceptions("PopUp in home page is not closed.");
		}
	}

	public void driverWaitSeconds(long secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}

	public void selectOptioninDropdownMO(String locator1, String locator2, String option) throws CustomExceptions {
		if ((driver.findElement(By.xpath(locator1)).getText()).equals(option)) {
		} else {
			WebElement element = driver.findElement(By.xpath(locator1));
			Actions action = new Actions(driver);
			action.moveToElement(element);
			driver.findElement(By.xpath(locator2)).click();
			if ((driver.findElement(By.xpath(locator1)).getText()).equals(option)) {
			} else {
				throw new CustomExceptions("Option not present in the Drop down");
			}
		}
	}

	public void MOnSelect(String locator1, String locator2) {
		WebElement element = driver.findElement(By.xpath(locator1));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath(locator2)).click();
	}

	public void clickBTNtoNextPage(String locator, String pageTitle) throws CustomExceptions, InterruptedException {
		driver.findElement(By.xpath(locator)).click();
		Thread.sleep(1000);
		if ((driver.getTitle()).equals(pageTitle)) {
		} else {
			throw new CustomExceptions("Page title does not match.");
		}
	}

	public void clickRadioBTN(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	public void enterText(String locator, String text) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void quitDriver() {
		driver.quit();
	}
}