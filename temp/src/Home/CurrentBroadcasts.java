package Home;

import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import Util.StoreGlobalVariables;

public class CurrentBroadcasts {
	
	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Current Broadcasts] started up.\n");
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Current Broadcasts] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	@Test public void testCurrentBroadcastsGoToBroadcastSummaryPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
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
	
	@Test public void testCurrentBroadcastsGoToHomePage() throws Exception {
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
