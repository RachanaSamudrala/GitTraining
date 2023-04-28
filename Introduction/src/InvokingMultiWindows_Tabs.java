import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultiWindows_Tabs 
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		//navigate to http://rahulshettyacademy.com/angularpractice/, fill the name field with first course name available at https://tahulshettyacademy.com
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);	//opens new tab
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		
		driver.switchTo().window(childWindowID);	//switches to newly opened tab
		driver.get("https://rahulshettyacademy.com");
		String courseName = driver.findElements(By.xpath("//div/h2/a[1]")).get(0).getText();
		System.out.println(courseName);
		
		driver.switchTo().window(parentWindowID);	//switches to parent tab
		WebElement name = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		name.sendKeys(courseName);
		
		//Taking screenshot of 'name' webelement
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/Users/racsamudrala/Documents/Fairview/R4.0/R4.0 Screenshots/ss.png"));
		
		//to get height and width of web element
		int height = name.getRect().getDimension().getHeight();
		int width = name.getRect().getDimension().getWidth();
		System.out.println("Height and Width of the component are "+height+ " and "+ width+" respectively");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
