package com.Allocator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Allocator {

	protected static WebDriver driver;
	Properties p = new Properties();

	// Initialization
	public void loadPropertiesFile() throws IOException {
		File f = new File(
				System.getProperty("user.dir") + "//src//main//java//com//Utilities//GlobalSettings.properties");
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
	}

	// Method to select browser
	public WebDriver selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//main//resources//libs//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else
			return null;
	}

	// Method to open browser and navigate to corresponding URL
	public void init() throws IOException {
		loadPropertiesFile();
		selectBrowser(p.getProperty("browser"));
		driver.get(p.getProperty("URL"));
	}

	// Method to close browser
	public void closeBrowser() {
		driver.close();
	}

}
