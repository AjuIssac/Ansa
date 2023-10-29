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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aneeta {
	WebDriver driver;

	By logo=By.xpath("//header/div[1]/div[1]/div[1]/a[1]");
	By login=By.xpath("//*[@id=\"header-dropdown\"]");
	By logins=By.xpath("//*[@id=\"header-dropdown\"]");
	By Signin=By.xpath("/html/body/header/div/div/div[2]/div[2]/div/a[1]");
	By username=By.xpath("//input[@id='ctl00_cphBody_LoginPageLogin_imisLogin_UserName']");

	By psswrd=By.xpath("//input[@id='ctl00_cphBody_LoginPageLogin_imisLogin_Password']");
	By enter=By.xpath("//input[@id='ctl00_cphBody_LoginPageLogin_imisLogin_LoginButton']");
	By member=By.xpath("/html/body/header/div/div/div[2]/div[1]/nav/ul/li[2]");
	By youtube=By.xpath("//*[@id=\"footer_T5F608759033_Col00\"]/div/div/ul/li[4]");
	By home=By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item/yt-formatted-string");
	By profile=By.xpath("/html/body/header/div/div/div[2]/div[2]/div/a[1]");
	By edit=By.xpath("//*[@id=\"ctl01_TemplateBody_WebPartManager1_gwpciNewContactMiniProfileCommon_ciNewContactMiniProfileCommon_contactPicture_ctl000\"]");
	By select=By.xpath("//*[@id=\"ctl01_TemplateBody_WebPartManager1_gwpciNewContactMiniProfileCommon_ciNewContactMiniProfileCommon_contactPicture_AsyncUpload1row0\"]/span/input[2]");
	By join=By.linkText("AWARDS AND RECOGNITION");

	By save=By.xpath("//*[@id=\"ctl01_TemplateBody_WebPartManager1_gwpciNewContactMiniProfileCommon_ciNewContactMiniProfileCommon_contactPicture_submit\"]");
	public Aneeta(WebDriver driver)
	{
		  this.driver=driver;
			}
			
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String expectedtitle="Academy of Management";
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}

	public void contentverification()
	{
		String contnt=driver.getPageSource();
		if(contnt.contains("Academy"))
				{
			System.out.println("this page contains the word Academy");
			
		}
		else
		{
			System.out.println("this page doesnot contains the word Academy");
		}
		
	}
	public void logodisplay()
	{
		WebElement pn=driver.findElement(logo);
				boolean bo=pn.isDisplayed();
		if(bo)
		{
			System.out.println("logo displayed");
		}
		else
		{
			System.out.println("logo is not displayed");
		}
	}	
	public void click() {
		driver.findElement(login).click();
		
		driver.findElement(Signin).click();
	}
			public void main() throws IOException
			{
			
			File f=new File("C:\\Users\\HP\\Downloads\\VALUES.xlsx");
			FileInputStream fi=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sh=wb.getSheet("Sheet1");
			System.out.println(sh.getLastRowNum());

			for(int i=1;i<=sh.getLastRowNum();i++)
			{
				String Username=sh.getRow(i).getCell(0).getStringCellValue();
				System.out.println(Username);
				String password=sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(password);
				
				driver.findElement(username).sendKeys(Username);
				driver.findElement(psswrd).sendKeys(password);			
				driver.findElement(enter).click();
				
				//driver.findElement(logins).click();
				//driver.findElement(profile).click();
				//driver.findElement(edit).click();
				//driver.findElement(select).click();
				

			}
		}
				//WebElement element = driver.findElement(By.id("ctl00_cphBody_LoginPageLogin_imisLogin_LoginButton"));
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				//element.click();
		/*		WebElement signInButton = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
		        signInButton.click();
		        WebElement usernameField = driver.findElement(By.xpath("//input[@id='ctl00_cphBody_LoginPageLogin_imisLogin_UserName']"));
		        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ctl00_cphBody_LoginPageLogin_imisLogin_Password']"));
		        String username = "aneeta";
		        String password = "catherin@aneeta";
		        usernameField.sendKeys(username);
		        passwordField.sendKeys(password);
		        WebElement signInButtonOnPage = driver.findElement(By.xpath("//input[@id='ctl00_cphBody_LoginPageLogin_imisLogin_LoginButton']"));
		        signInButtonOnPage.click();
				driver.findElement(login).click();

		        WebElement profileLink = driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div[2]/div/a[1]"));
		        /html/body/header/div/div/div[2]/div[2]/div/a[1]
		        profileLink.click();
		        WebElement Edit = driver.findElement(By.xpath("//*[@id=\"ctl01_TemplateBody_WebPartManager1_gwpciNewContactMiniProfileCommon_ciNewContactMiniProfileCommon_contactPicture__Head\"]/div"));
		        Edit.click();
		        
		        //WebElement fileUploadInput = driver.findElement(By.xpath("//*[@id=\"ctl01_TemplateBody_WebPartManager1_gwpciNewContactMiniProfileCommon_ciNewContactMiniProfileCommon_contactPicture_AsyncUpload1row0\"]/span/input[2]"));
		        //fileUploadInput.click();
		       // WebElement saveButton = driver.findElement(By.xpath("//button[@id='saveButton']"));
		       // saveButton.click();
			} */

			public void screenshot() throws Exception{
				File f=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
				FileHandler.copy(f, new File("./Screenshot/Management.png"));
			}
			
			public void mousehover() {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Actions act=new Actions(driver);
				WebElement w=driver.findElement(member);
				act.moveToElement(w);
				act.perform();
				driver.findElement(join).click();
				
			}
			public void scrolldown() 
				{
						
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,1500)", "");
				}
			
			public void windowhandle() {
				String parentwindow=driver.getWindowHandle();
				driver.findElement(youtube).click();
				Set<String> allwindowhandles = driver.getWindowHandles();
				for(String handle:allwindowhandles) {
					System.out.println(handle);
					
					if(!handle.equalsIgnoreCase(parentwindow)) {
						driver.switchTo().window(handle);
						System.out.println("package opened");
						driver.findElement(home).click();
					}
				}
				driver.switchTo().window(parentwindow);
			}
			public void fileuploadd() throws Exception {
				driver.findElement(logins).click();
				driver.findElement(profile).click();
				driver.findElement(edit).click();
				driver.findElement(select).click();
			
				//driver.findElement(edit).click();
				//driver.findElement(select).click();
				
				fileupload("C:\\Users\\HP\\Downloads\\Cat.jpg");
				
				
			}
			public void fileupload(String s) throws AWTException  {
				
				StringSelection strSelection=new StringSelection(s);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
				
				Robot robot=new Robot();
				robot.delay(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);;
				
				driver.findElement(save).click();
			}



}
