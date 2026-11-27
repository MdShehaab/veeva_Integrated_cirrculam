package Assesment1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		String parent = driver.getWindowHandle();
		System.out.println("Parent window ID : " + parent);
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		Set<String> windowIds = driver.getWindowHandles();
		for(String window : windowIds) {
			if(!window.equals(parent)) {
				driver.switchTo().window(window);
				String title = driver.getTitle();
				System.out.println("child window title :" + title);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		String parentTitle = driver.getTitle();
		System.out.println("Parent window title :" + parentTitle);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("shehaab");
	}

}
