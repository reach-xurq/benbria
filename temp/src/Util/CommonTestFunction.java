/**
 * CommonTestFunction.java
 * Description: Common functions.
 * Comments: Used to support some common functions for test cases.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Util;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static Util.SeleniumFactory.selenium;

public class CommonTestFunction {
	
	/**
	 * Test case initialization
	 * 
	 */
	public static void testCaseInit() {
		selenium.start();
		selenium.open("/blazecast/login.jsf");
		selenium.waitForPageToLoad("30000");
		selenium.windowMaximize();
	}
	
	public static void refreshToIndexPage() {
		selenium.open("/blazecast/login.jsf");
		selenium.waitForPageToLoad("30000");
	}
	
	/**
	 * Complete login behavior
	 * @param username
	 * @param password
	 * Correct username and password to login.
	 * @return
	 * Assertion condition
	 */
	public static void loginBehavior(String type) {
		String username, password, verify;
		if(type.equals("super")) {
			username = StoreGlobalVariables.sa;
			password = StoreGlobalVariables.sapd;
			verify = "Admin";
		}
		else if(type.equals("admin")) {
			username = StoreGlobalVariables.sa+StoreGlobalVariables.uid;
			password = StoreGlobalVariables.aupd;
			verify = StoreGlobalVariables.cid+StoreGlobalVariables.sa+" "+StoreGlobalVariables.cid+StoreGlobalVariables.sa;
		}
		else {
			username = StoreGlobalVariables.uid;
			password = StoreGlobalVariables.rupd;
			verify = StoreGlobalVariables.cid+" "+StoreGlobalVariables.cid;
		}
		selenium.type("username", username);
		selenium.type("password", password);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("hello "+verify+"!"));
		System.out.println("Assertion: Verify [Login as '"+verify+"'] Successfully.");	
	}
	
	/**
	 * Complete logout behavior
	 * @return
	 * Assertion condition
	 */
	public static void logoutBehavior() {
		selenium.click("logout");
		selenium.waitForPageToLoad("30000");
	}
	
	/**
	 * Return the caller method name
	 * Used to display in case running log
	 * @return
	 */
	public static String getMethodName() {
		return new Exception().getStackTrace()[1].getMethodName();
	}
	
	/**
	 * Used to click 'delete' link for the specified user
	 * @param username
	 * Specified username
	 * @throws Exception
	 */
	public static void manageUsersDelete(String username) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(username)) {
			if(selenium.getText("//table[@id='userlist']/tbody/tr["+row+"]/td[1]").trim().equals(username)) {
				selenium.click("//table[@id='userlist']/tbody/tr["+row+"]/td[5]/a[2]");
				selenium.getConfirmation();
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: User '"+username+"' not found!");
		return;
	}
	
	/**
	 * Used to click 'approve' link for the specified user
	 * @param username
	 * @throws Exception
	 */
	public static void manageUsersApprove(String username) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(username)) {
			if(selenium.getText("//table[@id='userlist']/tbody/tr["+row+"]/td[1]").trim().equals(username) && selenium.isElementPresent("//table[@id='userlist']/tbody/tr["+row+"]/td[4]/a[1]")) {
				selenium.click("//table[@id='userlist']/tbody/tr["+row+"]/td[4]/a[1]");
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: User '"+username+"' not found!");
		return;
	}
	
	/**
	 * Used to click 'remove' link for the specified broadcasts
	 * @param broadcasts
	 * @throws Exception
	 */
	public static void preconfiguredBroadcastsRemove(String broadcasts) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(broadcasts)) {
			if(selenium.getText("//table[@id='broadcastlist']/tbody/tr["+row+"]/td[1]/a").trim().equals(broadcasts)) {
				selenium.click("//table[@id='broadcastlist']/tbody/tr["+row+"]/td[7]/a");
				selenium.getConfirmation();
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: Broadcasts '"+broadcasts+"' not found!");
		return;
	}
	
	/**
	 * Used to search user
	 * @param username
	 * @throws Exception
	 */
	public static void commonSearch(String element) throws Exception {
		selenium.type("searchbox", element);
		selenium.click("searchsubmit");
		Thread.sleep(5000);
	}
	
	/**
	 * Used to execute the per-conditions
	 * @param selenium
	 * @throws Exception
	 */
	public static void perConditions() throws Exception {
		loginBehavior("super");
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_create_user");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", StoreGlobalVariables.uid);
		selenium.type("password", StoreGlobalVariables.rupd);
		selenium.type("passwordv", StoreGlobalVariables.rupd);
		selenium.type("email", StoreGlobalVariables.email);
		selenium.type("firstname", StoreGlobalVariables.cid);
		selenium.type("lastname", StoreGlobalVariables.cid);
		selenium.click("savenew");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", StoreGlobalVariables.sa+StoreGlobalVariables.uid);
		selenium.type("password", StoreGlobalVariables.aupd);
		selenium.type("passwordv", StoreGlobalVariables.aupd);
		selenium.type("email", StoreGlobalVariables.email);
		selenium.click("isadmin");
		selenium.type("firstname", StoreGlobalVariables.cid+StoreGlobalVariables.sa);
		selenium.type("lastname", StoreGlobalVariables.cid+StoreGlobalVariables.sa);
		selenium.click("createUser");
		selenium.waitForPageToLoad("30000");
		logoutBehavior();
	}
	
	public static void createPhone() throws Exception {
		refreshToIndexPage();
		loginBehavior("super");
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_page_phone");
		selenium.waitForPageToLoad("30000");
		selenium.type("searchbox", StoreGlobalVariables.recordNumber1);
		selenium.click("searchsubmit");
		selenium.click("hdr_create_page_phone");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", StoreGlobalVariables.sid+StoreGlobalVariables.recordNumber1);
		selenium.type("phoneextension", StoreGlobalVariables.recordNumber1);
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		logoutBehavior();
	}
	
	public static void createSpeaker() throws Exception {
		
	}
	
	public static void removeBroadcast() throws Exception {
		refreshToIndexPage();
		loginBehavior("super");
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		selenium.type("searchbox", StoreGlobalVariables.bid);
		selenium.click("searchsubmit");
		Thread.sleep(5000);
		selenium.chooseOkOnNextConfirmation();
		preconfiguredBroadcastsRemove(StoreGlobalVariables.bid);
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(StoreGlobalVariables.bid));
		System.out.println("Assertion: Verify [Remove Broadcast '"+StoreGlobalVariables.bid+"'] Successfully.");	
		logoutBehavior();
	}
	
	public void removeUser() throws Exception {
		refreshToIndexPage();
		loginBehavior("super");
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.type("searchbox", StoreGlobalVariables.uid);
		selenium.click("searchsubmit");
		Thread.sleep(5000);
		selenium.click("link=delete");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation().matches("^This will permanently delete user \\$\\{cid\\}\\$\\{SA\\} \\$\\{cid\\}\\$\\{SA\\} from the system\\. Continue[\\s\\S]$"));
		selenium.click("link=delete");
		assertTrue(selenium.getConfirmation().matches("^This will permanently delete user \\$\\{cid\\} \\$\\{cid\\} from the system\\. Continue[\\s\\S]$"));
		logoutBehavior();
	}
	
}
