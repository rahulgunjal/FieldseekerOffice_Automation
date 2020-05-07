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


public class TestFSOScenario2 
{
	public WebDriver driver;
		
	@Given("^user is  on loginpage and navigates to SignIn Page$")
	public void user_is_on_loginpage_and_navigates_to_SignIn_Page() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\Downloads\\Selenium\\chromedriver.exe");
		
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
	
	@When("^user navigates to Configuration Tools then Select Mosquito species$")
	public void user_navigates_to_Configuration_Tools_then_Select_Mosquito_species() throws Throwable 
	{		
		driver.findElement(By.xpath("//*[@class='boxHead-content']//*[text()='Configuration']")).click();
		 
		  Thread.sleep(3000);
		 
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[text()='Mosquito Species']")).click();
		 
	/*	  List<WebElement> table=driver.findElements(By.xpath("//table[@id='MosquitoSpeciesTable']/tbody//tr[@role='row']"));
		  int tablesize=table.size();
		  System.out.println(tablesize);
		 
		  Thread.sleep(3000);
		 
		  //driver.findElement(By.xpath("//a[@id='MosquitoSpeciesTable_next']")).click();
		 
		 
		String entries=   driver.findElement(By.xpath("//div[@id='MosquitoSpeciesTable_info']")).getText();

		Assert.assertEquals(entries, "Showing 1 to 10 of 96 entries");
		
		System.out.println(entries);
	*/
	}

	@Then("^Calculate the number of enteries in table and Verify all the no of entries$")
	public void calculate_the_number_of_enteries_in_table_and_Verify_all_the_no_of_entries() throws Throwable
	{
		List<WebElement> table=driver.findElements(By.xpath("//table[@id='MosquitoSpeciesTable']/tbody//tr[@role='row']"));
		  int tablesize=table.size();
		  System.out.println("Total shows no. of entries is : " + tablesize);
		 
		  Thread.sleep(3000);
		 
		  //driver.findElement(By.xpath("//a[@id='MosquitoSpeciesTable_next']")).click();
		 
		String entries=   driver.findElement(By.xpath("//div[@id='MosquitoSpeciesTable_info']")).getText();

		Assert.assertEquals(entries, "Showing 1 to 10 of 96 entries");
		
		System.out.println(entries);

	}
}