package testCases;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.thoughtworks.selenium.Selenium;
import common.AdminCommonTestFunction;
import common.LoginCommonTestFunction;
import util.CommonTestFunction;
import util.SeleniumFactory;
import util.StoreGlobalVariables;

public class Admin {

	//'verifyMessage' used to store the message which need to verify in each test step.
	private String methodName;
	private static StoreGlobalVariables glo;
	private static Selenium selenium;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Admin] started up.\n");
		glo = new StoreGlobalVariables();
		selenium = SeleniumFactory.getSeleniumInstance(glo.getBrowser());
		CommonTestFunction.testCaseInit(selenium);	
		CommonTestFunction.perConditions(selenium, glo);
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		CommonTestFunction.removeUser(selenium, glo);
		selenium.close();
		//Display log of testing process
		System.out.println("JUnit Test [Admin] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		CommonTestFunction.refreshToIndexPage(selenium);	
	}

	@After public void tearDown() throws Exception {
		LoginCommonTestFunction.logoutBehavior(selenium);
		//Display log of testing process
		System.out.println("End running Test Case ["+methodName+"].\n");
	}
	
	/**
	 * Test create users and change password via super-admin
	 * @throws Exception
	 */
	@Test public void testCreateUserAndChangePasswordViaSuperAdmin() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		assertTrue(LoginCommonTestFunction.loginBehavior(selenium, "super", glo));
		AdminCommonTestFunction.createUsers(selenium, glo);
		AdminCommonTestFunction.changePassword(selenium, glo);
	}
	
	/**
	 * Test users management via super-admin
	 * @throws Exception
	 */
	@Test public void testManageUserViaSuperAdmin() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		assertTrue(LoginCommonTestFunction.loginBehavior(selenium, "super", glo));
		AdminCommonTestFunction.manageUser(selenium, glo);
	}
	
	@Test public void testManageOthersViaSuperAdmin() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		assertTrue(LoginCommonTestFunction.loginBehavior(selenium, "super", glo));
		AdminCommonTestFunction.approveUser(selenium, glo);
		AdminCommonTestFunction.deleteManageUser(selenium, glo);
		AdminCommonTestFunction.createNewFloorPlan(selenium, glo);
		AdminCommonTestFunction.managePagingGroups(selenium, glo);
		AdminCommonTestFunction.manageMaps(selenium, glo);
		AdminCommonTestFunction.viewPagingSpeakers(selenium, glo);
		AdminCommonTestFunction.managePagingPhones(selenium, glo);
		AdminCommonTestFunction.deleteManageMaps(selenium, glo);
		AdminCommonTestFunction.managePcs(selenium, glo);
		AdminCommonTestFunction.manageTasks(selenium, glo);
	}
	
	/**
	 * Test create users and change password via administrator
	 * @throws Exception
	 */
	@Ignore public void testCreateUserAndChangePasswordViaAdministrator() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		assertTrue(LoginCommonTestFunction.loginBehavior(selenium, "super", glo));
		AdminCommonTestFunction.createUsers(selenium, glo);
		AdminCommonTestFunction.changePassword(selenium, glo);
	}
	
	/**
	 * Test users management via administrator
	 * @throws Exception
	 */
	@Ignore public void testManageUserViaAdministrator() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		assertTrue(LoginCommonTestFunction.loginBehavior(selenium, "super", glo));
		AdminCommonTestFunction.manageUser(selenium, glo);
	}
	
	@Ignore public void testManageOthersViaAdministrator() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		assertTrue(LoginCommonTestFunction.loginBehavior(selenium, "super", glo));
		AdminCommonTestFunction.approveUser(selenium, glo);
		AdminCommonTestFunction.deleteManageUser(selenium, glo);
		AdminCommonTestFunction.createNewFloorPlan(selenium, glo);
		AdminCommonTestFunction.managePagingGroups(selenium, glo);
		AdminCommonTestFunction.manageMaps(selenium, glo);
		AdminCommonTestFunction.viewPagingSpeakers(selenium, glo);
		AdminCommonTestFunction.managePagingPhones(selenium, glo);
		AdminCommonTestFunction.deleteManageMaps(selenium, glo);
		AdminCommonTestFunction.managePcs(selenium, glo);
		AdminCommonTestFunction.manageTasks(selenium, glo);
	}
	
}
