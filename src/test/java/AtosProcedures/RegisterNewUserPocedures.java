package AtosProcedures;

import org.openqa.selenium.remote.RemoteWebDriver;

import AtosData.RegisterNewUserData;
import AtosPageObject.RegisterNewUserPageObject;

/**
 * @author Ahmed Shanwany
 *
 */

public class RegisterNewUserPocedures {
    public static void registerWithUser(RemoteWebDriver driver, RegisterNewUserData data) throws InterruptedException {
	RegisterNewUserPageObject registerationPage = new RegisterNewUserPageObject(driver);

	// this is the logical Execution for the scenario under test

	registerationPage.fillFirstNameTextField(data.getFirstName()).fillLastNameTextField(data.getLastName())
		.fillMobileNumberTextField(data.getMobileNumber()).fillEmailAdressTextField(data.getEmailAddress())
		.fillPasswordTextField(data.getPassword()).fillconfirmPasswordTextField(data.getPassword());
	Thread.sleep(5000);
	registerationPage.clickSubmitButton();

    }

}
