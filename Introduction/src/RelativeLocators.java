import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/angularpractice/");
		
		//above() relative locator
		WebElement searchBox = driver.findElement(By.cssSelector("input[name='name']:nth-child(2)"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(searchBox)).getText());
		
		//below() relative locator
		WebElement dateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		//toLeftOf() relative locator
		WebElement checkBoxInfo = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxInfo)).click();
		
		//toRightOf() relative locator
		WebElement checkbox = driver.findElement(By.xpath("//input[@value='option1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(checkbox)).getText());
				
	}

}
