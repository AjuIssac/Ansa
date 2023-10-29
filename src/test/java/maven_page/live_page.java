package maven_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class live_page {
	WebDriver driver;
	By logo=By.xpath("/html/body/header/div/a/img");
	By resumes=By.xpath("/html/body/header/div/div[2]/nav/ul/li[5]/a");
	By builder=By.xpath("/html/body/header/div/div[2]/nav/ul/li[5]/ul/li[1]/a");
	By workhere=By.xpath("//*[@id=\"accordion-11\"]/li[1]/a");
	By review=By.xpath("//*[@id=\"lcresumereview\"]");
	By upload=By.xpath("//*[@id=\"blade-0\"]/div[2]/div/div[1]/div/label");
	By signin=By.xpath("//*[@id=\"lclogin\"]/button/span");
	By emailaddress=By.xpath("//*[@id=\"widget-user-email\"]");
	By password=By.xpath("//*[@id=\"widget-user-password\"]");
	By sign=By.xpath("//*[@id=\"btnSignIn\"]");
	
	
	public live_page(WebDriver driver)
	{
	  this.driver=driver;	
	}
	
	public void titleverification() {
		String title=driver.getTitle();
		String t="live career";
		if(title.equals(t)) {
			System.out.println("title same");
		}
		else {
			System.out.println("title diff");
		}
	}
	
	public void contentverification() {
		String  cont=driver.getPageSource();
		if(cont.contains("Live career")) {
			System.out.println("contains");
			
		}
		else {
			System.out.println("not contains");
		}
	}
	
	public void logodisplay() {
		WebElement li=driver.findElement(logo);
		boolean b=li.isDisplayed();
		if(b) {
			System.out.println("logo displayed");
			
		}
		else {
			System.out.println("logo not displayed");
		}
	}
	
	public void screenshot() throws IOException {
		File f=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
		FileHandler.copy(f,new File("./Screenshot/livecareer.png"));
	}
	
	public void mousehover() {
		Actions act=new Actions(driver);
		WebElement ai=driver.findElement(resumes);
		act.moveToElement(ai);
		act.perform();
		driver.findElement(builder).click();
	
		
	}
	
	public void scroll()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		driver.navigate().back();
	}
	
	public void windowhandle() {

		String parentwindow=driver.getWindowHandle();
		driver.findElement(workhere).click();
		
		Set <String> childwindow=driver.getWindowHandles();
		
		for(String handle:childwindow) {
			System.out.println(handle);
			if(!handle.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handle);
				
				driver.close();
			}
			
			driver.switchTo().window(parentwindow);
		}
		
		
		
	}
	
       public void test() throws AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         Actions a=new Actions(driver);
   		WebElement aii=driver.findElement(resumes);
   		a.moveToElement(aii);
   		a.perform();
   		driver.findElement(review).click();
   		driver.findElement(upload).click();
   		
		String p="C:\\Users\\HP\\Downloads\\Ansa-cv.pdf";
		fileUpload(p);
		
	}
	
	public void fileUpload(String p) throws AWTException {
		//to copy path to clipboard
		StringSelection str=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		//to paste to systemwindow
		Robot robot=new Robot();
		
		robot.delay(3000);
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent
				.VK_ENTER);
		
		
		
	
	
}
	
	
	public void datadriven() throws Exception {
		driver.findElement(signin).click();
		try {
		File f=new File("C:\\Users\\HP\\OneDrive\\Desktop\\LUMINAR\\datadriven.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
			String username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("üsername" +username);
			String pswd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password" +pswd);
			
			//driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(emailaddress).sendKeys(username);
			//driver.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(password).sendKeys(pswd);
			
			driver.findElement(sign).click();
	
		}
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
	
	
	
	
	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
