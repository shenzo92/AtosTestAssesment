package AtosPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import AtosUtils.ActionUtils;

/**
 * @author Ahmed Shanwany
 *
 */

public class RegisterNewUserPageObject {
    RemoteWebDriver driver;
    By firstNameTextfield = By.xpath("//*[@id=\"headersignupform\"]/div[3]/div[1]/div/label/input");
    By lastNameTextField = By.xpath("//*[@id=\"headersignupform\"]/div[3]/div[2]/div/label/input");
    By mobileNumberTextField = By.xpath("//*[@id=\"headersignupform\"]/div[4]/label/input");
    By emailTextField = By.xpath("//*[@id=\"headersignupform\"]/div[5]/label/input");
    By passwordTextField = By.xpath("//*[@id=\"headersignupform\"]/div[6]/label/input");
    By confirmPasswordTextField = By.xpath("//*[@id=\"headersignupform\"]/div[7]/label/input");
    By signUpButton = By.xpath("//*[@id=\"headersignupform\"]/div[8]/button");

    public RegisterNewUserPageObject(RemoteWebDriver driver) {
	this.driver = driver;
    }

    // Actions that can be made on all the needed fields in the Scenario under Test
    // (5 test cases)

    public RegisterNewUserPageObject fillFirstNameTextField(String firstname) {
	ActionUtils.fillElement(driver, firstNameTextfield, firstname);
	return this;
    }

    public RegisterNewUserPageObject fillLastNameTextField(String lastName) {
	ActionUtils.fillElement(driver, lastNameTextField, lastName);
	return this;
    }

    public RegisterNewUserPageObject fillMobileNumberTextField(String monileNumber) {
	ActionUtils.fillElement(driver, mobileNumberTextField, monileNumber);
	return this;
    }

    public RegisterNewUserPageObject fillEmailAdressTextField(String email) {
	ActionUtils.fillElement(driver, emailTextField, email);
	return this;
    }

    public RegisterNewUserPageObject fillPasswordTextField(String password) {
	ActionUtils.fillElement(driver, passwordTextField, password);
	return this;
    }

    public RegisterNewUserPageObject fillconfirmPasswordTextField(String password) {
	ActionUtils.fillElement(driver, confirmPasswordTextField, password);
	return this;
    }

    public RegisterNewUserPageObject clickSubmitButton() {
	ActionUtils.clickOnElement(driver, signUpButton);
	return this;
    }

}
