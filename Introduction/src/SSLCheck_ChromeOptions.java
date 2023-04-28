import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class SSLCheck_ChromeOptions 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions(); //to accept privacy error certificates
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		//additional chrome browser capabilities can be referred from "www.chromebrowser.chromium.org/capabilities"
		
		//to delete a specific cookie
		driver.manage().deleteCookieNamed("abc");
		
		//to delete all cookies
		driver.manage().deleteAllCookies();
		
		//to take a screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	//to take screenshot
		FileUtils.copyFile(src, new File("/Users/racsamudrala/Documents/Fairview/R4.0/R4.0 Screenshots/Screenshot.png"));	//to store it on desktop/to required folder
		
		Thread.sleep(2000);
		driver.close();
	}

}
