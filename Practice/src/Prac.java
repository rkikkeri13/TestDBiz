
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Prac {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Setting the driver
		try {
			Logger logger = LogManager.getRootLogger();
			WebDriver driver = new ChromeDriver();
			logger.info("Webdriver initilized");
			//Navigating to the site
			FileName f = new FileName();
			Properties prop = new Properties();

	        try {
	            // load a properties file
	            prop.load(new FileInputStream("C:\\Users\\rachana.kikkeri\\eclipse-workspace\\Practice\\resources\\config.properties"));


	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
			String url = prop.getProperty("url");
			driver.get(url);
			logger.info("Navigated to the site");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//Finding the elements to search for TSLA
			WebElement text = driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]"));
			text.sendKeys("TSLA");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//li[@title=\"Tesla, Inc.\"])[1]")).click();	
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String value = driver.findElement(By.xpath("//span[@class=\"base    yf-ipw1h0\"]")).getText();
			System.out.println(value);
			String tex = value.trim();
			//Asserting the value, if greater or not.
			double num = Double.parseDouble(tex);
			System.out.println(num);
			Assert.assertTrue(num>200,"Value greater than 200");
			logger.info("Verified that the current value of the stock price is greater than 200");
			System.out.println("Value is greater than 200");	
			String valuepre = driver.findElement(By.xpath("//span[@data-testid=\"qsp-post-price\"]")).getText();
			System.out.println("Previous price is "+valuepre);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}

}
