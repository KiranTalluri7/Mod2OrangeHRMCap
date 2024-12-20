package module2;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPagewithExtentReport {
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
      System.out.println("Test for Menu Options Count");

	  adminpage.CountingSidePanel();
	  adminpage.navigateToAdminPage();
  }
  @Test(priority=2)
  public void testSearchByUsername() throws InterruptedException {
      System.out.println("Test for Search by Username");

	  adminpage.SearchByUsername("Admin");
	  adminpage.RefreshPage();
  }
  
  @Test(priority=3)
  public void testSearchByUserRole() throws AWTException {
      System.out.println("Test for Search by User Role");

	  adminpage.SearchByUserRole();
	  adminpage.RefreshPage();

  }
  @Test(priority=4)
  public void testSearcgByUserStatus() throws AWTException {
      System.out.println("Test for Search by User Status");

	  adminpage.SearchByUserStatus();
	  adminpage.RefreshPage();
  }
  
  @AfterClass 
  public void close() {
	  driver.quit();
  }


  
}


   