package maven_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Saucedemo_page {
	WebDriver driver;
	
	By username=By.xpath("//*[@id=\"user-name\"]");
	By password=By.xpath("//*[@id=\"password\"]");
	By login=By.xpath("//*[@id=\"login-button\"]");
	By item=By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
	By item2=By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
	By item3=By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
	By item4=By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
	By item5=By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
	By item6=By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]");
	By cart=By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By checkout=By.xpath("//*[@id=\"checkout\"]");
	By firstname=By.xpath("//*[@id=\"first-name\"]");
	By lastname=By.xpath("//*[@id=\"last-name\"]");
	By postalcode=By.xpath("//*[@id=\"postal-code\"]");
	By continu=By.xpath("//*[@id=\"continue\"]");
	By menu=By.xpath("//*[@id=\"react-burger-menu-btn\"]");
	By logout=By.xpath("//*[@id=\"logout_sidebar_link\"]");
	
	
	
	public Saucedemo_page(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void loginpage(String uname,String pwd) {
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
	}
	
	public void productpage() {
		driver.findElement(item).click();
		driver.findElement(item2).click();
		driver.findElement(item3).click();
		driver.findElement(item4).click();
		driver.findElement(item5).click();
		driver.findElement(item6).click();
		
		
		
	}
	
	public void cart() {
		driver.findElement(cart).click();
	}
	
	
	public void checkout(String name,String lname,String code) {
		driver.findElement(checkout).click();
		driver.findElement(firstname).sendKeys(name);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(postalcode).sendKeys(code);
		driver.findElement(continu).click();
		
	}
	
	public void home() {
		
		driver.navigate().back();
		driver.findElement(menu).click();
		
		
	}
	public void logou() {
		driver.findElement(logout).click();
	}
	
	
	
	
	

}
