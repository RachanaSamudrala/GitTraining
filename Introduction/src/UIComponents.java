import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UIComponents 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/racsamudrala/Documents/Fairview/eclipse-workspace/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		
		//STATIC DROPDOWN - select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//DROPDOWN with alterable values
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("hrefIncAdt")).click(); //1 adult to 2 adults
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); //2 adults to 6 adults directly
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//DYNAMIC DROPDOWN
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();	//Selects Bangalore as From City
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();	//1st instance would be in From City which is not on the screen. 2nd istance is from To City
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();	//Parent-child relationship xpath
		Thread.sleep(2000);
		
		//CALENDAR
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();	//to select current date
		
		//AUTO SUGGESTIVE DROPDOWN
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> suggestions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));	//gets the entire list of suggestions for entered search term
		for(WebElement sugg:suggestions)
		{
			if(sugg.getText().equalsIgnoreCase("India"))
			{
				sugg.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//CHECKBOX
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected()); //output should be false since checkbox is not checked
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());	//to verify if checkbox is selected or not
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size()+" checkboxes in total");	//to count the number of checkboxes 
		
		//RADIO BUTTON
		System.out.println(driver.findElement(By.className("picker-second")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();	//selects radio button - round trip
		System.out.println(driver.findElement(By.className("picker-second")).getAttribute("style"));
		
		if(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1"))	//to check if component is enabled or disabled
		{
			System.out.println("Return date component is enabled");
		}
		else
		{
			System.out.println("Return date component is disabled");
		}
		
		//Search
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']")).click();
		
		Thread.sleep(10000);
		driver.close(); 
	}
}
