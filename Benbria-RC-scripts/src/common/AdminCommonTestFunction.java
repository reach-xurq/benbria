package common;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import util.CommonTestFunction;
import util.StoreGlobalVariables;
import com.thoughtworks.selenium.Selenium;

public class AdminCommonTestFunction {

	/**
	 * Used to click 'delete' link for the specified element
	 * @param username
	 * Specified username
	 * @throws Exception
	 */
	public static void commonDelete(Selenium selenium, String name, String id, int maxLine) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(name)) {
			if(selenium.getText("//table[@id='"+id+"']/tbody/tr["+row+"]/td[1]").trim().equals(name)) {
				selenium.click("//table[@id='"+id+"']/tbody/tr["+row+"]/td["+maxLine+"]/a[2]");
				selenium.getConfirmation();
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: "+name+"' not found!");
		return;
	}
	
	/**
	 * Used to click 'delete' link for the specified map
	 * @param username
	 * Specified username
	 * @throws Exception
	 */
	public static void manageMapsDelete(Selenium selenium, String name) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(name)) {
			if(selenium.getText("//table[@id='floorplanlist']/tbody/tr["+row+"]/td[1]/a/strong").trim().equalsIgnoreCase(name)) {
				selenium.click("//table[@id='floorplanlist']/tbody/tr["+row+"]/td[3]/a[3]");
				selenium.getConfirmation();
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: "+name+"' not found!");
		return;
	}
	
	/**
	 * Used to click 'delete' link for the specified map
	 * @param username
	 * Specified username
	 * @throws Exception
	 */
	public static void pcListDelete(Selenium selenium, String name) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(name)) {
			if(selenium.getText("//table[@id='pclist']/tbody/tr["+row+"]/td[1]").trim().equalsIgnoreCase(name)) {
				selenium.click("//table[@id='pclist']/tbody/tr["+row+"]/td[5]/a");
				selenium.getConfirmation();
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: "+name+"' not found!");
		return;
	}
	
	/**
	 * Used to click 'approve' link for the specified user
	 * @param username
	 * @throws Exception
	 */
	public static void manageUsersApprove(Selenium selenium, String username) throws Exception {
		int row = 1;
		boolean flag = false;
		while(selenium.isTextPresent(username)) {
			if(selenium.getText("//table[@id='userlist']/tbody/tr["+row+"]/td[1]").trim().equals(username) && selenium.isElementPresent("//table[@id='userlist']/tbody/tr["+row+"]/td[4]/a[1]")) {
				selenium.click("//table[@id='userlist']/tbody/tr["+row+"]/td[4]/a[1]");
				flag = true;
				break;
			}
			row++;
		}	
		if(!flag) fail("Failure: User '"+username+"' not found!");
		return;
	}
	
	public static void createUsers(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_create_user");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage users";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_create_user");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", glo.getUid()+glo.getUid());
		selenium.type("password", glo.getAupd());
		selenium.type("passwordv", glo.getAupd());
		selenium.click("isadmin");
		selenium.click("ptype_m_0");
		selenium.click("//table[@id='items']/tbody/tr[1]/td/label[3]");
		selenium.type("items:0:pnumber", glo.getCode());
		selenium.type("email", glo.getEmail());
		selenium.click("copy_p_email");
		selenium.click("ptype_e_1");
		selenium.type("firstname", glo.getCid()+glo.getText());
		selenium.type("lastname", glo.getCid()+glo.getText());
		selenium.type("address1", glo.getCode());
		selenium.type("address2", glo.getCode());
		selenium.type("city", glo.getText());
		selenium.type("state", glo.getText());
		selenium.type("zipcode", glo.getCode());
		selenium.type("country", glo.getText());
		selenium.type("notes", glo.getText());
		selenium.click("savenew");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Successfully created user \""+glo.getCid()+glo.getText()+" "+glo.getCid()+glo.getText()+"\". Create another user using the form below.";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.type("username", glo.getText()+glo.getUid());
		selenium.type("password", glo.getRupd());
		selenium.type("passwordv", glo.getRupd());
		selenium.click("ptype_m_0");
		selenium.click("//table[@id='items']/tbody/tr[1]/td/label[3]");
		selenium.type("items:0:pnumber", glo.getCode());
		selenium.type("email", glo.getEmail());
		selenium.click("copy_p_email");
		selenium.click("ptype_e_1");
		selenium.type("firstname", glo.getCid()+glo.getUid());
		selenium.type("lastname", glo.getCid()+glo.getUid());
		selenium.type("address1", glo.getCode());
		selenium.type("address2", glo.getCode());
		selenium.type("city", glo.getText());
		selenium.type("state", glo.getText());
		selenium.type("zipcode", glo.getCode());
		selenium.type("country", glo.getText());
		selenium.type("notes", glo.getText());
		selenium.type("ext", glo.getRecordNumber4());
		selenium.click("createUser");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getText()+glo.getUid();
		CommonTestFunction.commonSearch(selenium, verifyMessage);
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("hdr_contact_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getCid()+glo.getUid();
		CommonTestFunction.commonSearch(selenium, verifyMessage);
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[2]/ol/li[5]/strong/a");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getRecordNumber4();
		CommonTestFunction.commonSearch(selenium, verifyMessage);
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//table[@id='phonelist']/tbody/tr/td[5]/a[2]");
		selenium.getConfirmation();
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(verifyMessage));
	}
	
	public static void changePassword(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Edit an existing user account";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		selenium.type("newpassword", glo.getRupd());
		selenium.type("newpasswordv", glo.getRupd());
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "The password has been changed successfully.";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Edit an existing user account";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		selenium.type("newpassword", "");
		selenium.type("newpasswordv", "");
		selenium.click("changePassword");
		verifyMessage = "Required";
		assertEquals(verifyMessage, selenium.getText("//form[@id='message']/fieldset/ol/li[2]/span"));
		assertEquals(verifyMessage, selenium.getText("//form[@id='message']/fieldset/ol/li[3]/span"));
		selenium.type("newpassword", glo.getRupd());
		selenium.type("newpasswordv", glo.getSapd());
		selenium.click("changePassword");
		verifyMessage = "Passwords do not match";
		assertEquals(verifyMessage, selenium.getText("//form[@id='message']/fieldset/ol/li[2]/span"));
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Edit an existing user account";
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		selenium.type("newpassword", glo.getSapd());
		selenium.type("newpasswordv", glo.getSapd());
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "The password has been changed successfully.";
		assertTrue(!selenium.isTextPresent(glo.getRupd()) && selenium.isTextPresent(verifyMessage));
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		LoginCommonTestFunction.logoutBehavior(selenium);
		LoginCommonTestFunction.loginCustom(selenium, glo.getText()+glo.getUid(), glo.getRupd());
		verifyMessage = "Login Failed. Please verify your username and password and try again";
		assertEquals(verifyMessage, selenium.getText("//div[@id='login']/div[2]/ul/li"));
		LoginCommonTestFunction.loginCustom(selenium, glo.getText()+glo.getUid(), glo.getSapd());
		assertEquals("BlazeCast - Home", selenium.getTitle());
	}
	
	public static void manageUser(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = selenium.getText("//table[@id='userlist']/tbody/tr[1]/td[1]");
		selenium.click("//table[@id='userlist']/tbody/tr[1]/td[5]/a[1]");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.commonSearch(selenium, verifyMessage);
		selenium.chooseCancelOnNextConfirmation();
        commonDelete(selenium, verifyMessage, "userlist", 5);
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.chooseOkOnNextConfirmation();
		commonDelete(selenium, verifyMessage, "userlist", 5);
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(verifyMessage));
		LoginCommonTestFunction.logoutBehavior(selenium);
		selenium.click("create_account_link");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", glo.getUid()+glo.getSa());
		selenium.type("password", glo.getRupd());
		selenium.type("passwordv", glo.getRupd());
		selenium.type("email", glo.getEmail());
		selenium.type("firstname", glo.getCid());
		selenium.click("requestAccess");
		selenium.waitForPageToLoad("30000");
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		LoginCommonTestFunction.loginBehavior(selenium, "super", glo);
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getUid()+glo.getSa();
		CommonTestFunction.commonSearch(selenium, verifyMessage);
		assertTrue(selenium.isTextPresent(verifyMessage));
	}
	
	public static void approveUser(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getUid()+glo.getSa();
		manageUsersApprove(selenium, verifyMessage);
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("User "+verifyMessage+" has been approved."));
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		selenium.chooseOkOnNextConfirmation();
		commonDelete(selenium, verifyMessage, "userlist", 5);
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(verifyMessage));
	}
	
	public static void deleteManageUser(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getUid()+glo.getUid();
		CommonTestFunction.commonSearch(selenium, verifyMessage);
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.chooseOkOnNextConfirmation();
		commonDelete(selenium, verifyMessage, "userlist", 5);
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(verifyMessage));
		selenium.click("hdr_contact_main");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getCid()+glo.getText();
		assertFalse(selenium.isTextPresent(verifyMessage));
	}
	
	public static void createNewFloorPlan(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		String verifyMessage;
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[1]/ol/li[4]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "BlazeCast - Manage users";
		assertEquals(verifyMessage, selenium.getTitle());
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[1]/ol/li[4]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.type("title", glo.getUid());
		selenium.type("descr", glo.getText());
		selenium.select("imageurl", "label=ViewImage.gif");
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		verifyMessage = glo.getUid();
		assertTrue(selenium.isTextPresent(verifyMessage));
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[1]/ol/li[4]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.type("title", glo.getUid());
		selenium.type("descr", glo.getText()+glo.getText());
		selenium.select("imageurl", "label=ViewImage.gif");
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		verifyMessage = "Failed to create Floor Plan. A floor plan with the same name may already exist. Please try again.";
		assertEquals(verifyMessage, selenium.getText("//ul[@id='globalmsg']/li"));
	}
	
	public static void managePagingGroups(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[2]/ol/li[2]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Paging Groups", selenium.getTitle());
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", glo.getGid());
		selenium.type("number", glo.getRecordNumber3());
		selenium.type("descr", glo.getText());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", glo.getMid());
		selenium.type("number", glo.getRecordNumber3());
		selenium.type("descr", glo.getText());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Duplicated extension "+glo.getRecordNumber3()+".."));
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.commonSearch(selenium, glo.getGid());
		assertTrue(selenium.isTextPresent(glo.getGid()));
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Paging Groups", selenium.getTitle());
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", glo.getGid()+glo.getSa());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getGid()+glo.getSa()));
		selenium.chooseCancelOnNextConfirmation();
		commonDelete(selenium, glo.getGid()+glo.getSa(), "zonelist", 5);
		assertTrue(selenium.isTextPresent(glo.getGid()+glo.getSa()));
		selenium.chooseOkOnNextConfirmation();
		commonDelete(selenium, glo.getGid()+glo.getSa(), "zonelist", 5);
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(glo.getGid()+glo.getSa()));
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_page_zone");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("No results match your query"));
	}
	
	public static void manageMaps(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_location_map");
		selenium.waitForPageToLoad("30000");
		selenium.click("//table[@id='floorplanlist']/tbody/tr[1]/td[1]/a/strong");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Floor Plans", selenium.getTitle());
		selenium.click("//table[@id='floorplanlist']/tbody/tr[1]/td[3]/a[2]");
		selenium.waitForPageToLoad("30000");
		selenium.chooseCancelOnNextConfirmation();
		selenium.click("remove");
		selenium.getConfirmation();
		assertEquals("BlazeCast - Manage Floor Plans", selenium.getTitle());
		selenium.type("title", glo.getMid());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getMid()));
		selenium.click("//table[@id='floorplanlist']/tbody/tr[1]/td[3]/a[1]");
		selenium.waitForPageToLoad("30000");
		selenium.click("btnCancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Floor Plans", selenium.getTitle());
		selenium.click("//table[@id='floorplanlist']/tbody/tr[1]/td[3]/a[1]");
		selenium.waitForPageToLoad("30000");
		selenium.click("btnAddSpeaker");
		selenium.click("//div[@id='mapspace']/div[2]/input[1]");
		selenium.type("//div[@id='mapspace']/div[2]/input[1]", glo.getSid()+glo.getRecordNumber5());
		selenium.click("//div[@id='mapspace']/div[2]/input[2]");
		selenium.type("//div[@id='mapspace']/div[2]/input[2]", glo.getRecordNumber5());
		selenium.click("btnAddPhone");
		selenium.focus("//div[@id='mapspace']/div[4]/input[1]");
		selenium.type("//div[@id='mapspace']/div[4]/input[1]", glo.getPid()+glo.getRecordNumber5());
		selenium.focus("//div[@id='mapspace']/div[4]/input[2]");
		selenium.type("//div[@id='mapspace']/div[4]/input[2]", glo.getRecordNumber4());
		selenium.focus("//div[@id='mapspace']/div[2]/a");
		selenium.click("//div[@id='mapspace']/div[2]/a");
		selenium.focus("btnSave");
		selenium.click("btnSave");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, selenium.isTextPresent("Pageable devices have been saved successfully."));
		selenium.click("message:nextpage");
	}
	
	public static void viewPagingSpeakers(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		CommonTestFunction.refreshToIndexPage(selenium);
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[2]/ol/li[4]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Paging Speakers", selenium.getTitle());
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, selenium.isElementPresent("speakername"));
		selenium.type("speakername", glo.getSid()+glo.getSid());
		selenium.type("speakerextension", glo.getRecordNumber2());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.commonSearch(selenium, glo.getSid()+glo.getSid());
		assertTrue(selenium.isTextPresent(glo.getSid()+glo.getSid()));
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, selenium.isElementPresent("speakername"));
		selenium.type("speakername", glo.getSid()+glo.getSid());
		selenium.type("speakerextension", glo.getRecordNumber5());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getSid()+glo.getSid()));
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, selenium.isElementPresent("speakername"));
		selenium.type("speakername", glo.getSid()+glo.getSid());
		selenium.type("speakerextension", glo.getRecordNumber5());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Duplicated extension "+glo.getRecordNumber5()+".."));
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		for(int i=1;;i++) {
			if(selenium.getText("//table[@id='speakerlist']/tbody/tr["+i+"]/td[1]/a").equalsIgnoreCase(glo.getSid()+glo.getSid())) {
				selenium.click("//table[@id='speakerlist']/tbody/tr["+i+"]/td[1]/a");
				break;
			}
		}		
		CommonTestFunction.waitForCommand(selenium, "Configure Paging Devices".equals(selenium.getText("//form[@id='configurespeakers']/h1")));
		assertEquals("Configure Paging Devices", selenium.getText("//form[@id='configurespeakers']/h1"));
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, "View paging speakers".equals(selenium.getText("hdr_browse_page_speaker")));
		selenium.click("hdr_browse_page_speaker");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, "edit".equals(selenium.getText("link=edit")));
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.waitForCommand(selenium, selenium.isElementPresent("cancel"));
		selenium.waitForCondition("selenium.browserbot.getUserWindow().jQuery.active == 0", "5000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getSid()+glo.getSid()));
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("speakername", glo.getSid()+glo.getRecordNumber5());
		selenium.type("speakerextension", glo.getRecordNumber5());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[2]/div[1]/div/a/img");
		CommonTestFunction.waitForCommand(selenium, selenium.isTextPresent(glo.getSid()+glo.getRecordNumber5()));
		assertTrue(selenium.isTextPresent(glo.getSid()+glo.getRecordNumber5()));
		selenium.click("//div[@id='sidenav']/div[2]/ul/li[1]/a/strong");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_page_speaker");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("speakername", glo.getPid()+glo.getRecordNumber2());
		selenium.type("speakerextension", glo.getRecordNumber2());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Duplicated extension "+glo.getRecordNumber2()+".."));
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		selenium.chooseCancelOnNextConfirmation();
		commonDelete(selenium, glo.getSid()+glo.getRecordNumber5(), "speakerlist", 4);
		assertTrue(selenium.isTextPresent(glo.getSid()+glo.getRecordNumber5()));
		selenium.chooseOkOnNextConfirmation();
		commonDelete(selenium, glo.getSid()+glo.getRecordNumber5(), "speakerlist", 4);
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(glo.getSid()+glo.getRecordNumber5()));
	}
	
	public static void managePagingPhones(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[2]/ol/li[5]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Pageable Phones", selenium.getTitle());
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", glo.getPid()+glo.getPid());
		selenium.type("phoneextension", glo.getRecordNumber4());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getPid()+glo.getPid()));
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", glo.getPid()+glo.getPid());
		selenium.type("phoneextension", glo.getRecordNumber4());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Duplicated extension "+glo.getRecordNumber4()+".."));
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", glo.getPid()+glo.getPid());
		selenium.type("phoneextension", glo.getRecordNumber5());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getPid()+glo.getPid()));
		CommonTestFunction.waitForCommand(selenium, selenium.isElementPresent("sidecontent"));
		CommonTestFunction.commonSearch(selenium, glo.getPid());
		assertTrue(selenium.isTextPresent(glo.getPid()+glo.getPid()));
		for(int i=1;;i++) {
			if(selenium.getText("//table[@id='phonelist']/tbody/tr["+i+"]/td[1]/a").equalsIgnoreCase(glo.getPid()+glo.getPid())) {
				selenium.click("//table[@id='phonelist']/tbody/tr["+i+"]/td[1]/a");
				break;
			}
		}	
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Edit Paging Phone"));
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='sidecontent']/div[2]/ol/li[5]/strong/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Pageable Phones", selenium.getTitle());
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", glo.getPid()+glo.getRecordNumber5());
		selenium.type("phoneextension", glo.getRecordNumber5());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getPid()+glo.getRecordNumber4()));
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("phonename", glo.getPid()+glo.getRecordNumber4());
		selenium.type("phoneextension", glo.getRecordNumber4());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Duplicated extension "+glo.getRecordNumber4()+".."));
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		selenium.chooseCancelOnNextConfirmation();
		selenium.click("//table[@id='phonelist']/tbody/tr/td[5]/a[2]");
		assertTrue(selenium.isTextPresent(glo.getPid()+glo.getRecordNumber5()));
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//table[@id='phonelist']/tbody/tr/td[5]/a[2]");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(glo.getPid()+glo.getRecordNumber5()));
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//table[@id='phonelist']/tbody/tr/td[5]/a[2]");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(glo.getPid()+glo.getRecordNumber4()));
	}
	
	public static void deleteManageMaps(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_paging_config_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_location_map");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Floor Plans", selenium.getTitle());
		CommonTestFunction.commonSearch(selenium, glo.getMid());
		selenium.chooseOkOnNextConfirmation();
		manageMapsDelete(selenium, glo.getMid());
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent(glo.getMid()));
	}
	
	public static void managePcs(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_computer");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_computer_group");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Desktop Clients Groups", selenium.getTitle());
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("pcname", glo.getGid());
		selenium.type("description", glo.getText());
		selenium.type("namefilter", glo.getPc1());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getGid()));
		CommonTestFunction.commonSearch(selenium, glo.getGid());
		assertTrue(selenium.isTextPresent(glo.getGid()));
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage Desktop Clients Groups", selenium.getTitle());
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("pcname", glo.getGid()+glo.getGid());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getGid()+glo.getGid()));
		selenium.chooseCancelOnNextConfirmation();
		commonDelete(selenium, glo.getGid()+glo.getGid(), "zonelist", 5);
		assertTrue(selenium.isTextPresent(glo.getGid()+glo.getGid()));
		selenium.chooseOkOnNextConfirmation();
		commonDelete(selenium, glo.getGid()+glo.getGid(), "zonelist", 5);
		assertFalse(selenium.isTextPresent(glo.getGid()+glo.getGid()));
		selenium.click("//div[@id='sidenav']/div[2]/ul/li[1]/a/strong");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void manageTasks(Selenium selenium, StoreGlobalVariables glo) throws Exception {
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
		selenium.click("hdr_browse_task");
		selenium.waitForPageToLoad("30000");
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage and run tasks", selenium.getTitle());
		selenium.click("createnew");
		selenium.waitForPageToLoad("30000");
		selenium.type("title", glo.getTid());
		selenium.type("description", glo.getText());
		selenium.type("importlocation", glo.getImportDirectory());
		selenium.click("submitCreate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getTid()));
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - Manage and run tasks", selenium.getTitle());
		selenium.click("link=edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("title", glo.getTid()+glo.getTid());
		selenium.click("submitUpdate");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(glo.getTid()+glo.getTid()));
		selenium.click("link=run");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The task is now running. When finished, Task Report will be displayed on the next page (refresh the page if needed)."));
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.commonSearch(selenium, glo.getTid());
		assertTrue(selenium.isTextPresent(glo.getTid()+glo.getTid()));
		selenium.click("link=View");
		selenium.waitForPageToLoad("30000");
		assertEquals("BlazeCast - View Task Report", selenium.getTitle());
		selenium.click("//div[@id='sidenav']/div[2]/ul/li[1]/a/strong");
		selenium.waitForPageToLoad("30000");
		CommonTestFunction.commonSearch(selenium, glo.getTid());
		assertTrue(selenium.isTextPresent(glo.getTid()));
		selenium.chooseCancelOnNextConfirmation();
		selenium.click("link=delete");
		commonDelete(selenium, glo.getTid(), "entitylist", 5);
		assertTrue(selenium.isTextPresent(glo.getTid()));
		selenium.chooseOkOnNextConfirmation();
		selenium.click("link=delete");
		selenium.waitForPageToLoad("30000");
		commonDelete(selenium, glo.getTid(), "entitylist", 5);
		assertFalse(selenium.isTextPresent(glo.getTid()));
	}
	
	/*
	 * Creat new user
	 */
	public static void PreConditions(Selenium selenium,String username,String password,String email,String firstname,String lastname,boolean isAdmin)
	{
		ClickAdminTab(selenium);
		selenium.click("hdr_create_user");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", username);
		selenium.type("password", password);
		selenium.type("passwordv", password);
		selenium.type("email", email);
		selenium.type("firstname", firstname);
		selenium.type("lastname", lastname);
        if(isAdmin)
        {
        	selenium.click("isadmin");
        }
		selenium.click("createUser");
		selenium.waitForPageToLoad("30000");
	}
	
	/*
	 * Remove User
	 */
	public static void RemoveUser(Selenium selenium,String username,boolean notLoginCreate)
	{
		ClickAdminTab(selenium);
		selenium.type("searchbox", username);
		selenium.click("searchsubmit");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=1;i<16;i++)
		{
			String usernameString=selenium.getText("//table[@id='userlist']/tbody/tr["+i+"]/td[1]");
			String nameString = selenium.getText("//table[@id='userlist']/tbody/tr["+i+"]/td[2]");
			if(username.equals(usernameString))
			{
				if(notLoginCreate)
				{
					selenium.click("//table[@id='userlist']/tbody/tr["+i+"]/td[4]/a");
					selenium.click("formSubmit");
					selenium.waitForPageToLoad("30000");
					selenium.click("message:nextpage");
					selenium.waitForPageToLoad("30000");
				}
				selenium.click("//table[@id='userlist']/tbody/tr["+i+"]/td[5]/a[2]");
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation().matches("^This will permanently delete user "+nameString+" from the system\\. Continue[\\s\\S]$"));
		        selenium.waitForPageToLoad("30000");
		        break;
			}
			if(i==15)
			{
				assertTrue("False, username exist.",false);
			}
		}
	}
	
	public static void ClickAdminTab(Selenium selenium)
	{
		selenium.click("hdr_admin_main");
		selenium.waitForPageToLoad("30000");
	}
	
}
