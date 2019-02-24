
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class fitnessTesting {
	public String baseUrl = "localhost:8081/com";
	public WebDriver driver ; 

	@BeforeTest
	public void verifyHomepageTitle() {

		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		String expectedTitle = "Fight for fitness";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
	}

	@Test 
	public void login() throws InterruptedException{
		driver.findElement(By.id("usrname")).clear();
		driver.findElement(By.id("usrname")).sendKeys("subha");
		driver.findElement(By.id("pswrd")).clear();
		driver.findElement(By.id("pswrd")).sendKeys("123");
		driver.findElement(By.id("button")).click();
	        driver.findElement(By.id("fage")).sendKeys("24");
		driver.findElement(By.id("fhght")).sendKeys("157");
		driver.findElement(By.id("fwght")).sendKeys("54");
		
		driver.findElement(By.id("button")).click();
		Thread.sleep(2000);
		double value= Double.parseDouble(driver.findElement(By.id("fid")).getAttribute("value"));
		//System.out.println("Value  "+value);
		if(value<25){
			System.out.println("Less healthy, concentrate on your health");
		}else if(value >= 25 && value <= 50){
			System.out.println("Average healthy, you can increase to be better");
		}
		else{
			System.out.println("Average healthy, you can increase to be better");
		}
	}
	@AfterTest
	public void closebrowser(){
		driver.close();
	}
}
