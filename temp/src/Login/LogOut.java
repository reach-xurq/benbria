/**
 * LogOut.java
 * Description: Logout function test.
 * Comments: Used to test the user logout function.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Login;

import org.junit.After;
import org.junit.AfterClass;
import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;

public class LogOut {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Logout] started up.\n");
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Logout] teardown completed.\n");
	}

	/**
	 * Do login behavior befor logout test unit 
	 * @throws Exception
	 */
	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}

	/**
	 * Test logout function
	 * @throws Exception
	 */
	@Test public void testLogout() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		verifyMessage = "BlazeCast - Login";
		CommonTestFunction.logoutBehavior();
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to login page '"+verifyMessage+"'] Successfully.");
	}
}
