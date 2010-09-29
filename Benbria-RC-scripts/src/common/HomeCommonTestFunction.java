package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Calendar;
import util.StoreGlobalVariables;
import com.thoughtworks.selenium.Selenium;

public class HomeCommonTestFunction {

	public static void admin(Selenium selenium) throws Exception {
		String verifyMessage;
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("users");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage users";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("users_new");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - User Information";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("paging");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage paging";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void adminSuperMore(Selenium selenium) throws Exception {
		String verifyMessage;
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("license");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Licensing";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("greeting_msg");
		verifyMessage = "BlazeCast - Record Greeting";
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (verifyMessage.equals(selenium.getTitle())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void contacts(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_contact_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage contacts";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("contacts_group");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage groups";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("contacts_import");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Import contacts";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("contacts_new");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Contact Information";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("group_new");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Group Information";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.type("contact_search", glo.getCid());
		selenium.click("contact_search_btn");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//div[@id='content']/div"));
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void createNew(Selenium selenium) throws Exception {
		String verifyMessage;
		selenium.click("new_broadcast_link");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Create Message";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("emerg_broadcast");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Create Message";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("emerg_broadcast");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Create Message";
		assertTrue(selenium.getTitle().equals(verifyMessage) && selenium.isElementPresent("//fieldset[@id='box_live']/label"));
	}
	
	public static void createNewPagezoneAdmin(Selenium selenium) throws Exception {
		String verifyMessage;
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("page_zone");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage Paging Groups";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void createNewPagezoneRegular(Selenium selenium) throws Exception {
		String verifyMessage;
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("page_zone");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "You are not authorized to view this page.";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void currentBroadcasts(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		for(int i=1;;i++) {
			if(selenium.getText("//div[@id='saved_broadcast']/div[2]/ul/li["+i+"]/a").equals(glo.getBid())) {
				selenium.click("//div[@id='saved_broadcast']/div[2]/ul/li["+i+"]/a");
				break;
			}
		}
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Broadcast Summary";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void newbroadcastForHome(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_create_broadcast");
		selenium.waitForPageToLoad("30000");
		selenium.click("sms_msg");
		selenium.type("textmsg", glo.getText());
		selenium.click("next_step");
		selenium.waitForPageToLoad("30000");
		selenium.type("addbox", glo.getCode());
		selenium.click("add_adhoc");
		selenium.click("jsfsubmit");
		selenium.waitForPageToLoad("30000");
		selenium.type("broadcastTitle", glo.getBid());
		selenium.type("broadcastDescription", glo.getText());
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
	}
	
	public static void reporting(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='saved_broadcast']/div/ul/li[1]/a");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Reports";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("all_reports");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Reports";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.type("report_search", glo.getBid());
		selenium.click("report_search_btn");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Search results";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void upcomingBroadcasts(Selenium selenium) throws Exception {
		String verifyMessage;
		selenium.click("//div[@id='upcoming_broadcasts']/div[3]/ul/li[1]/a");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Upcoming Broadcasts";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
	public static void usePreconfiguredBroadcast(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_broadcast_main");
		selenium.waitForPageToLoad("30000");
		for(int i=1;;i++) {
			if(selenium.getText("//div[@id='saved_broadcast']/div[2]/ul/li["+i+"]/a").equals(glo.getBid())) {
				selenium.click("//div[@id='saved_broadcast']/div[2]/ul/li["+i+"]/a");
				break;
			}
		}
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Broadcast Summary";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Preconfigured broadcasts";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.click("all_reports");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		selenium.type("broadcast_search", glo.getBid());
		selenium.click("broadcast_search_btn");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Search results";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("hdr_dashboard");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Home";
		assertEquals(verifyMessage, selenium.getTitle());
	}
	
}
