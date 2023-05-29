package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

	
	public class Baseclass {
		public RemoteWebDriver driver;
		@BeforeMethod
		@Parameters({"browser","url","username","password"})
		public void initialsteps(String browser,String url,String username,String password)
		{
			// TODO Auto-generated method stub
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver  = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver  = new EdgeDriver();
			}
			else
			{
				driver  = new FirefoxDriver();
			}
			
			
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			
		}
		@DataProvider(name="EditleadData")
		 public String[][] sendData()		 
		 {
			String data[][]= new String[2][2];
			
			data[0][0]="98887689";
			data[0][1]="Dell";
			data[1][0]="8979089";
			data[1][1]="Oracle";			
			
			return data;
		 }
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.close();
		}
		
	
	

}

