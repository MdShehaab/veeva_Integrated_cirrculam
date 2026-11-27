package Assesment1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJsAlerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
		driver.findElement(By.linkText("test confirm")).click();
		Alert myAlert = driver.switchTo().alert();
		System.out.println("The conformation alert text is : " + myAlert.getText());
		Thread.sleep(1000);
		myAlert.dismiss();
		Thread.sleep(2000);
		//myAlert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@id='prompt']")).click();
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		promptAlert.sendKeys("AutomationTest");
		Thread.sleep(1000);
		promptAlert.dismiss();
		driver.quit();
		
		
	}

}
