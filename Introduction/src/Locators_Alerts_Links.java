import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Locators_Alerts_Links {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// Sibling - parent to child traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		// Sibling - child to parent traverse

		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]/following-sibling::button[1]")).getText());

		// Entering name in search
		driver.findElement(By.id("name")).sendKeys("Test");

		// Alert
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
 		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		//To count the number of links in a page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting the scope of webDriver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//Counting the no. of links in 1st column of footer
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//Clicking on each link in the column to open in new tab and checking if the pages are opening
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++)
		{
			String linkInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(linkInNewTab);
			Thread.sleep(5000);
		}
		
		//to get the titles of pages
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		Thread.sleep(2000);

		/* System.setProperty("webdriver.chrome.driver","/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver1 = new ChromeDriver();

		// maximize window
		driver1.manage().window().maximize();
		driver1.get("http://google.com");
		// navigate to a different URL
		driver1.navigate().to("http://youtube.com");
		// navigate back
		driver1.navigate().back();
		// navigate forward
		driver1.navigate().forward();
		driver1.close();
		System.out.println("Browser closed");	*/
	}
}
