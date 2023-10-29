package maven_page;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Naukri_page {
	WebDriver driver;
	By register=By.xpath("//*[@id=\"register_Layer\"]");
	By logo=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/a/img");
	By jobs=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/nav/ul/li[1]/a/div");
	By fresherjob=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/nav/ul/li[1]/div/ul[2]/li[2]/a/div");
	By softwarehandle=By.xpath("//*[@id=\"trending-naukri-wdgt\"]/div/div[1]/a[3]");
	By checkbox=By.xpath("//*[@id=\"search-result-container\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[4]/label/i");
	
	
	public Naukri_page(WebDriver driver) {
		this.driver=driver;
	}
	
	public void titleverification() {
		String title=driver.getTitle();
		String t="naukri";
		if(title.equals(t)) {
			System.out.println("title same");
		}
		else {
			System.out.println("title diff");
		}
	}
	
	public void contentverification() {
		String  cont=driver.getPageSource();
		if(cont.contains("naukri")) {
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
		FileHandler.copy(f,new File("./Screenshot/naukri.png"));
	}
	
	
	public void mousehover() {
		Actions act=new Actions(driver);
		WebElement ai=driver.findElement(jobs);
		act.moveToElement(ai);
		act.perform();
		driver.findElement(fresherjob).click();
		
	}
	
	public void handlewindow() {
		String parentwindow=driver.getWindowHandle();
		driver.findElement(softwarehandle).click();
		
		Set <String> childwindow=driver.getWindowHandles();
		for(String handle:childwindow) {
			if(!handle.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handle);
				WebElement bi=driver.findElement(checkbox);
				boolean c=bi.isEnabled();
				if(c) {
					System.out.println("checkbox enable");
				}
				else {
					System.out.println("not checked");
				}
				driver.close();
				
			}
			driver.switchTo().window(parentwindow);
			
			
		}
		
	}
	
	
	

}


