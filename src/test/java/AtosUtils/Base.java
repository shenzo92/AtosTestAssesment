package AtosUtils;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITest;

public class Base implements ITest {

    RemoteWebDriver driver;
    private String testInstanceName = "";
    private static String testCaseId = "";

    public RemoteWebDriver getDriver() {
	return driver;
    }

    public void setDriver(RemoteWebDriver driver) {
	this.driver = driver;
    }

    public String getTestInstanceName() {
	return testInstanceName;
    }

    public void setTestInstanceName(String testInstanceName) {
	this.testInstanceName = testInstanceName;
    }

    public static String getTestCaseId() {
	return testCaseId;
    }

    public static void setTestCaseId(String testCaseId) {
	Base.testCaseId = testCaseId;
    }

    public void setTestName(String anInstanceName) {
	testInstanceName = anInstanceName;
    }

    public String getTestName() {
	// TODO Auto-generated method stub
	return testInstanceName;
    }

}
