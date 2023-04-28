import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_Synchronization 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Global declaration of Implicit wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	//this will wati for 5sec whenever the pages seems to load
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));	//Method for Explicit Wait
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		String[] productsNeeded = {"Cucumber", "Beetroot", "Raspberry"};
		
		addItems(driver,productsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();	//clicks on cart icon
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//Explicit Wait
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		Thread.sleep(2000);
		driver.close();
	
	}
	
	public static void addItems(WebDriver driver, String[] productsNeeded)
	{
		int j=0;
		List<WebElement> Products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(int i=0; i<Products.size(); i++)
		{
			String[] productName = Products.get(i).getText().split("-");
			String formattedProductName = productName[0].trim();
			
			
			List productsNeededList = Arrays.asList(productsNeeded);	//this will convert array to array List
		
			if(productsNeededList.contains(formattedProductName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println("Added "+formattedProductName+ " to the cart");
				
				if(j==productsNeeded.length)
				{
					break;
				}
			}
		}	
	}
}
