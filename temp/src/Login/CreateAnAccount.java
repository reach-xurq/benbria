/**
 * CreateAnAccount.java
 * Description: Create account function test.
 * Comments: Used to test the create account related functions.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import static Util.SeleniumFactory.selenium;
import Util.StoreGlobalVariables;

public class CreateAnAccount {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Create an account] started up.\n");
		CommonTestFunction.refreshToIndexPage();
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Create an account] teardown completed.\n");
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
	@Test public void testGoToUserInformationPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("create_account_link");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - User Information";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	/**
	 * Test to go to specified page
	 * @throws Exception
	 */
	@Test public void testGoToLoginPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Login";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	/**
	 * Test to display the error message 'Duplicated contact method'
	 * @throws Exception
	 */
	@Test public void testDisplayErrorMessage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("create_account_link");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", StoreGlobalVariables.uid);
		selenium.type("password", StoreGlobalVariables.rupd);
		selenium.type("passwordv", StoreGlobalVariables.rupd);
		selenium.type("email", StoreGlobalVariables.email);
		selenium.type("firstname", StoreGlobalVariables.cid);
		selenium.type("lastname", StoreGlobalVariables.cid);
		selenium.type("address1", StoreGlobalVariables.text);
		selenium.type("address2", StoreGlobalVariables.text);
		selenium.type("city", StoreGlobalVariables.text);
		selenium.type("state", StoreGlobalVariables.text);
		selenium.type("zipcode", StoreGlobalVariables.code);
		selenium.type("country", StoreGlobalVariables.text);
		selenium.type("notes", StoreGlobalVariables.text);
		selenium.click("ptype_h_0");
		selenium.type("items:0:pnumber", StoreGlobalVariables.code);
		selenium.click("ptype_m_1");
		selenium.type("items:1:pnumber", StoreGlobalVariables.code);
		selenium.click("requestAccess");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Duplicated contact method";
		assertEquals(verifyMessage, selenium.getText("//table[@id='items']/tbody/tr[2]/td/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");		
	}
	
	/**
	 * Test to display the error message 'Invalid cell phone number'
	 * @throws Exception
	 */
	@Test public void testDisplayInvalidMessage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("items:1:pnumber", StoreGlobalVariables.recordNumber2);
		selenium.click("requestAccess");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Invalid cell phone number";
		assertEquals(verifyMessage, selenium.getText("//table[@id='items']/tbody/tr[2]/td/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");		
	}
	
	/**
	 * Test to display the error message 'Invalid number or email'
	 * @throws Exception
	 */
	@Test public void testDisplayInvalidMessageCombination() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("items:1:pnumber", StoreGlobalVariables.recordNumber1+StoreGlobalVariables.recordNumber3);
		selenium.click("//table[@id='items']/tbody/tr[3]/td/label[4]");
		selenium.type("items:2:pnumber", StoreGlobalVariables.badEmail);
		selenium.click("requestAccess");
		verifyMessage = "Invalid number or email";
		assertEquals(verifyMessage, selenium.getText("//table[@id='items']/tbody/tr[3]/td/span"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show error message '"+verifyMessage+"'] Successfully.");		
	}
	
	/**
	 * Test to save a account successfully
	 * @throws Exception
	 */
	@Test public void testCreateUserSuccessfully() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.type("items:1:pnumber", StoreGlobalVariables.recordNumber1+StoreGlobalVariables.recordNumber3);
		selenium.type("items:2:pnumber", StoreGlobalVariables.email);
		selenium.click("requestAccess");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "We have successfully received your request. You will be notified via email when your account is ready.";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Show message '"+verifyMessage+"'] Successfully.");		
	}
	
	/**
	 * Test to delete the user created yet
	 * @throws Exception
	 */
	@Test public void testDeleteUser() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		verifyMessage = StoreGlobalVariables.uid;
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		//Call a common function
		CommonTestFunction.loginBehavior("super");
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		//Call a common function
		CommonTestFunction.commonSearch(verifyMessage);
		selenium.chooseOkOnNextConfirmation();
		//Call a common function
		CommonTestFunction.manageUsersDelete(verifyMessage);
		selenium.waitForPageToLoad("30000");
		assertTrue(!selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Delete user '"+verifyMessage+"'] Successfully.");	
	}
	
	/**
	 * Test to go to specified page
	 * @throws Exception
	 */
	@Test public void testLogout() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		verifyMessage = "BlazeCast - Login";
		CommonTestFunction.logoutBehavior();
		assertEquals("BlazeCast - Login", selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to login page '"+verifyMessage+"'] Successfully.");
	}
	
}
