package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ecapReq {
	static void outingDT(WebDriver driver) {
		while(true) {
			String reqMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String reqYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(reqMonth.equals("December") && reqYear.equals("2026")) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt : dates) {
			if(dt.getText().equals("12")) {
				dt.click();
				break;
			}
		}
		WebElement hr_slider = driver.findElement(By.xpath("//div[@id='ui_tpicker_hour_txtfrom']//a[@class='ui-slider-handle ui-state-default ui-corner-all']"));
		System.out.println("initial posistion :" + hr_slider.getLocation());//246 , 275
		Actions act = new Actions(driver);
		act.dragAndDropBy(hr_slider , 246 , 275).perform();
		System.out.println("posistion after sliding :" + hr_slider.getLocation());
		
		driver.findElement(By.xpath("//button[normalize-space()='Done']")).click();	
	}
	static void returnDT(WebDriver driver) {
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(20));
		while(true) {
			String reqMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String reqYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(reqMonth.equals("January") && reqYear.equals("2027")) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt : dates) {
			if(dt.getText().equals("2")) {
				dt.click();
				break;
			}
		}
		 WebElement hr_slider = mywait.until(
			        ExpectedConditions.visibilityOfElementLocated(
			            By.xpath("//div[@id='ui_tpicker_hour_txtto']//a[contains(@class,'ui-slider-handle')]")
			        )
			    );
		System.out.println("initial posistion :" + hr_slider.getLocation());//246 , 275
		Actions act = new Actions(driver);
		act.dragAndDropBy(hr_slider , 246 , 275).perform();
		System.out.println("posistion after sliding :" + hr_slider.getLocation());
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Done']"))).click();
			
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sves.org.in/ecap/Default.aspx?ReturnUrl=%2fecap");
		driver.findElement(By.xpath("//input[@id='txtId2']")).sendKeys("23A81A6141");
		driver.findElement(By.xpath("//input[@id='txtPwd2']")).sendKeys("shehaab@123");
		driver.findElement(By.xpath("//input[@id='imgBtn2']")).click();
		driver.findElement(By.linkText("HOSTEL OUTING REQUEST")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@value='New Request']")).click();
		WebElement ty = driver.findElement(By.id("ddloutingtype"));
		Select li = new Select(ty);
		li.selectByValue("H");
		driver.findElement(By.xpath("//input[@id='txtfrom']")).click();
		outingDT(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtto']")).click();
		returnDT(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='txtpurpose']")).sendKeys("Holidays");
		
	}

}
