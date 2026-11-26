package seleniumWebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless=new");
		ChromeDriver driver = new ChromeDriver(op);
		driver.get("https://sves.org.in/ecap/Default.aspx?ReturnUrl=%2fecap");
		String tit =driver.getTitle();
		System.out.println(tit);

	}

}
