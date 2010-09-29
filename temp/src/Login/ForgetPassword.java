/**
 * ForgetPassword.java
 * Description: Forget password function test.
 * Comments: Used to test the Forget Password related functions.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Login;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import static Util.SeleniumFactory.selenium;
import Util.StoreGlobalVariables;

public class ForgetPassword {
	
	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;

	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Forget password] started up.\n");
		CommonTestFunction.refreshToIndexPage();
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Forget password] teardown completed.\n");
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
	 * Test with empty email input.
	 * @throws Exception
	 */
	@Test public void testInputNull() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("forgot_password");
		selenium.waitForPageToLoad("30000");
		selenium.click("changePassword");
		verifyMessage = "Required";
		assertEquals(verifyMessage, selenium.getText("//form[@id='message']/fieldset/ol/li[1]/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test with invalid invalid character input
	 * @throws Exception
	 */
	@Test public void testInputInvalid() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
        selenium.type("email", StoreGlobalVariables.text);
		selenium.click("changePassword");
		verifyMessage = "Invalid email address";
		assertEquals(verifyMessage, selenium.getText("//form[@id='message']/fieldset/ol/li[1]/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test with the email which no exist in DB
	 * @throws Exception
	 */
	@Test public void testInputNotExist() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
        selenium.type("email", "2323"+StoreGlobalVariables.email);
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "The email address you entered is not in the system.";
		assertEquals(verifyMessage, selenium.getText("//form[@id='message']/ul/li"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test with correct email
	 * @throws Exception
	 */
	@Test public void testInputExist() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
        selenium.type("email", StoreGlobalVariables.email);
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		try {
			selenium.click("message:nextpage");
		}
		catch(Exception e) {
			fail("Element dose not exsit!");
		}
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Login";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to login page '"+verifyMessage+"'] Successfully.");
	}
	
}
