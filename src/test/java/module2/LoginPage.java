package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	//Locators
	By usernameField =By.name("username");
	By passwordField=By.name("password");
	By loginButton=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void login (String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	

}


