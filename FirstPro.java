package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstPro {

	public static void main(String[] args) throws InterruptedException {
		//The demo test case ---> open the browser , enter username , password , and click login
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		//driver.findElement(By.id("username")).sendKeys("student");
		//driver.findElement(By.id("password")).sendKeys("Password123");
		//driver.findElement(By.className("btn")).click();
		//driver.findElement(By.linkText("PRACTICE")).click();
		//driver.findElement(By.partialLinkText("AI")).click();
		// ----------------------------- using  cssSelectors ----------------------------------
		//driver.findElement(By.cssSelector("input[id = 'username']")).sendKeys("student");
		//driver.findElement(By.cssSelector("input[id = 'password']")).sendKeys("Password123");
		//driver.findElement(By.cssSelector("button[class = 'btn']")).click();
		//---------------using XPATH----------------------------
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id = 'submit']")).click();
		Thread.sleep(3000);
		driver.close();
		
		
		

	}

}
