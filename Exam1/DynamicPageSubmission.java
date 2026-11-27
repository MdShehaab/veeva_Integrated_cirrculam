package Assesment1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicPageSubmission {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.vikasqa.com/p/blog-page.html?utm_source=chatgpt.com");
		driver.findElement(By.id("username")).sendKeys("Shehaab");
		driver.findElement(By.name("email")).sendKeys("mdsheehabhameed@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select countryDrp = new Select(country);
		countryDrp.selectByVisibleText("India");
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='terms']"));
		//Conditional check using isSelected() before clicking the checkbox.
		if(!checkBox.isSelected()) {
			checkBox.click();
		}
		else {
			System.out.println("The checkbox is already selected");
		}
		driver.findElement(By.cssSelector("button[type='button']")).click();
		//verification message after submitting
		Alert myalert = driver.switchTo().alert();
		System.out.print(myalert.getText());
		Thread.sleep(2000);
		driver.quit();

	}

}
