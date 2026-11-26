package seleniumWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		//capture all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int bl = 0;
		for(WebElement linkEle : links) {
			String hrefValue = linkEle.getAttribute("href");
			if(hrefValue==null || hrefValue.isEmpty()) {
				System.out.println("href attribute is null");
				continue;
			}
			//hit url to server
			try {
				URL linkUrl = new URL(hrefValue);
				HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
				conn.connect();
				if(conn.getResponseCode() >= 400) {
					System.out.println(hrefValue + "====>" +"brokenlink");
					bl++;
				}
				else {
					System.out.println(hrefValue + "====>" +"Not brokenlink");
				}
			}
			catch(Exception e) {}
		}
		System.out.println("No oof brokenlinks" + bl);
		
	}

}
