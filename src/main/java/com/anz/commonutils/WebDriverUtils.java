package com.anz.commonutils;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {

	public static WebDriver driver;
	

	/*
	 * Initializing WebDriver based on the browser provided
	 */
	public static WebDriver launchBrowser() throws IOException {
		FileReader reader = new FileReader("src/main/resources/common.properties");
		Properties prop = new Properties();
		prop.load(reader);

		switch (prop.getProperty("browser").toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		System.out.println(prop.getProperty("browser").toUpperCase() + " driver is initialized and ready");
		return driver;
	}
	
	public static void launchUrl() throws IOException {
		FileReader reader = new FileReader("src/main/resources/common.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String url=prop.getProperty("url");
		if (driver != null) {
			driver.get(url);
			System.out.print("Opening URL: " + url);
		} else
			System.err.println("WebDriver is null, so cannot open the URL: " + url);
		
	}
	
	

	/*
	 * To wait until element is displayed
	 */
	public static void waitToDisplayElement(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void implicitlyWait(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
	}

}
