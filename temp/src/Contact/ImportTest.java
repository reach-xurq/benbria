package Contact;

import static Util.SeleniumFactory.selenium;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Util.CommonTestFunction;
import Util.SeleniumFactory;


public class ImportTest {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [SSL Certificate] started up.");
		SeleniumFactory.initSelenium("*iexplore");
		CommonTestFunction.testCaseInit();
		CommonTestFunction.loginBehavior("super");
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		CommonTestFunction.logoutBehavior();
		selenium.close();
		//Display log of testing process
		System.out.println("JUnit Test [SSL Certificate] teardown completed.");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].");
	}
	
	@Test public void testImport() throws Exception {
		selenium.click("hdr_contact_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_import_contact");
		selenium.waitForPageToLoad("30000");
		//selenium.focus("//form[@id='contact_form']/fieldset/ol/li[2]/input");
		//selenium.fireEvent("//form[@id='contact_form']/fieldset/ol/li[2]/input", "blur");
		selenium.click("//form[@id='contact_form']/fieldset/ol/li[2]/input");
		//Thread.sleep(3000);
		System.out.println(selenium.getAllWindowIds());
		System.out.println(selenium.getAllWindowNames());
		System.out.println(selenium.getAllWindowTitles());
		//selenium.windowFocus();
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_O));
		selenium.altKeyDown();
		selenium.keyPressNative(String.valueOf(KeyEvent.VK_O));
		selenium.altKeyUp();
		Thread.sleep(3000);
	}
	
}
