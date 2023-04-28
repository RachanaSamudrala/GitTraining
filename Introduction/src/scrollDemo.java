import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrollDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//window scroll
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
		Thread.sleep(2000);
		
		//to scroll the table 
		js.executeScript("document.querySelector('div.tableFixHead').scroll(0,600)");
		
		//to sum up values in amount column
		List<WebElement> values= driver.findElements(By.xpath("//div[@class='tableFixHead'] //tr/td[4]"));
		int count = driver.findElements(By.xpath("//div[@class='tableFixHead'] //tr/td[4]")).size();
		int sum = 0;
		for(int i=0; i<count; i++)
		{
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Sum is "+sum);
		
		//to get sum from page and compare with generated sum
		String sumOnPage = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		int totalOnPage = Integer.parseInt(sumOnPage);
		
		Assert.assertEquals(sum, totalOnPage);
		
		Thread.sleep(2000);
		driver.close();
	}
}
