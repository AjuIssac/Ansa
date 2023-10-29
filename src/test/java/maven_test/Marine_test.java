package maven_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_page.Marine_page;

public class Marine_test {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	
	public void url() {
		driver.get("https://marinersforex.com/Flights-Booking");
	}
	
	@Test
	public void test() {
		
		Marine_page ob=new Marine_page(driver);
		driver.manage().window().maximize();
		ob.leavinggoing();
		ob.departing();
		ob.travellerss();
		ob.searchhh();
		
	}

}
