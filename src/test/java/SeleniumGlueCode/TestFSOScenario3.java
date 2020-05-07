package SeleniumGlueCode;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestFSOScenario3 
{
	public WebDriver driver;
	
	@Given("^User is on loginpage and navigates to SignIn Page$")
	public void user_is_on_loginpage_and_navigates_to_SignIn_Page() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\Downloads\\Selenium\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://fieldseekeroffice.aspcore.net/Default.aspx");
	    System.out.println("Browser launch Successfully");
	    
	     String parentWindowHandle = driver.getWindowHandle();
		 System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement loginElement = driver.findElement(By.xpath("//button[@id='sign-in']")); 
		 for(int i = 0; i < 1; i++)
		 {
			 loginElement.click();
		 }
		 Set<String> allWindowHandles = driver.getWindowHandles();
		 for(String handle : allWindowHandles)
		 {
			 System.out.println("Switching to window - > " + handle);	 
			 driver.switchTo().window(handle); 
		 }
		
		 driver.findElement(By.xpath("//input[@id='user_username']")).sendKeys("FSAdministrator");
		 driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("FSA@2018");
		 driver.findElement(By.xpath("//button[@id='signIn']")).click();
		 
		 driver.switchTo().window(parentWindowHandle);

	}

	@When("^User is navigates to GatewaySync and select Trap Location$")
	public void user_is_navigates_to_GatewaySync_and_select_Trap_Location() throws Throwable 
	{
		  Thread.sleep(10000);
		
		  //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("(//div[@class='toolsBox'])[10]")).click();
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^verify that Trap location table headers$")
	public void verify_that_Trap_location_table_headers() throws Throwable 
	{
		List<WebElement> table=driver.findElements(By.xpath("//table[@id='GatewaySyncTable']/tbody//tr[@role='row']"));
		int tablesize=table.size();
		System.out.println("Total shows no. of entries is : " + tablesize);
		 
		Thread.sleep(3000);
		 
		String entries=   driver.findElement(By.xpath("//div[@id='GatewaySyncTable_info']")).getText();

		Assert.assertEquals(entries, "Showing 1 to 10 of 257 entries");
		
		System.out.println(entries);
		
		System.out.println("Verify below Table Headers");
		
		String selectall = driver.findElement(By.xpath("(//th[@class='sorting_disabled'])[1]")).getText();
		Assert.assertEquals(selectall, "Select All");
		System.out.println(selectall);
		
		String SyncStatus = driver.findElement(By.xpath("(//th[@class='sorting_asc'])[1]")).getText();
		Assert.assertEquals(SyncStatus, "Sync Status");
		System.out.println(SyncStatus);
		  	
		String sitecode = driver.findElement(By.xpath("(//th[@class='sorting'])[1]")).getText();
		Assert.assertEquals(sitecode, "Site Code");
		System.out.println(sitecode);
		
		String sitename = driver.findElement(By.xpath("(//th[@class='sorting'])[2]")).getText();
		Assert.assertEquals(sitename, "Site Name");
		System.out.println(sitename);
		
		String addres = driver.findElement(By.xpath("(//th[@class='sorting'])[3]")).getText();
		Assert.assertEquals(addres, "Address");
		System.out.println(addres);
		
		String zone = driver.findElement(By.xpath("(//th[@class='sorting'])[4]")).getText();
		Assert.assertEquals(zone, "Zone");
		System.out.println(zone);
		
		String status = driver.findElement(By.xpath("(//th[@class='sorting'])[5]")).getText();
		Assert.assertEquals(status, "Status");
		System.out.println(status);
		
		String edit = driver.findElement(By.xpath("(//th[@rowspan='1'])[8]")).getText();
		Assert.assertEquals(edit, "Edit");
		System.out.println(edit);
	}
}