package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardTest {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser){
//	public void setup(){
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
	}
	
	@Test(priority =1)
	public void registrationTest(){
		boolean flag = false;
		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		flag = driver.findElement(By.id("fullName")).isDisplayed();
		Assert.assertTrue(flag, "Registartion page is not displayed.");
	}

	@Test(priority = 2)
	public void demoTableTest(){
		boolean flag = false;
		driver.findElement(By.id("demotable-11")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		flag = driver.findElement(By.id("empmanager")).isDisplayed();
		Assert.assertTrue(flag, "DemoTable page is not displayed.");
	}
	
	@Test(priority = 3)
	public void basicElementTest(){
		boolean flag = false;
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		flag = driver.findElement(By.id("UserFirstName")).isDisplayed();
		Assert.assertTrue(flag, "BasicElement page is not displayed.");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

