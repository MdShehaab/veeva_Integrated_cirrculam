package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Datepicker2 {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.findElement(By.xpath("//input[@id='datepicker2']")).click();
		String date = "14";
		String month = "November";
		String year = "2023";
		WebElement Currmonth = driver.findElement(By.xpath("//select[@title='Change the month']"));
		String mo = Currmonth.getText();
		if(!mo.equals(month)) {
			Currmonth.click();
		}
		Select months = new Select(Currmonth);
		months.selectByVisibleText(month);
		
		WebElement CurrYear = driver.findElement(By.xpath("//select[@title='Change the year']"));
		String yr = CurrYear.getText();
		if(!yr.equals(year)) {
			CurrYear.click();
		}
		Select yrs = new Select(CurrYear);
		yrs.selectByVisibleText(year);
		
		List<WebElement> dates = driver.findElements(
			    By.xpath("//div[@class='datepick-month']//tbody//tr//td//a"));

			for(WebElement dt : dates) {

			    if(dt.getText().equals(date)) {

			        dt.click();
			        break;
			    }
			}
		

	}

}
