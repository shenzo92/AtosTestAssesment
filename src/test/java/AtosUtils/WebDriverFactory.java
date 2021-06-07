package AtosUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Ahmed Shanwany
 *
 */

public class WebDriverFactory {
    RemoteWebDriver driver;
    Properties properties = new Properties();
   
    public RemoteWebDriver setup(String PlatformAndDriver) throws InterruptedException, IOException {
	 PropertiesFileReader reader = new PropertiesFileReader();
	if (PlatformAndDriver.equalsIgnoreCase("WindowsChrome")) {
	    new DesiredCapabilities();
	    DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("nativeEvents", false);
	    caps.setCapability("unexpectedAlertBehaviour", "accept");
	    caps.setCapability("IgnoreProtectedModeSettengs", true);
	    caps.setCapability("enablePersistentHover", true);
	    caps.setCapability("ignoreZoomSetteng", true);

	    caps.setPlatform(Platform.WINDOWS);
	    
	    ChromeOptions options = new ChromeOptions();
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	    driver = new RemoteWebDriver(new URL(reader.getNodeURL()), caps);
	    driver.get(reader.getBaseUrl());
	    Thread.sleep(2000);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    try {
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	}

	else if (PlatformAndDriver.equalsIgnoreCase("MacSafari)")) {

	    new DesiredCapabilities();
	    DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("nativeEvents", false);
	    caps.setCapability("unexpectedAlertBehaviour", "accept");
	    caps.setCapability("IgnoreProtectedModeSettengs", true);
	    caps.setCapability("enablePersistentHover", true);
	    caps.setCapability("ignoreZoomSetteng", true);

	    caps.setPlatform(Platform.MAC);

	    driver = new RemoteWebDriver(new URL(reader.getNodeURL()), caps);
	    driver.get(reader.getBaseUrl());
	    Thread.sleep(2000);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    try {
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}

	return driver;
    }

}
