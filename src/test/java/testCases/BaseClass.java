package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public static Logger log;
	public Properties p;
	public WebDriverWait wait;

	@Parameters({ "browser" })
	@BeforeClass
	public void setUp(@Optional("chrome") String br) throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		log = LogManager.getLogger(this.getClass());

		switch (br) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid support browser..");
		}

		log.info("....browser opened....");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Thread.sleep(3000);
		driver.get(p.getProperty("appUrl"));
		// Thread.sleep(3000);
		log.info("....URL is opened...");

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File tar = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, tar);
		System.out.println("sceeen shot taken");
	}

	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@AfterClass
	public void tearDown()

	{
		driver.quit();
		log.info("...browser closed...");
	}

}
