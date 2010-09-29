/**
 * LoginTestSuite.java
 * Description: Login test suit.
 * Comments: Used to test all Login module test cases.
 * JDK 1.6, JUnit 4.8.2
 */

import static Util.SeleniumFactory.selenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import Util.CommonTestFunction;
import Util.SeleniumFactory;
import Util.StoreGlobalVariables;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	Login.ForgetPassword.class,
	Login.CreateAnAccount.class,
	Login.SSLCertificate.class,
	Login.Feedback.class,
	Login.French.class,
	Login.English.class,
	Login.LogIn.class,
	Login.LogOut.class
})

public class LoginTestSuite {	
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		new StoreGlobalVariables();
		SeleniumFactory.initSelenium(StoreGlobalVariables.browser);
		CommonTestFunction.testCaseInit();
	}

	@AfterClass public static void tearDownAfterClass() throws Exception {
		selenium.close();
	}
	
	public static Test suite() {
		return new JUnit4TestAdapter(LoginTestSuite.class);
	}
	
}
