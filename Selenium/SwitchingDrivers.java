package seleniumWebDriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class SwitchingDrivers {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		driver.findElement(By.linkText("Selenium")).click();
		String[] linkNames = { 
				"Selenium",
			    "Selenium in biology",
			    "Selenium (software)",
			    "Selenium disulfide",
			    "Selenium dioxide",
			    "More »"
		};
		for(java.lang.String name : linkNames) {
			driver.findElement(By.linkText(name)).click();
		}
		Set<String> webIds = driver.getWindowHandles();
		System.out.println("The all window id's are :");
		for(String i : webIds) {
			System.out.print(" " + "|" +  i);
			String title = driver.switchTo().window(i).getTitle();
			if(title.equals("Selenium in biology - Wikipedia")){
				driver.close();
			}
		}
	}

}
