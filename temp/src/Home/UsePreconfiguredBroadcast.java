package Home;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import Util.StoreGlobalVariables;
import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsePreconfiguredBroadcast {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Use Preconfigured Broadcast] started up.\n");
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Use Preconfigured Broadcast] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	@Test public void testPreBroadcastGoToBroadcastSummaryPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		for(int i=1;;i++) {
			if(selenium.getText("//div[@id='saved_broadcast']/div[2]/ul/li["+i+"]/a").equals(StoreGlobalVariables.bid)) {
				selenium.click("//div[@id='saved_broadcast']/div[2]/ul/li["+i+"]/a");
				break;
			}
		}
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Broadcast Summary";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testPreBroadcastGoToPreconfiguredBroadcastsPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Preconfigured broadcasts";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testPreBroadcastSearchSuccess() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("all_reports");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.type("broadcast_search", StoreGlobalVariables.bid);
		selenium.click("broadcast_search_btn");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Search results";
		assertTrue(selenium.isTextPresent(verifyMessage));
		//Display log of testing process
		System.out.println("Assertion: Verify [Search '"+StoreGlobalVariables.bid+"'] Successfully.");	
	}
	
	@Test public void testPreBroadcastGoToHomePage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
}
