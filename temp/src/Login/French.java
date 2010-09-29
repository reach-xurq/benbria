/**
 * French.java
 * Description: French language function test.
 * Comments: Used to test the French language swich functions.
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

public class French {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [French language] started up.\n");
		CommonTestFunction.refreshToIndexPage();
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [French language] teardown completed.\n");
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
	 * Test to go to specified page
	 * @throws Exception
	 */
	@Test public void testGoToFrenchLoginPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("//form[@id='locale_form']/a[2]");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Bienvenue, veuillez vous identifier";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to French login page '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test to go to specified page
	 * @throws Exception
	 */
	@Test public void testGoToEnglishLoginPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("link=English");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Welcome, please log in";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to English login page '"+verifyMessage+"'] Successfully.");
	}
	
}
