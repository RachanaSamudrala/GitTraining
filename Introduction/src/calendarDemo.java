import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(1000);
		
		//To select month as August 2023
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		
		while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText().contains("August"))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			Thread.sleep(1000);
		}
		
		//To select travel date as 28
		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		int count = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).size();
		
		for(int i=0; i<count ; i++)
		{
			String text = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
			if(text.equalsIgnoreCase("28"))
			{
				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
				break;
			}
		}
		
	}

}
