package seleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//tbody/tr/td[4]/input[1]"));
//		for(WebElement checkbox : checkBoxes) {
//			checkbox.click();
//		}
		for(int i = 4 ; i < checkBoxes.size() ; i++) {
			checkBoxes.get(i).click();
		}
		//unselect checkboxes if they are selected
//		for(int i = 0 ; i < checkBoxes.size() ; i++) {
//			if(checkBoxes.get(i).isSelected()) {
//				checkBoxes.get(i).click();
//			}
//		}
		
		//driver.close();

	}

}
