package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdProject {

	public static void main(String[] args) throws InterruptedException {
		// WebDriver Methods
		//---------Get Methods--------------------
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		String webTitle = driver.getTitle();
		System.out.println(webTitle);
		String WebUrl = driver.getCurrentUrl();
		System.out.println(WebUrl);
		//-----------conditional methods-----------
		//isDisplayed() method
		boolean status = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']")).isDisplayed();
		System.out.println("Logo status : " + status);
		//isEnabled() method
		boolean isEnabled = driver.findElement(By.xpath("//input[@id='name']")).isEnabled();
		System.out.println("WebData status is enabled or not : " + isEnabled);
		//isSelected() Method
		WebElement male_rad = driver.findElement(By.xpath("//input[@id = 'male']"));
		WebElement female_rad = driver.findElement(By.xpath("//input[@id = 'female']"));
		System.out.println("Before selecting------------");
		System.out.println(male_rad.isSelected());
		System.out.println(female_rad.isSelected());
		System.out.println("After selecting male------------");
		male_rad.click();
		System.out.println(male_rad.isSelected());
		System.out.println(female_rad.isSelected());
		System.out.println("After selecting female------------");
		female_rad.click();
		System.out.println(male_rad.isSelected());
		System.out.println(female_rad.isSelected());
		
		driver.findElement(By.xpath("//a[normalize-space()='merrymoonmary']")).click();
		Thread.sleep(3000);
		//driver.close();
		driver.quit();
		
	}

}
