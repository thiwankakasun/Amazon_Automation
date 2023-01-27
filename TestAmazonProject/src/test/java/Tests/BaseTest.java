package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import PageObjects.AmazonHomePage;

public class BaseTest {
	
	private WebDriver driver;
	protected AmazonHomePage amazonHomePage;
	
	@BeforeClass
	public void setUp() {
				
		//Open Google Chrome
		System.setProperty("webdriver.chrome.driver", "src/test/java/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		//1. Navigate to Amazon
		File file = new File("C:\\Users\\ukasuth\\Downloads\\eclipse amazon workspace\\TestAmazonProject\\TestData\\TestData.properties");
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		
		amazonHomePage = new AmazonHomePage(driver);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
