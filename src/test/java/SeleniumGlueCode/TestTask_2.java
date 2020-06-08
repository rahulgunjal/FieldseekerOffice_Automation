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

public class TestTask_2 
{
	public WebDriver driver;
	
	@Given("^User Login to the application and Navigate to configuration tab and Verify the complete page$")
	public void user_Login_to_the_application_and_Navigate_to_configuration_tab_and_Verify_the_complete_page() throws Throwable 
	{
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\Downloads\\Selenium\\chrome driver for 83v\\chromedriver.exe");
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
		 
		 Thread.sleep(5000);
		 
		System.out.println("Navigate to configuration tab");
		driver.findElement(By.xpath("//span[contains(.,'Configuration')]")).click();
		System.out.println("Click on / Navigate to configuration tab and Page open successfully...");
		
		Thread.sleep(10000);
		
		String contab = driver.findElement(By.xpath("//h2[@class='pd-title']")).getText();
		Assert.assertEquals(contab, "Configuration Tools");
		System.out.println("Verify Configuration Tools are : " + contab);
		
		String fieldSeekerconfig = driver.findElement(By.xpath("//a[@href='#tab1FieldSeekerConfig']")).getText();
		Assert.assertEquals(fieldSeekerconfig, "FieldSeeker Config");
		System.out.println("Verify FieldSeeker Config tab : " + fieldSeekerconfig);
				
		String mosquspeci = driver.findElement(By.xpath("//a[@href='#tab2MosquitoSpecies']")).getText();
		Assert.assertEquals(mosquspeci, "Mosquito Species");
		System.out.println("Verify  Mosquito Species tab : " + mosquspeci);
		
		String product = driver.findElement(By.xpath("//a[@href='#tab3Product']")).getText();
		Assert.assertEquals(product, "Product");
		System.out.println("Verify  Product tab : " + product);
		
		String technician = driver.findElement(By.xpath("//a[@href='#tab4Technician']")).getText();
		Assert.assertEquals(technician, "Technician");
		System.out.println("Verify  Technician tab : " + technician);
		
		String gatewaysync = driver.findElement(By.xpath("//a[@href='#tab5GatewaySync']")).getText();
		Assert.assertEquals(gatewaysync, "Gateway Sync");
		System.out.println("Verify  Gateway Sync tab : " + gatewaysync);
		
		String traptypemapping = driver.findElement(By.xpath("//a[@href='#tab6TrapTypeMapping']")).getText();
		Assert.assertEquals(traptypemapping, "Trap Type Mapping");
		System.out.println("Verify  Trap Type Mapping tab : " + traptypemapping);
		
		System.out.println("Verify the complete Configuration Tab Page Successfully...");
	}

	@When("^User Verify Fieldseeker config tab and the data stored in tables$")
	public void user_Verify_Fieldseeker_config_tab_and_the_data_stored_in_tables() throws Throwable
	{
		System.out.println("To Verify the Fieldseeker config tab and the data stored in tables");
		
		List<WebElement> table=driver.findElements(By.xpath("(//td[@class='sorting_1'])[10]"));
		  int tablesize=table.size();
		  System.out.println("Total shows no. of entries is : " + tablesize);
		 
		  Thread.sleep(3000);
		  
		String entries=   driver.findElement(By.xpath("//div[@id='ConfigToolsTable_info']")).getText();

		Assert.assertEquals(entries, "Showing 1 to 10 of 15 entries");
		
		System.out.println(" To verify the data tables Entries:" + entries);
	}

	@Then("^User Verify Fieldseeker config tab edit functionality$")
	public void user_Verify_Fieldseeker_config_tab_edit_functionality() throws Throwable
	{
	    driver.findElement(By.xpath("(//i[@class='fa fa-edit'])[1]")).click();
	    
	    Thread.sleep(2000);
	    
	    String edit = driver.findElement(By.xpath("(//h4[@class='modal-title'])[1]")).getText();
	    Assert.assertEquals(edit, "Edit FieldSeeker Configuration");
	    System.out.println("To verify Edit Functionality:" + edit);
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();	
	}
}