package AtosUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Ahmed Shanwany
 *
 */

public class ActionUtils extends AtosUtils.Base {

    public static void clickOnElement(RemoteWebDriver driver, By by) {

	// this method click on Webelement

	driver.findElement(by).click();
	
    }

    @SuppressWarnings("null")
    public static void fillElement(RemoteWebDriver driver, By element, String text) {

	if (text != null) {
	    if (text.equalsIgnoreCase("")) {
	    }

	    WebElement el = driver.findElement(element);
	    el.clear();
	    el.sendKeys(text);

	} else {
	    System.out.println("The entered Text is null or empty !!");

	}

    }

}
