package Pages;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Booking {
	ChromeDriver driver;
	String actual_result="KSRTC-SWIFT | ENTE KSRTC Neo-oprs | KSRTC SWIFT Buses Online Reservation";
	String expected_result;
	String url="https://onlineksrtcswift.com/";
	
	public Booking(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void Title_Verification()
	{
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[5]/div/a")).click();
		//Title Method
			String expected_result = driver.getTitle();
			System.out.println("TITLE IS :"+expected_result);
		if(actual_result.equalsIgnoreCase(expected_result))
		{
			System.out.println("Verification is Passed");
		}
		else
		{
			System.out.println("Verification is Failed");
		}
		
	}
	
	public void One_Way_Trip()
	{
		driver.findElement(By.xpath("//*[@id=\"frmSearch\"]/div/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"fromCity_chosen\"]/div/div/input")).sendKeys("Kollam",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"frmSearch\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"toCity_chosen\"]/div/div/input")).sendKeys("Ernakulam",Keys.ENTER);
//Date Picker
		driver.findElement(By.id("departDate")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[3]/td[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/section[1]/div[3]/div[2]/div[1]/form/div/div[3]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section[2]/div[1]/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section[2]/div[1]/div[2]/div[2]/div[2]/label[1]")).click();
//Mouse Scrolldown from top to bottom 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div/div[2]/div[4]")).click();
//Navigate Method
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[5]/div/a")).click();
	}
	
//Tagname Methods
	public void tagname()
	{
		 List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: "+list.size());
		for(WebElement a:list)
		{
			String b = a.getAttribute("href");
			String c = a.getText();
			System.out.println(a+"-----------"+c);
		}	
	}
	

//Webelement Screenshot
	public void Webelmnt_screenshot() throws IOException
	{
		//driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/div[2]/div[1]/ul/li[5]/a")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"body\"]/div[3]/footer/div[1]/div[2]/h1"));
		File src=contact.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File ("./Screenshort//contact_us.png"));	
	}
//Response code	
	public void Response_code() throws Exception 
	{
		URL ob1=new URL("url");
		ob1.openConnection();
		HttpURLConnection ob2=(HttpURLConnection)ob1.openConnection();
		int res_code=ob2.getResponseCode();
		ob2.connect();
		System.out.println("Response code :"+res_code);
		/*if(res_code==200)
		
			System.out.println("Pass");
		else
			System.out.println("Fail");*/
		
	}
	
//Logo verification
	public void logo()
	{
		boolean logo = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/div[1]/header/div/div[1]/a/img")).isDisplayed();
		if(logo)
			System.out.println("Logo is present");
		else
			System.out.println("Logo is not present");
		
	}
	
//Mouse Over
	public void Manage_Booking()
	{
		Actions act=new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/div[2]/div[1]/ul/li[4]/a"));
		act.moveToElement(a).perform();
		WebElement b = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/div[2]/div[1]/ul/li[4]/ul/li/a"));
		act.moveToElement(b).perform();
		b.click();
		driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/div[1]/header/div/div[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[5]/div/a")).click();
		
	}

}
