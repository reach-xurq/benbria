package testCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.CommonTestFunction;
import util.SeleniumFactory;
import util.StoreGlobalVariables;
import com.thoughtworks.selenium.Selenium;
import common.HomeCommonTestFunction;
import common.LoginCommonTestFunction;

public class Home {

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
		System.out.println("JUnit Test [Home] started up.\n");
		glo = new StoreGlobalVariables();
		selenium = SeleniumFactory.getSeleniumInstance(glo.getBrowser());
		CommonTestFunction.testCaseInit(selenium);	
		CommonTestFunction.perConditions(selenium, glo);
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		CommonTestFunction.removeBroadcast(selenium, glo);
		CommonTestFunction.removeUser(selenium, glo);
		selenium.close();
		//Display log of testing process
		System.out.println("JUnit Test [Home] teardown completed.\n");
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
	
	@Test public void testNewbroadcastForHome() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		HomeCommonTestFunction.newbroadcastForHome(selenium, glo);
	}
	
	@Test public void testHomeViaSuperAdmin() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		HomeCommonTestFunction.usePreconfiguredBroadcast(selenium, glo);
		HomeCommonTestFunction.createNew(selenium);
		HomeCommonTestFunction.createNewPagezoneAdmin(selenium);
		HomeCommonTestFunction.admin(selenium);
		HomeCommonTestFunction.adminSuperMore(selenium);
		HomeCommonTestFunction.reporting(selenium, glo);
		HomeCommonTestFunction.contacts(selenium, glo);
		HomeCommonTestFunction.currentBroadcasts(selenium, glo);
		HomeCommonTestFunction.upcomingBroadcasts(selenium);
	}
	
	@Test public void testHomeViaAdministrator() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		LoginCommonTestFunction.loginBehavior(selenium, "admin", glo);
		HomeCommonTestFunction.usePreconfiguredBroadcast(selenium, glo);
		HomeCommonTestFunction.createNew(selenium);
		HomeCommonTestFunction.admin(selenium);
		HomeCommonTestFunction.reporting(selenium, glo);
		HomeCommonTestFunction.contacts(selenium, glo);
		HomeCommonTestFunction.currentBroadcasts(selenium, glo);
		HomeCommonTestFunction.upcomingBroadcasts(selenium);
	}
	
	@Test public void testHomeViaRegularUser() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Case ["+methodName+"]...");
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		HomeCommonTestFunction.usePreconfiguredBroadcast(selenium, glo);
		HomeCommonTestFunction.createNew(selenium);
		HomeCommonTestFunction.createNewPagezoneRegular(selenium);
		HomeCommonTestFunction.reporting(selenium, glo);
		HomeCommonTestFunction.contacts(selenium, glo);
		HomeCommonTestFunction.currentBroadcasts(selenium, glo);
		HomeCommonTestFunction.upcomingBroadcasts(selenium);
	}
	
}
