import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		//to fetch all the windows
		Set<String> windows = driver.getWindowHandles();	//[parentID, childID]
		
		//to switch to child window
		Iterator<String> it = windows.iterator();	//initially iterator w/ be outside 
		String parentID = it.next();	//parent window
		String childID = it.next();		//child window
		driver.switchTo().window(childID);
		
		//grab emailID from child window
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		String emailID = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailID);
		
		//enter emailID in parent window
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		Thread.sleep(2000);
		driver.close();
	}
}
