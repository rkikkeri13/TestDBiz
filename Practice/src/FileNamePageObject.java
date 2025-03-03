import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileNamePageObject {


	public void callRef(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement text = driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]"));
		text.sendKeys("TSLA");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//li[@title=\"Tesla, Inc.\"])[1]")).click();	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String value = driver.findElement(By.xpath("//span[@class=\"base    yf-ipw1h0\"]")).getText();
		String tex = value.trim();
		double num = Double.parseDouble(tex);
		System.out.println(num);
		assertStep(driver,num);
	}
	public void assertStep(WebDriver driver ,double num)
	{
		//Asserting the value, if greater or not.
		Assert.assertTrue(num>200,"Value greater than 200");
		System.out.println("Value is greater than 200");	
		String valuepre = driver.findElement(By.xpath("//span[@data-testid='qsp-pre-price']")).getText();
		System.out.println("Previous price is "+valuepre);
	}
}
