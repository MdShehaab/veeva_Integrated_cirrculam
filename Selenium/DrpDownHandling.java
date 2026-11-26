package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DrpDownHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		//select dropdown
		WebElement dpc = driver.findElement(By.xpath("//select[@id='country']"));
		dpc.click();
		Select drp = new Select(dpc);
//		drp.selectByVisibleText("Canada");
//		drp.selectByValue("uk");
		List<WebElement> options = drp.getOptions();
		System.out.println(options.size());
		for(WebElement op : options) {
			System.out.println(op.getText());
		}
		driver.close();
	}

}
