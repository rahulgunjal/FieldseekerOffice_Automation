package SeleniumGlueCode;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestFSOScenario1
{
	public WebDriver driver;
	
	@Given("^user is  on loginpage$")
	public void user_is_on_loginpage() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul\\Downloads\\Selenium\\chromedriver.exe");
	    
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://fieldseekeroffice.aspcore.net/Default.aspx");
	    System.out.println("Browser launch Successfully");

	}

	@When("^user navigates to SignIn Page$")
	public void user_navigates_to_SignIn_Page() throws Throwable
	{
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
		
	}
	
	/*@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable
	{
		 driver.findElement(By.xpath("//input[@id='user_username']")).sendKeys("FSAdministrator");
		 driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("FSA@2018");
		 driver.findElement(By.xpath("//button[@id='signIn']")).click();
	}
*/
	@Then("^Verify all the tabs are displayed successfully$")
	public void verify_all_the_tabs_are_displayed_successfully() throws Throwable 
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
		 for(String handle2 : allWindowHandles)
		 {
			 System.out.println("Switching to window - > " + handle2);	 
			 driver.switchTo().window(handle2); 
		 }
		boolean Review = driver.findElement(By.xpath("(//div[@class='toolsBox'])[1]")).isDisplayed();
		System.out.println("is Review tab are: " + Review);
		
		boolean SR = driver.findElement(By.xpath("(//span[contains(.,'Service Requests')])[2]")).isDisplayed();
		System.out.println("is Service Request tab are: " + SR);
		
		boolean LT = driver.findElement(By.xpath("(//div[@class='toolsBox'])[3]")).isDisplayed();
		System.out.println("is Lab Tools tab are: " + LT);
		
		boolean Map = driver.findElement(By.xpath("(//div[@class='toolsBox'])[4]")).isDisplayed();
		System.out.println("is Map tab are: " + Map);
		
		boolean PI = driver.findElement(By.xpath("(//div[@class='toolsBox'])[5]")).isDisplayed();
		System.out.println("is Product Inventory tab are: " + PI);
		
		boolean PTA = driver.findElement(By.xpath("(//div[@class='toolsBox'])[6]")).isDisplayed();
		System.out.println("is Proposed Treatment Area tab are: " + PTA);
		
		boolean Confi = driver.findElement(By.xpath("(//div[@class='toolsBox'])[7]")).isDisplayed();
		System.out.println("is Configuration tab are: " + Confi);
		
		boolean Reports = driver.findElement(By.xpath("(//div[@class='toolsBox'])[8]")).isDisplayed();
		System.out.println("is Reports tab are: " + Reports);
		
		boolean MM = driver.findElement(By.xpath("(//div[@class='toolsBox'])[9]")).isDisplayed();
		System.out.println("is Maintenance Map  tab are: " + MM);
		
		boolean GS = driver.findElement(By.xpath("(//div[@class='toolsBox'])[10]")).isDisplayed();
		System.out.println("is Gateway Sync  tab are: " + GS);
		
		boolean DR = driver.findElement(By.xpath("(//div[@class='toolsBox'])[11]")).isDisplayed();
		System.out.println("is Data Review  tab are: " + DR);
	}
}