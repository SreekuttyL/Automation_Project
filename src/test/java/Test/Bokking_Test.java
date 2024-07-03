package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Booking;

public class Bokking_Test {
	ChromeDriver driver;
	@BeforeMethod
	public void open()
	{
		driver = new ChromeDriver();
		driver.get("https://onlineksrtcswift.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws Exception
	{
		Booking booking_ob=new Booking(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		booking_ob.Title_Verification();
		booking_ob.One_Way_Trip();
		booking_ob.tagname();
		//booking_ob.Response_code();
		booking_ob.logo();
		booking_ob.Manage_Booking();
		booking_ob.Webelmnt_screenshot();
	}
	
	

}
