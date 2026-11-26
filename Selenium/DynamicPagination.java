package seleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		//total no of pages 
		int totalPages = driver.findElements(By.xpath("//ul[@class='pagination']//li")).size();
		System.out.println("Total number of page present : " + totalPages);
		//click on the each page one by one
		for(int i = 1 ; i <= totalPages ; i++) {
			if(i>1) {
				WebElement ele = driver.findElement(By.xpath("//ul[@class='pagination']//li["+i+"]"));
				ele.click();
				Thread.sleep(3000);
			}
			int noOfRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			
			for(int r = 1 ; r <= noOfRows ; r++) {
			String Name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
			String price = driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[3]")).getText();
			System.out.println(Name + "\t" + price);
			WebElement chb = driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[4]//input[@type='checkbox']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", chb);
			}
		}
		
	}

}
