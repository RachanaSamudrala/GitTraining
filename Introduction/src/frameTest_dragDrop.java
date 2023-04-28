import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest_dragDrop {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		//to find the number of frames
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//to switch to frame using webElement
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("draggable")).click();
		
		//Drag and Drop
		Actions a = new Actions(driver);
		//a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//to get out of frame
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.close();
	}

}
