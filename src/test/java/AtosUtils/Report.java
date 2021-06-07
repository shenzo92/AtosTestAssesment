package AtosUtils;

import java.io.File;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @author Ahmed Shanwany
 *
 */

public class Report implements ITestListener {

    public void onStart(ITestContext arg0) {

	System.out.println("Start Of Execution(TEST)->" + arg0.getName());
    }

    public void onTestStart(ITestResult arg0) {

	System.out.println("Test Started->" + arg0.getName());

    }

    public void onTestSuccess(ITestResult arg0) {

	System.out.println("Test Pass->" + arg0.getName());

    }

    public void onTestFailure(ITestResult arg0) {
	System.out.println("Test Failed->" + arg0.getName());

    }

    public void onTestSkipped(ITestResult arg0) {

	System.out.println("Test Skipped->" + arg0.getName());

    }

    public void onFinish(ITestContext arg0) {

	System.out.println("END Of Execution(TEST)->" + arg0.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    /**
     * * This function will return name of the screenshot taken * @param test case
     * ID
     */
    private static String generateName(String testCaseID) {
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
	Date date = new Date();
	return testCaseID + " " + dateFormat.format(date) + ".png";
    }

    /**
     * * This function will return path of the screenshot * @param test case ID
     * * @throws Exception
     */
   
    
    private static String getScreenshotPathHTML(String testCaseID) throws IOException {
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
	String currentDateTime = format.format(date);
	String newFileNamePath = System.getProperty("user.dir")+"\\resources\\reports\\screenShots\\" + "Last-Run-On-"
		+ currentDateTime;
	//String newFileNamePath = System.getProperty("user.dir")+"\\resources\\reports";;
	File theDir = new File(newFileNamePath);
	theDir.mkdirs();
	String pathOftheScreenshots = newFileNamePath +"\\"+ generateName(testCaseID);
	return pathOftheScreenshots;
    }

    /**
     * * This function will take screenshot * @param webdriver * @param fileWithPath
     * * @throws Exception
     */
    public static void takeSnapShot(RemoteWebDriver webdriver, String fileWithPath) throws Exception {

	WebElement body = webdriver.findElement(By.tagName("body"));
	Screenshot screenshot = new AShot()
		.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.35f), 1000))
		.takeScreenshot(webdriver, body);
	ImageIO.write(screenshot.getImage(), "PNG", new File(fileWithPath));
    }
    
    public static String capture(RemoteWebDriver driver,String testCaseID) throws IOException {
	
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File(getScreenshotPathHTML(testCaseID));
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	return errflpath;
	}
    
    
}
