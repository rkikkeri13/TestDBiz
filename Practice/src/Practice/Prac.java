package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertTrue;


public class Prac {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Setting the driver
		WebDriver driver = new ChromeDriver();
		//Navigating to the site
		driver.get("https://finance.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Finding the elements to search for TSLA
		WebElement text = driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]"));
		text.sendKeys("TSLA");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//li[@title=\"Tesla, Inc.\"])[1]")).click();	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String value = driver.findElement(By.xpath("//span[@class=\"base    yf-ipw1h0\"]")).getText();
		System.out.println(value);
		//Asserting the value, if greater or not.
		Assert.assertTrue(Integer.valueOf(value)>200,"Value greater than 200");
		System.out.println("Value is greater than 200");	
		String valuepre = driver.findElement(By.xpath("//span[@class=\"base up2   yf-ipw1h0\"]")).getText();
		System.out.println(valuepre);
				
	}

}
