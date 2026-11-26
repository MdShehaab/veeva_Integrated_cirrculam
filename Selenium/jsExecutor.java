package seleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.thetestingacademy.com/playwright/widgets/scroll");
//		WebElement ibox = driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].setAttribute('value' , 'jhon')", ibox);
//		WebElement rbtn = driver.findElement(By.xpath("//input[@id = 'male']"));
//		js.executeScript("arguments[0].click()", rbtn);
		//1.scroll page by the pixels
		js.executeScript("window.scrollBy(0,1500)","");
		System.out.print(js.executeScript("return window.pageYOffset;"));
		//2.scroll till the element is visible
//		WebElement ele = driver.findElement(By.xpath("//button[@id='cta-button']"));
//		js.executeScript("arguments[0].scrollIntoView();", ele);
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		System.out.print(js.executeScript("return window.pageYOffset;"));
	}

}
