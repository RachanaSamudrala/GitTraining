import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javaStreamFilter 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//to search for "to" in the search filed and verify if the results has "to" in them
		driver.findElement(By.id("search-field")).sendKeys("to");
		List<WebElement> results = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredResults = results.stream().filter(s->s.getText().contains("to")).collect(Collectors.toList());
		
		System.out.print("Results are as expected");
		Assert.assertEquals(results.size(), filteredResults.size());
		
		Thread.sleep(2000);
		driver.close();
				
	}

}
