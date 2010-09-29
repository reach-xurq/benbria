package common;

import com.thoughtworks.selenium.Selenium;
import static org.junit.Assert.assertTrue;

public class BroadcastCommonTestFunction {

	/*
	 * Creat New Broadcast
	 */
	public static void NewBroadcastSuperEmail(Selenium selenium,String emailtitle,String emailmsg,String email,String broadcastTitle,String broadcastDescription)
	{
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_create_broadcast");
		selenium.waitForPageToLoad("30000");
		selenium.click("email_msg");
		selenium.type("emailtitle", emailtitle);
		selenium.type("emailmsg", emailmsg);
		selenium.click("next_step");
		selenium.waitForPageToLoad("30000");
		selenium.type("addbox", email);
		selenium.click("add_adhoc");
		selenium.click("jsfsubmit");
		selenium.waitForPageToLoad("30000");
		selenium.type("broadcastTitle", broadcastTitle);
		selenium.type("broadcastDescription", broadcastDescription);
		selenium.click("send");
		selenium.waitForPageToLoad("30000");
	}

	/*
	 * Remove Broadcast
	 */
	public static void RemoveBroadcast(Selenium selenium,String boradcastName)
	{
		ClickBroadcastTab(selenium);
		selenium.type("searchbox", boradcastName);
		selenium.click("searchsubmit");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("link=Remove");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation().matches("^This will permanently delete this preconfigured broadcast from the system\\. Continue[\\s\\S]$"));
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickBroadcastTab(Selenium selenium)
	{
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
	}
	
}
