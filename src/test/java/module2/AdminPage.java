package module2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	WebDriver driver;
	
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void navigateToAdminPage() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();

	}
	public void CountingSidePanel() {
		List<WebElement> menuOptions = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li"));
        System.out.println("Total menu options: " + menuOptions.size());
    
	}
	public void SearchByUsername(String username) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
		Thread.sleep(3000);
		System.out.println("Number of Records in Username : "+driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]")).getText());
	}
	
	public void SearchByUserRole() throws AWTException {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();		
	     Robot rbt = new Robot();
	     
	     rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyPress(KeyEvent.VK_ENTER);
			
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();//seacrh click
			//counting number of records
			System.out.println("Numer of records in Userrole :" +driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]")).getText());
			 
	}
	public void SearchByUserStatus() throws AWTException {
	     Robot rbt = new Robot();

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		 rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyPress(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();//seacrh click
System.out.println("Numer of records in Userstatus :"+driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]")).getText());
		
	}
	public void RefreshPage() {
        driver.navigate().refresh();

	}

}



