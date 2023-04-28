
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators
{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Method call
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Username
		driver.findElement(By.id("inputUsername")).sendKeys("test");
		
		//Password
		driver.findElement(By.name("inputPassword")).sendKeys("1234");
		
		//Login
		driver.findElement(By.className("signInBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Incorrect username or password using CSS Selector
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		
		//Forgot username or password
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Name
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testone");
		
		//Email
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test1@one.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("test@one.com");
		
		//Phone
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9999911111");
		Thread.sleep(2000);
		
		//Reset login
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		//Info text
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		Thread.sleep(2000);
		
		//back to login
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
	
		//RE-LOGIN
		driver.findElement(By.id("inputUsername")).sendKeys("test");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		//Logout
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	//Method declaration
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText = (driver.findElement(By.cssSelector("form p")).getText());
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");
		//[0] index = Please use temporary password 
		//[1] index = rahulshettyacademy' to Login.
		String[] passwordArray1 = passwordArray[1].split("'");
		//[0] index = rahulshettyacademy
		//[1] index =  to Login.
		String password = passwordArray1[0];
		return password;
	}

}
