/**
 * SSLCertificate.java
 * Description: Get the root certificate function test.
 * Comments: Used to test get the root certificate related functions.
 * JDK 1.6, JUnit 4.8.2, Selenium 1.0.3
 */

package Login;

import static org.junit.Assert.assertEquals;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import Util.CommonTestFunction;
import static Util.SeleniumFactory.selenium;

public class SSLCertificate {

	//'verifyMessage' used to store the message which need to verify in each test step.
	String methodName, verifyMessage;
	
	/**
	 * Get Selenium instance and do initialization behavior of case
	 * @throws Exception
	 */
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [SSL Certificate] started up.\n");
		CommonTestFunction.refreshToIndexPage();
	}

	/**
	 * Terminate Selenium instance and close browser
	 * @throws Exception
	 */
	@AfterClass public static void tearDownAfterClass() throws Exception {
		//Display log of testing process
		System.out.println("JUnit Test [SSL Certificate] teardown completed.\n");
	}

	@Before public void setUp() throws Exception {
		methodName = new String();
		verifyMessage = new String();
	}

	@After public void tearDown() throws Exception {
		//Display log of testing process
		System.out.println("End running Test Unit ["+methodName+"].\n");
	}
	
	/**
	 * Test to get the root certificate for firefox
	 * @throws Exception
	 */
	@Test public void testGetSSLCertificate() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("ssl_cert");
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.altKeyDown();
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_O));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_I));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_N));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_N));
		selenium.altKeyUp();
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_TAB));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.windowFocus();
		verifyMessage = "Welcome, please log in";
		assertEquals(verifyMessage, selenium.getText("//div[@id='login']/div[2]/h1"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
	/**
	 * Test to get the root certificate for IE
	 * @throws Exception
	 */
	@Ignore public void testGetSSLCertificate1() throws Exception {
		methodName = CommonTestFunction.getMethodName();
		//Display log of testing process
		System.out.println("Start running Test Unit ["+methodName+"]...");
		selenium.click("ssl_cert");
		Thread.sleep(1000);
		selenium.altKeyDown();
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_O));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_I));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_N));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_N));
		selenium.altKeyUp();
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_TAB));
		Thread.sleep(1000);
		selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
		Thread.sleep(1000);
		selenium.windowFocus();
		verifyMessage = "Welcome, please log in";
		assertEquals(verifyMessage, selenium.getText("//div[@id='login']/div[2]/h1"));
		//Display log of testing process
		System.out.println("Assertion: Verify [Go to correct '"+verifyMessage+"' page] Successfully.");	
	}
	
}
