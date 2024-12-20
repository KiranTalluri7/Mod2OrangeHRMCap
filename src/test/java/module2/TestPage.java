package module2;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {
	WebDriver driver;
	LoginPage loginpage;
	AdminPage adminpage;
	@BeforeClass
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginpage= new LoginPage(driver);
        adminpage = new AdminPage(driver);
        loginpage.login("Admin", "admin123");
        
	}
	
  @Test(priority=1)
  public void testMenuOptionsCount() {
	  adminpage.CountingSidePanel();
	  adminpage.navigateToAdminPage();
  }
  @Test(priority=2)
  public void testSearchByUsername() throws InterruptedException {
	  adminpage.SearchByUsername("Admin");
	  adminpage.RefreshPage();
  }
  
  @Test(priority=3)
  public void testSearchByUserRole() throws AWTException {
	  adminpage.SearchByUserRole();
	  adminpage.RefreshPage();

  }
  @Test(priority=4)
  public void testSearcgByUserStatus() throws AWTException {
	  adminpage.SearchByUserStatus();
	  adminpage.RefreshPage();
  }
  
  @AfterClass 
  public void close() {
	  driver.quit();
  }


  
}


   