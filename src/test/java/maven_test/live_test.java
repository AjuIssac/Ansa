package maven_test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_page.live_page;

public class live_test {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	
	public void url() {
		driver.get("https://www.livecareer.com/");
	}
	
	@Test
	public void test() throws Exception {
		
		live_page ob=new live_page(driver);
		driver.manage().window().maximize();
		ob.titleverification();
		ob.contentverification();
		ob.logodisplay();
		ob.screenshot();
		ob.mousehover();
		ob.scroll();
		ob.windowhandle();
		ob.test();
		ob.datadriven();
		
	}

}
