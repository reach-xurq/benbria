/**
 * CommonTestFunction.java
 * Description: Common functions.
 * Comments: Used to support some common functions for test cases.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package util;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import com.thoughtworks.selenium.Selenium;
import common.AdminCommonTestFunction;
import common.LoginCommonTestFunction;

public class CommonTestFunction {
	
	/**
	 * Test case initialization
	 * 
	 */
	public static void testCaseInit(Selenium selenium) {
		selenium.start();
		selenium.open("/blazecast/login.jsf");
		selenium.waitForPageToLoad("30000");
		selenium.windowMaximize();
	}
	
	public static void refreshToIndexPage(Selenium selenium) {
		selenium.open("/blazecast/login.jsf");
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
	 * Used to click 'remove' link for the specified broadcasts
	 * @param broadcasts
	 * @throws Exception
	 */
	public static void preconfiguredBroadcastsRemove(Selenium selenium, String broadcasts) throws Exception {
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
	public static void commonSearch(Selenium selenium, String element) throws Exception {
		selenium.type("searchbox", element);
		selenium.click("searchsubmit");
		selenium.waitForCondition("selenium.browserbot.getUserWindow().jQuery.active == 0", "5000");
	}
	
	/**
	 * Used to execute the per-conditions
	 * @param selenium
	 * @throws Exception
	 */
	public static void perConditions(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running ["+methodName+"]...");
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_create_user");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", glo.getUid());
		selenium.type("password", glo.getRupd());
		selenium.type("passwordv", glo.getRupd());
		selenium.type("email", glo.getEmail());
		selenium.type("firstname", glo.getCid());
		selenium.type("lastname", glo.getCid());
		selenium.click("savenew");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", glo.getSa()+glo.getUid());
		selenium.type("password", glo.getAupd());
		selenium.type("passwordv", glo.getAupd());
		selenium.type("email", glo.getEmail());
		selenium.click("isadmin");
		selenium.type("firstname", glo.getCid()+glo.getSa());
		selenium.type("lastname", glo.getCid()+glo.getSa());
		selenium.click("createUser");
		selenium.waitForPageToLoad("30000");
		LoginCommonTestFunction.logoutBehavior(selenium);
		//Display log of testing process
		System.out.println("End running ["+methodName+"].\n");
	}
	
	public static void createPhone(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		refreshToIndexPage(selenium);
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_page_phone");
		selenium.waitForPageToLoad("30000");
		selenium.type("searchbox", glo.getRecordNumber1());
		selenium.click("searchsubmit");
		selenium.click("hdr_create_page_phone");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", glo.getSid()+glo.getRecordNumber1());
		selenium.type("phoneextension", glo.getRecordNumber1());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		LoginCommonTestFunction.logoutBehavior(selenium);
	}
	
	public static void createSpeaker(Selenium selenium) throws Exception {
		
	}
	
	public static void removeBroadcast(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		refreshToIndexPage(selenium);
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		commonSearch(selenium, glo.getBid());
		selenium.chooseOkOnNextConfirmation();
		preconfiguredBroadcastsRemove(selenium, glo.getBid());
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(glo.getBid()));
		System.out.println("Assertion: Verify [Remove Broadcast '"+glo.getBid()+"'] Successfully.");	
		LoginCommonTestFunction.logoutBehavior(selenium);
	}
	
	public static void removeUser(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running ["+methodName+"]...");
		refreshToIndexPage(selenium);
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		commonSearch(selenium, glo.getUid());
		selenium.chooseOkOnNextConfirmation();
		AdminCommonTestFunction.commonDelete(selenium, glo.getUid(), "userlist", 5);
		selenium.waitForPageToLoad("30000");
		selenium.chooseOkOnNextConfirmation();
		AdminCommonTestFunction.commonDelete(selenium, glo.getSa()+glo.getUid(), "userlist", 5);
		selenium.waitForPageToLoad("30000");
		LoginCommonTestFunction.logoutBehavior(selenium);
		//Display log of testing process
		System.out.println("End running ["+methodName+"].\n");
	}
	
	public static void waitForCommand(Selenium selenium, boolean command) throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (command) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
}
