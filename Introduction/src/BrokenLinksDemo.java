import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksDemo 
{

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//BROKEN LINKS
		//step 1: to get all the url's
		// String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href"); - to get single url
	
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
		
			//step 2: to get the status code
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			/* if(responseCode>400)
			{	
				System.out.println("Link with text "+link.getText()+" is broken with Response Code: "+responseCode);
				Assert.assertTrue(false);
			}	*/
			a.assertTrue(responseCode<400, "Link with text "+link.getText()+" is broken with Response Code: "+responseCode);
		}
		a.assertAll();
	
		Thread.sleep(2000);
		driver.close();
	}

}
