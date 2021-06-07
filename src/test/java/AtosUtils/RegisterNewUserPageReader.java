package AtosUtils;

import java.io.IOException;

import AtosData.RegisterNewUserData;

/**
 * @author Ahmed Shanwany
 *
 */

public class RegisterNewUserPageReader extends AtosUtils.FileReader {
    public static RegisterNewUserData[] getLoginData(String filePath, String sheetName) {

	try {
	    openExcell(filePath, sheetName);

	    readFields();
	    readTestdata();
	    RegisterNewUserData[] LoginInput = new RegisterNewUserData[data.size()];

	    for (int i = 0; i < data.size(); i++) {

		LoginInput[i] = new RegisterNewUserData();

		LoginInput[i].setTestCaseID((data.get(i)).get(header.indexOf("testCaseID")));
		LoginInput[i].setTestCaseName((data.get(i)).get(header.indexOf("testCaseName")));
		LoginInput[i].setFirstName((data.get(i)).get(header.indexOf("firstName")));
		LoginInput[i].setLastName((data.get(i)).get(header.indexOf("lastName")));
		LoginInput[i].setMobileNumber((data.get(i)).get(header.indexOf("mobileNumber")));
		LoginInput[i].setEmailAddress((data.get(i)).get(header.indexOf("emailAddress")));
		LoginInput[i].setPassword((data.get(i)).get(header.indexOf("password")));

	    }
	    closeExcel();

	    return LoginInput;

	} catch (IOException e) {

	    e.printStackTrace();
	    System.err.println("ERROR!! Could NOT oppen the excel file ");
	    return null;
	}
    }
}
