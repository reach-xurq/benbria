package Home;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import Util.StoreGlobalVariables;
import static Util.SeleniumFactory.selenium;
import static org.junit.Assert.assertEquals;

public class NewbroadcastForHome {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [New Broadcast for Home] started up.\n");
		CommonTestFunction.loginBehavior("super");
	}

	/**
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		CommonTestFunction.logoutBehavior();
		System.out.println("JUnit Test [New Broadcast for Home] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	@Test public void testNewbroadcastForHome() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_create_broadcast");
		selenium.waitForPageToLoad("30000");
		selenium.click("sms_msg");
		selenium.type("textmsg", StoreGlobalVariables.text);
		selenium.click("next_step");
		selenium.waitForPageToLoad("30000");
		selenium.type("addbox", StoreGlobalVariables.code);
		selenium.click("add_adhoc");
		selenium.click("jsfsubmit");
		selenium.waitForPageToLoad("30000");
		selenium.type("broadcastTitle", StoreGlobalVariables.bid);
		selenium.type("broadcastDescription", StoreGlobalVariables.text);
		selenium.click("check_emergency");
		selenium.click("schedule");
		Calendar cd = Calendar.getInstance();
		selenium.type("sched_date", String.valueOf(cd.get(Calendar.DATE))+"/"+String.valueOf(cd.get(Calendar.MONTH)+2)+"/"+String.valueOf(cd.get(Calendar.YEAR)));
		selenium.click("//div[@id='sched_time_div']/div/img");
		selenium.click("//div[@id='sched_time_div']/div/ul/li[20]");
		selenium.select("repeattype", "label=Weekly");
		selenium.click("weekdays:0");
		selenium.click("noenddate");
		selenium.click("send");
		selenium.waitForPageToLoad("30000");
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
}
