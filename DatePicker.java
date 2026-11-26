package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	static void SelectDate(WebDriver driver , String month , String year , String date) {
		while(true) {
			String cMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String cYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(cMonth.equals(month) && cYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
			List<WebElement> actualDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			for(WebElement dt : actualDate) {
				
				if(dt.getText().equals(date)) {
					dt.click();
					break;
				}
			}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		SelectDate(driver,"June","2027","14");
		
	}

}
