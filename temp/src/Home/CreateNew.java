package Home;

import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;

public class CreateNew {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Create New] started up.\n");
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Create New] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	@Test public void testCreateNewGoToCreateMessagePage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("new_broadcast_link");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Create Message";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testCreateNewGoToCreateMessagePage_1() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("emerg_broadcast");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Create Message";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testCreateNewGoToCreateMessagePage_2() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("emerg_broadcast");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Create Message";
		assertTrue(selenium.getTitle().equals(verifyMessage) && selenium.isElementPresent("//fieldset[@id='box_live']/label"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
}
