package maven_test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_page.Aneeta;




public class Aneeta_test {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
	}
	@BeforeMethod
	public void url() {
		driver.get("https://aom.org/");
	}
	@Test
	public void test() throws Exception  {
		Aneeta pg=new Aneeta(driver);
		driver.manage().window().maximize();
		pg.contentverification();
		pg.titleverification();
		pg.logodisplay();
		
		pg.mousehover();
		//pg.scrolldown();
		//pg.windowhandle();
		//pg.screenshot();
		pg.click();
		pg.main();
		pg.fileuploadd();
	

		}

}
