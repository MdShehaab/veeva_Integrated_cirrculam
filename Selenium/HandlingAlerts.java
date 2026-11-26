package seleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
		//Normal alert with ok button
//		driver.findElement(By.xpath("//a[@id='alert']")).click();
//		Alert myalert = driver.switchTo().alert();
//		//printing the alert window msg!!!
//		System.out.println(myalert.getText());
//		myalert.accept();
		//conformation alertt which have ok and cancel button
		driver.findElement(By.xpath("//a[@id='prompt-with-default']")).click();
		//driver.findElement(By.xpath("//a[@id='double-prompt']")).click();
//		Alert myA = driver.switchTo().alert();
//		myA.sendKeys("Hii");
//		myA.accept();
//		Alert myA2 = driver.switchTo().alert();
//		myA2.sendKeys("Hello");
//		myA2.accept();
//		
		//Handling alerts using explicit weights
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert myAR = myWait.until(ExpectedConditions.alertIsPresent());
		myAR.sendKeys("welcome back");
		myAR.accept();
		//automate ok 
//		myA.sendKeys("shehaab");
//		myA.accept();
		//automate cancel
		//myA.dismiss();
		
		
	}

}
