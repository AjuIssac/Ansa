package maven_test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_page.Naukri_page;

public class Naukri_test {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	
	public void url() {
		driver.get("https://www.naukri.com/");
	}
	
	@Test
	public void test() throws IOException {
		
		Naukri_page ob=new Naukri_page(driver);
		driver.manage().window().maximize();
		ob.titleverification();
		ob.contentverification();
		ob.logodisplay();
		ob.screenshot();
		ob.mousehover();
		driver.navigate().back();
		ob.handlewindow();
	}
	
	
	
	
	

}
