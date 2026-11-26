package seleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		//find total number of rows in a table
		int rows =driver.findElements(By.xpath("//table[@name = 'BookTable']//tr")).size();
		System.out.println("No of rows : " + rows);
		//find number of columns
		int cols =driver.findElements(By.xpath("//table[@name = 'BookTable']//th")).size();
		System.out.println("No of columns :" + cols);
		//read data from specific row and column
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("specific row and col value :" + bookName);
		//read data from all rows and columns
		for(int i = 2 ; i <= rows ; i++) {
			for(int j = 1 ; j <= cols ; j++) {
			String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
			System.out.print(value + "\t");
			}
			System.out.println();
		}
		//get the book names whos author is mukesh
		for(int i = 2 ; i <= rows ; i++) {
			String aName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			if(aName.equals("Mukesh")) {
				String bName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println(bName + "\t" + aName);
			}
		}
		//find total price for every book
		int total = 0;
		for(int i = 2 ; i <= rows ; i++) {
		String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();	
		total = total + Integer.parseInt(price);
		}
		System.out.println("total price :" + total);
		driver.close();
	}

} 
