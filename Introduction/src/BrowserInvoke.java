import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserInvoke 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//invoking chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://qa-cm.mhealthfairview.org");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.close();
		
		//invoking edge browser
		System.setProperty("webdriver.edge.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/edgedriver_mac64/msedgedriver");
		WebDriver driver1 = new EdgeDriver();
		driver1.get("https://qa-cm.mhealthfairview.org");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		Thread.sleep(1000);
		driver1.close();
	}

}
