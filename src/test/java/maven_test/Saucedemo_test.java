package maven_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_page.Saucedemo_page;

public class Saucedemo_test {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	
	public void url() {
		
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test
	public void test() {
		
		Saucedemo_page ob=new Saucedemo_page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.loginpage("standard_user","secret_sauce");
		ob.productpage();
		ob.cart();
		ob.checkout("Ajay", "issac", "45667");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.home();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ob.logou();
		
		
		
	}
}
