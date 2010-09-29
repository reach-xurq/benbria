/**
 * LogIn.java
 * Description: Login function test.
 * Comments: Used to test the user login related functions.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertTrue;
import Util.StoreGlobalVariables;

public class LogIn {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Login] started up.\n");
		CommonTestFunction.refreshToIndexPage();
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Login] teardown completed.\n");
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
	 * Test login with empty username and passowrd
	 * @throws Exception
	 */
	@Test public void testLoginNull() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", "");
		selenium.type("password", "");
		selenium.click("login_submit");
		verifyMessage = "Required";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/div[1]/span") && selenium.isElementPresent("//div[@id='login']/div[2]/div[2]/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with invalid character input
	 * Test data: username=${uid}, password="admin"
	 * @throws Exception
	 */
	@Test public void testInputInvalid() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", StoreGlobalVariables.illegalSignal);
		selenium.type("password", StoreGlobalVariables.sapd);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Username can only contain numbers, letters, period(.), underscore(_) and dash(-), please try again.";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/div[1]/span[@class='errortext checkblank']"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with wrong password
	 * Test data: username="admin", password is a random num
	 * @throws Exception
	 */
	@Test public void testLoginFailWithWrongPassword() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", StoreGlobalVariables.sa);
		selenium.type("password", StoreGlobalVariables.uid);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Login Failed. Please verify your username and password and try again";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/ul/li[@class='errortext']"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with wrong username
	 * Test data: username="aadmin", password="admin"
	 * @throws Exception
	 */
	@Test public void testLoginFailWithWrongUsername() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", StoreGlobalVariables.extratext+StoreGlobalVariables.sa);
		selenium.type("password", StoreGlobalVariables.sapd);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Login Failed. Please verify your username and password and try again";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/ul/li[@class='errortext']"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with too long username
	 * Test data: a too long username, password="admin"
	 * @throws Exception
	 */
	@Test public void testLoginFailWithLongUsername() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text);
		selenium.type("password", StoreGlobalVariables.sapd);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "username: Validation Error: Value is greater than allowable maximum of '25'";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/div[1]/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with too long password
	 * Test data: a too long password, username="admin"
	 * @throws Exception
	 */
	@Test public void testLoginFailWithLongPassword() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", StoreGlobalVariables.sa);
		selenium.type("password", StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text+StoreGlobalVariables.text);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "password: Validation Error: Value is greater than allowable maximum of '25'";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/div[2]/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with too short username
	 * Test data: a too short username, password="admin"
	 * @throws Exception
	 */
	@Test public void testLoginFailWithShortUsername() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("username", StoreGlobalVariables.extratext);
		selenium.type("password", StoreGlobalVariables.sapd);
		selenium.click("login_submit");
		verifyMessage = "Too short, must be at least 3characters";
		assertTrue(selenium.isElementPresent("//div[@id='login']/div[2]/div[1]/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");
	}
	
	/**
	 * Test login with correct username and password
	 * Test data: username="admin", password="admin"
	 * @throws Exception
	 */
	@Test public void testLoginSuccess() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		//Call a common function
		CommonTestFunction.loginBehavior("super");
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to Home page 'hello Admin'] Successfully.");
	}
}
