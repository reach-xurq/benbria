package Broadcast;

import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertTrue;
import Util.CommonTestFunction;
import Util.SeleniumFactory;
import Util.StoreGlobalVariables;
import org.junit.Test;

public class TestClick {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [] started up.\n");
		new StoreGlobalVariables();
		SeleniumFactory.initSelenium(StoreGlobalVariables.browser);
		CommonTestFunction.testCaseInit();
		CommonTestFunction.loginBehavior("super");
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [] teardown completed.\n");
		CommonTestFunction.logoutBehavior();
		selenium.close();
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	@Test public void testClick() throws Exception {
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_broadcast");
		selenium.waitForPageToLoad("30000");
		selenium.click("//table[@id='broadcastlist']/tbody/tr[1]/td[6]/div");
		selenium.type("inplace_value", "1321231321");
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_ENTER));
		Thread.sleep(5000);
		assertTrue(selenium.isTextPresent("1321231321"));
	}
	
	@Test public void testClick1() throws Exception {
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("1321231321"));
	}
	
}
