/**
 * Feedback.java
 * Description: Feedback function test.
 * Comments: Used to test the Feedback related functions.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Login;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import static Util.SeleniumFactory.selenium;
import Util.StoreGlobalVariables;

public class Feedback {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Feedback] started up.\n");
		CommonTestFunction.refreshToIndexPage();
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Feedback] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	/**
	 * Test to cancel Feedback
	 * @throws Exception
	 */
	@Test public void testCancelFeedback() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("feedback_link");
		selenium.waitForPageToLoad("30000");
		selenium.click("public_cancel_btn");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Welcome, please log in";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to login page '"+verifyMessage+"'] Successfully.");	
	}
	
	/**
	 * Test to send Feedback
	 * @throws Exception
	 */
	@Test public void testSendFeedback() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("feedback_link");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", StoreGlobalVariables.sa);
		selenium.type("email", StoreGlobalVariables.email);
		selenium.type("subject", StoreGlobalVariables.text);
		selenium.type("notes", StoreGlobalVariables.text);
		selenium.click("feedback_btn");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Thank you for sending us your feedback.";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show message '"+verifyMessage+"'] Successfully.");	
	}
	
	/**
	 * Test to go to specified page
	 * @throws Exception
	 */
	@Test public void testBackToLoginPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Welcome, please log in";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to login page '"+verifyMessage+"'] Successfully.");
	}
	
}
