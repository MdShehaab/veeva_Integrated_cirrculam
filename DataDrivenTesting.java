package seleniumWebDriver;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenTesting {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://calculator.academy/simple-interest-calculator/?utm_source=chatgpt.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// reading the data from the excel file
		String file_path = System.getProperty("user.dir") + "\\excel\\new.xlsx";
		int rows = excelUtils.getRowCount(file_path , "TestData");
		for(int i = 1 ; i<=rows ; i++) {
			//read data from excel
			String princ = excelUtils.getCellData(file_path, "TestData", i, 0);
			String asr = excelUtils.getCellData(file_path, "TestData", i, 1);
			String elapsed	 = excelUtils.getCellData(file_path, "TestData", i, 2);
			String pre1 = excelUtils.getCellData(file_path, "TestData", i, 3);
			String actual_maturity = excelUtils.getCellData(file_path, "TestData", i,4);
			//pass above data to application 
			
			WebElement principal = driver.findElement(
			    By.xpath("//input[@id='ca6460-principal']")
			);
			principal.clear();
			principal.sendKeys(princ);

			
			WebElement rate = driver.findElement(
			    By.xpath("//input[@id='ca6460-rate']")
			);
			rate.clear();
			rate.sendKeys(asr);

			
			WebElement time = driver.findElement(
			    By.xpath("//input[@id='ca6460-time']")
			);
			time.clear();
			time.sendKeys(elapsed);

			// Select time period
			WebElement drp = driver.findElement(
			    By.xpath("//select[@id='ca6460-time-unit']")
			);
			Select drps = new Select(drp);
			drps.selectByVisibleText(pre1);
			WebElement cal = driver.findElement(By.xpath("//button[@id='ca6460-calculate']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", cal);
			//validation

			// Validation

			String interest = driver.findElement(
			    By.xpath("//section[@id='c-results']//div[3]//dd")
			).getText();
			interest = interest.replace("$", "").replace(",", "").trim();

			actual_maturity = actual_maturity.replace(",", "").trim();
			double actual = Double.parseDouble(interest);
			double expected = Double.parseDouble(actual_maturity);
			if (Math.abs(actual - expected) <= 0.01) {

			    System.out.println("Test Passed------");

			    excelUtils.setCellData(file_path, "TestData", i, 5, "Passed");

			    excelUtils.fillGreenColor(file_path, "TestData", i, 5);

			}
			else {

			    System.out.println("Test Failed------");

			    excelUtils.setCellData(file_path, "TestData", i, 5, "Failed");

			    excelUtils.fillRedColor(file_path, "TestData", i, 5);

			}
			Thread.sleep(3000);
		}
		driver.quit();
		
		

	}

}
