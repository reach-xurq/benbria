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
import Util.StoreGlobalVariables;

public class Contacts {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Contacts] started up.\n");
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [Contacts] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	@Test public void testContactsManageContactsPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_contact_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage contacts";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testContactsManageGroupsPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("contacts_group");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage groups";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testContactsImportContactsPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("contacts_import");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Import contacts";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testContactsContactInformationPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("contacts_new");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Contact Information";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testContactsGroupInformationPage() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("group_new");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Group Information";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	@Test public void testContactsContactSearchSuccess() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.type("contact_search", StoreGlobalVariables.cid);
		selenium.click("contact_search_btn");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//div[@id='content']/div"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Search '"+StoreGlobalVariables.cid+"'] Successfully.");	
	}
	
	@Test public void testContactsGoToHomePage() throws Exception {
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
