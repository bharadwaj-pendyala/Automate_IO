package com.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.ExcelReader;

public class Automate_IO_HomePage {

	WebDriver driver;

	public Automate_IO_HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public By name = By.xpath("//*[@id='name']");
	public By workEmail = By.xpath("//*[@id='email']");
	public By password = By.xpath("//*[@id='password']");
	public By newsletterCheckbox = By.xpath("//*[@class='ng-untouched ng-pristine ng-valid']");
	public By registerBtn = By.xpath("//*[@type='submit']");
	public By loginTab = By.xpath("//*[@href='/app/login']");

	public By activeCampaign = By.xpath("//*[text()='Active Campaign']");
	public By asana = By.xpath("//*[text()='Asana']");
	public By baseCamp2 = By.xpath("//*[text()='Basecamp 2']");
	public By buffer = By.xpath("//*[text()='Buffer']");
	public By calendly = By.xpath("//*[text()='Calendly']");

	public By imDone = By.cssSelector(".btn span");

	public By welcomeMessage = By.cssSelector("h2.text-center.title");

	public By recommendedBots = By.xpath("//*[text()='Recommended Bots']");

	public void register() {

		ExcelReader er = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Utilities\\TestData.xlsx");

		String nameforReg = er.getCellData("Data", "Name", 2);
		String emailforReg = er.getCellData("Data", "WorkEmail", 2);
		String passwordforReg = er.getCellData("Data", "Password", 2);

		driver.findElement(name).sendKeys(nameforReg);
		driver.findElement(workEmail).sendKeys(emailforReg);
		driver.findElement(password).sendKeys(passwordforReg);
		driver.findElement(newsletterCheckbox).click();
		driver.findElement(registerBtn).submit();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		chooseApps();
	}

	public void chooseApps() {
		driver.findElement(activeCampaign).click();
		driver.findElement(asana).click();
		driver.findElement(baseCamp2).click();
		driver.findElement(buffer).click();
		driver.findElement(calendly).click();
		driver.findElement(imDone).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(welcomeMessage).isDisplayed();
	}

	public void login() {
		ExcelReader er = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Utilities\\TestData.xlsx");

		String loginId = er.getCellData("LoginData", "WorkEmail", 2);
		String passwordforLogin = er.getCellData("LoginData", "Password", 2);

		driver.findElement(loginTab).click();
		driver.findElement(workEmail).sendKeys(loginId);
		driver.findElement(password).sendKeys(passwordforLogin);
		driver.findElement(registerBtn).submit();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(recommendedBots).isDisplayed();

	}

}
