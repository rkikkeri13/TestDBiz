
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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Prac {
	Logger logger = LogManager.getRootLogger();
	WebDriver driver = new ChromeDriver();
	
	
	@Given("login")
	public void launch()
	{
			
			
			logger.info("Webdriver initilized");
			//Navigating to the site
			FileNamePageObject f = new FileNamePageObject();
			Properties prop = new Properties();

	        try {
	            // load a properties file
	            prop.load(new FileInputStream("C:\\Users\\rachana.kikkeri\\eclipse-workspace\\Practice\\resources\\config.properties"));
	            String url = prop.getProperty("url");
				driver.get(url);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
	}
	
		@When("Read from properties file")
		public void selectElement()
		{
			FileNamePageObject fl = new FileNamePageObject();
			logger.info("Navigated to the site");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//Finding the elements to search for TSLA
			fl.callRef(driver);
			
			
}
		@Then("Quit the driver")
		public void quitDriver()
		{
			driver.quit();
		}
}
