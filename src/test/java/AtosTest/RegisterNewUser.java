package AtosTest;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.AssertJUnit;
import AtosData.RegisterNewUserData;
import AtosProcedures.RegisterNewUserPocedures;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import AtosUtils.RegisterNewUserPageReader;
import AtosUtils.Report;
import AtosUtils.WebDriverFactory;

/**
 * @author Ahmed Shanwany
 *
 */

public class RegisterNewUser extends AtosUtils.Base {

    RemoteWebDriver driver;
    Properties properties = new Properties();
    static ExtentReports extentReport;
    static ExtentTest  test;
    @DataProvider(name = "excelData")
    public RegisterNewUserData[] readInuptFile() throws InvalidFormatException, IOException {
	// this method read the and intialize the Data in the Datasheet for this
	// scenario
	File directory = new File(".");
	System.out.println(directory.getCanonicalPath());
	String CompleteFileName = directory.getCanonicalPath() + "\\resources\\TestData\\Register\\Register_Data.xls";
	return RegisterNewUserPageReader.getLoginData(CompleteFileName, "Sheet1");
    }
    @BeforeClass
    public static void startTest() throws IOException
    {
   // File directory = new File(".");
    extentReport = new ExtentReports(System.getProperty("user.dir")+"\\resources\\Reports\\outputReport.html");
    test = extentReport.startTest("Register User");
    }

    @BeforeMethod
    public void beforeMethod(Object[] testData) throws InterruptedException, IOException {

	// we set test case id for reporting and initialize the web driver or each test
	// case in he scenario

	RegisterNewUserData data = (RegisterNewUserData) testData[0];
	String testCaseID = data.getTestCaseID();
	setTestCaseId(testCaseID);
	WebDriverFactory d = new WebDriverFactory();

	// you can change the flag "WindowsChrome" and add more else paragraphs in the
	// WebDriverFactory class
	// for cross platform cross browser execution

	driver = d.setup("WindowsChrome");
	Thread.sleep(2000);
	AssertJUnit.assertEquals(driver.getTitle().contains("Register"), true);
    }

    @Test(dataProvider = "excelData")

    public void Register(RegisterNewUserData data) throws InterruptedException, IOException {

	ITestResult reportData = Reporter.getCurrentTestResult();
	reportData.setAttribute("testCase ID", data.getTestCaseID());

	RegisterNewUserPocedures.registerWithUser(driver, data);
	Thread.sleep(10000);

	// the logic of assertions is that if it is positive test case then i will be
	// moved to My Account page
	// if it is negative test case i should remain in the registration screen and
	// receive an error message

	if (data.getTestCaseName().contains("Negative")) {
	    if(driver.getTitle().contains("Register")) {
		test.log(LogStatus.PASS, data.getTestCaseID().toString()+" "+data.getTestCaseName()+" Passed");
	    }
	    else {
		test.log(LogStatus.FAIL, data.getTestCaseID().toString()+" "+data.getTestCaseName()+" Failed");
		test.log(LogStatus.FAIL,test.addScreenCapture(Report.capture(driver,"."+getTestCaseId()))+ " Failed");
	    }
	   AssertJUnit.assertEquals(driver.getTitle().contains("Register"), true);
	} else {
	    if(driver.getTitle().contains("My Account")) {
		test.log(LogStatus.PASS, data.getTestCaseID().toString()+" "+data.getTestCaseName()+" Passed");
	    }
	    else {
		test.log(LogStatus.FAIL, data.getTestCaseID().toString()+" "+data.getTestCaseName()+"Failed");
		test.log(LogStatus.FAIL,test.addScreenCapture(Report.capture(driver,"."+getTestCaseId()))+ " Failed");
	    }
	   AssertJUnit.assertEquals(driver.getTitle().contains("My Account"), true);
	}

    }

    @AfterMethod
    public void afterMethod() throws Exception {

	driver.quit();
    }
    @AfterClass
    public static void endTest()
    {
    extentReport.endTest(test);
    extentReport.flush();
    }
    }


