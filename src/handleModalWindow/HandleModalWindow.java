package handleModalWindow;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import lib.BrowserDriverUtility;
import lib.ExtentReportUtility;
import lib.ScreenshotUtility;

public class HandleModalWindow {
	
	static WebDriver dr = BrowserDriverUtility.InvokeBrowser("webdriver.chrome.driver",
			"C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\chromedriver.exe", "https://www.goibibo.com");
	static ExtentReports report = ExtentReportUtility.InvokeExtentReport();;
	static ExtentTest logger = report.createTest("Handling Bootstrap Modal Window");
	
	public static void main(String args[]) throws IOException {
		String path;
		
		try {
			path = ScreenshotUtility.CaptureScreenshot(dr, "1_MainPage");
			logger.pass("Main Page - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
			dr.findElement(By.xpath("//a[text()='Sign up']")).click();
			path = ScreenshotUtility.CaptureScreenshot(dr, "2_SignUpWindow");
			logger.pass("Sign Up Window - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

			dr.switchTo().frame("authiframe");
			
			dr.findElement(By.cssSelector("input#authMobile")).sendKeys("1234567890");
			path = ScreenshotUtility.CaptureScreenshot(dr, "3_MobNoInputWindow");
			logger.pass("Mobile No. Input Window - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

			dr.findElement(By.id("mobileSubmitBtn")).click();
			Thread.sleep(2000);
			path = ScreenshotUtility.CaptureScreenshot(dr, "4_AfterBtnClickedWin");
			logger.pass("After Button Clicked WIndow - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			report.flush();
			dr.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
