package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
@BeforeClass(groups= {"Master","Sanity","Regression"})
@Parameters({"browser"})
public void setUp(String br)
{
	logger = LogManager.getLogger(this.getClass());
	rb = ResourceBundle.getBundle("config");
	/*
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	*/
	if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(br.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	else if(br.equals("firefox")) {
	 
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
	 }
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.get("https://demo.opencart.com/");
	driver.get(rb.getString("appUrl"));
	driver.manage().window().maximize();
	
}
@AfterClass(groups= {"Master","Sanity","Regression"})
public void tearDown() {
	System.out.println("After class...");
	//driver.quit();
}
public String randomeString() {
	String randomString = RandomStringUtils.randomAlphabetic(5);
	return randomString; 
}
public String randomeNumber() {
	String randomNumber = RandomStringUtils.randomNumeric(10);
	return randomNumber;
}
public String randomeAlphanumber() {
	String randomAlpha = RandomStringUtils.randomAlphabetic(4);
	String randomNumber= RandomStringUtils.randomNumeric(3);
	return (randomAlpha +"@" +randomNumber); 
}
public String captureScreen(String tname) throws IOException, InterruptedException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	Thread.sleep(1000);		
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;

}

}