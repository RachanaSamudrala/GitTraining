import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuth 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Selenium/Training/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://the-internet.herokuapp.com/"); //invokes the URL
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/basic_auth']")).click();
	}
}
