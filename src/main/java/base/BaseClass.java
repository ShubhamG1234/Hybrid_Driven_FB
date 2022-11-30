package base;
	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	
	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.Test_utility;
	import utilities.Web_Utility;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static Web_Utility eventListener;
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	public ExtentReports extent =new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter( "test-output/ExtentReport.html");
	ExtentTest test;

	public BaseClass() {
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					"C:\\Users\\SHUBHAM\\eclipse-workspace\\Hybrid_Driven\\src\\main\\java\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHUBHAM\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Lunching Chrome Browser....");
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SHUBHAM\\Desktop\\TST\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");

			driver = new FirefoxDriver();
			log.info("Lunching Firefox Browser....");
		}

		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new Web_Utility();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Maximizing Browser....");
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Test_utility.Page_Load_TImeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Test_utility.IMPLICIT, TimeUnit.SECONDS);
		log.info("Opening Application URL....");

	}

}