import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchWebPage {

	WebDriver driver;
	String url="https://www.google.com";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver","F:\\selenium\\Selenium New Jar Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	@After
	public void tearDown() throws Exception {
		//Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException 
	{
		driver.findElement(By.name("q")).sendKeys("Selenium");

		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));

		for(int i=0;i<ele.size();i++) 
		{
			String value=ele.get(i).getText();
			if(value.contains("selenium tutorial"))
			{
				Thread.sleep(5000);
				ele.get(i).click();
				break;
			}
		}

	}
}