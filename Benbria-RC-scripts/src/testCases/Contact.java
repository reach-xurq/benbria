package testCases;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import util.SeleniumFactory;
import util.StoreGlobalVariables;
import com.thoughtworks.selenium.Selenium;
import common.AdminCommonTestFunction;
import common.ContactCommonTestFunction;
import common.LoginCommonTestFunction;

public class Contact{
	
	public static Selenium selenium;
	public static StoreGlobalVariables m_store; 
	public String [][] Nullpnumber={{"1",""}};
	public String [][] pnumber={{"1",m_store.getRecordNumber1()},{"3",m_store.getCode()},{"4",m_store.getEmail()}};
	
	@BeforeClass
	public static void setUpbeforeclass() throws Exception{
		m_store = new StoreGlobalVariables(); 
		selenium = SeleniumFactory.getSeleniumInstance(m_store.getBrowser());
		selenium.start();
		selenium.open("/blazecast/login.jsf");
		selenium.windowMaximize();
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		AdminCommonTestFunction.PreConditions(selenium, m_store.getUid(), m_store.getRupd(), m_store.getEmail(), m_store.getCid(), m_store.getCid(), false);
		AdminCommonTestFunction.PreConditions(selenium, m_store.getSa()+m_store.getUid(), m_store.getAupd(), m_store.getEmail(), m_store.getCid()+m_store.getSa(),m_store.getCid()+m_store.getSa(), true);
		LoginCommonTestFunction.ClickLogout(selenium);
		
	}
	
	@AfterClass
	public static void tearDownafterclass() throws Exception{
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		AdminCommonTestFunction.RemoveUser(selenium, m_store.getSa()+m_store.getUid(),false);
		AdminCommonTestFunction.RemoveUser(selenium, m_store.getUid(),false);	
		selenium.close();
	}
	
	@Before
	public void setUp() throws Exception{
		
	}
	@After
	public void tearDown() throws Exception{
		LoginCommonTestFunction.ClickLogout(selenium);
	}
	
	@Test
	public void testContactLoginSuperAdmin()
	{
		System.out.println("Beginning test: testContactLoginSuperAdmin");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		assertTrue(selenium.isTextPresent("hello Admin!"));
		ContactCommonTestFunction.ClickViewLink(selenium,m_store.getCid()+m_store.getSa());
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getText(), "", "", "", "", "", "", "", "", Nullpnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getText());
		ContactCommonTestFunction.CreateANewContact(selenium, "", m_store.getCid()+m_store.getText(), "", "", "", "", "", "", "", Nullpnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getText());
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber1(), m_store.getCid()+m_store.getRecordNumber1(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				ContactCommonTestFunction.LongString(), pnumber, " ");
		
		assertEquals("The number of characters cannot exceed 255 characters\nPlease shorten by 4 characters", selenium.getText("//form[@id='contact']/div[1]/fieldset[3]/span"));
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber1(), m_store.getCid()+m_store.getRecordNumber1(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				m_store.getText(), pnumber, "Save and create");
		
		assertTrue(selenium.isTextPresent("Successfully created contact \""+m_store.getCid()+m_store.getRecordNumber1()+" "+m_store.getCid()+m_store.getRecordNumber1()+"\". Create another contact using the form below."));
		
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getRecordNumber1());
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber2(), m_store.getCid()+m_store.getRecordNumber2(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				m_store.getText(), pnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getRecordNumber2());
		System.out.println("Completed test: testContactLoginSuperAdmin");
	}
	
	@Test
	public void testGroupLoginSuperAdmin()
	{
	    System.out.println("Beginning test: testContactLoginSuperAdmin");
	    LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		assertTrue(selenium.isTextPresent("hello Admin!"));
		
		ContactCommonTestFunction.ClickGroupCancelbutton(selenium);
		assertEquals("BlazeCast - Manage contacts", selenium.getTitle());
		ContactCommonTestFunction.AddNewGroup(selenium,m_store.getGid()+m_store.getText(),"","");
		ContactCommonTestFunction.ClickmanagegroupsEditbutton(selenium,"","");
		assertEquals("Unable to find requested object. Please go back to the home page and try again.", selenium.getText("//ul[@id='globalmsg']/li"));
		ContactCommonTestFunction.AddNewGroup(selenium,m_store.getGid()+m_store.getText(),"",m_store.getCid()+m_store.getSa()+" "+m_store.getCid()+m_store.getSa());
		assertTrue(selenium.isTextPresent("The group name, "+m_store.getGid()+m_store.getText()+", is already in use. Please try a different name."));
		ContactCommonTestFunction.Removegroup(selenium,m_store.getGid()+m_store.getText());
		//assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getText()));
		
		String [] searchtext ={m_store.getCid()+m_store.getSa()+" "+m_store.getCid()+m_store.getSa(),m_store.getCid()+" "+m_store.getCid()};
		ContactCommonTestFunction.RemoveimgButton(selenium,m_store.getGid(),m_store.getText(),searchtext);
		assertFalse(selenium.isTextPresent(m_store.getCid()+m_store.getSa()));
		
		String [] searchtextStrings = {m_store.getCid()+" "+m_store.getCid()};
		ContactCommonTestFunction.CreatNewGroup(selenium,m_store.getGid(),m_store.getText(),searchtextStrings);
		assertEquals("The group name, "+m_store.getGid()+", is already in use. Please try a different name.", selenium.getText("//ul[@id='globalmsg']/li"));
		ContactCommonTestFunction.CreatNewGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getText(),searchtextStrings);
		
		ContactCommonTestFunction.EditGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getGid()+m_store.getRecordNumber1(),"Cancel");
		assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		ContactCommonTestFunction.EditGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getGid()+m_store.getRecordNumber1(),"Save");
		assertTrue(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		ContactCommonTestFunction.Removegroup(selenium, m_store.getGid()+m_store.getRecordNumber1());
		assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		
		ContactCommonTestFunction.ClickmanagegroupsEditbutton(selenium,m_store.getGid(),m_store.getCid()+m_store.getCid());
		/*
		Contacts.Verifymanagegroupsedit(selenium,m_store.getGid(),m_store.getCid()+m_store.getCid());
		Contacts.ManageGroupAddUserAccount(selenium,m_store.getUid()+m_store.getRecordNumber1(),m_store.getRecordNumber1(),m_store.getEmail());
		assertEquals(m_store.getUid()+m_store.getRecordNumber1(), selenium.getText("//table[@id='userlist']/tbody/tr[1]/td[1]"));
		
		Contacts.ManageGroupRemoveContact(selenium,m_store.getGid());
		Contacts.Removegroup(selenium,m_store.getGid());
		*/
		System.out.println("Completed test: testContactLoginSuperAdmin");
		
	}
	
	@Test
	public void testContactLoginAdmin()
	{
		System.out.println("Beginning test: testContactLoginSuperAdmin");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa()+m_store.getUid(), m_store.getAupd());
		ContactCommonTestFunction.ClickViewLink(selenium,m_store.getCid()+m_store.getSa());
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getText(), "", "", "", "", "", "", "", "", Nullpnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getText());
		ContactCommonTestFunction.CreateANewContact(selenium, "", m_store.getCid()+m_store.getText(), "", "", "", "", "", "", "", Nullpnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getText());
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber1(), m_store.getCid()+m_store.getRecordNumber1(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				ContactCommonTestFunction.LongString(), pnumber, " ");
		
		assertEquals("The number of characters cannot exceed 255 characters\nPlease shorten by 4 characters", selenium.getText("//form[@id='contact']/div[1]/fieldset[3]/span"));
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber1(), m_store.getCid()+m_store.getRecordNumber1(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				m_store.getText(), pnumber, "Save and create");
		
		assertTrue(selenium.isTextPresent("Successfully created contact \""+m_store.getCid()+m_store.getRecordNumber1()+" "+m_store.getCid()+m_store.getRecordNumber1()+"\". Create another contact using the form below."));
		
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getRecordNumber1());
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber2(), m_store.getCid()+m_store.getRecordNumber2(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				m_store.getText(), pnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getRecordNumber2());
		System.out.println("Completed test: testContactLoginSuperAdmin");
	}
	
	@Test
	public void testGroupLoginAdmin()
	{
	    System.out.println("Beginning test: testContactLoginSuperAdmin");
	    LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa()+m_store.getUid(), m_store.getAupd());
		
		ContactCommonTestFunction.ClickGroupCancelbutton(selenium);
		assertEquals("BlazeCast - Manage contacts", selenium.getTitle());
		ContactCommonTestFunction.AddNewGroup(selenium,m_store.getGid()+m_store.getText(),"","");
		ContactCommonTestFunction.ClickmanagegroupsEditbutton(selenium,"","");
		assertEquals("Unable to find requested object. Please go back to the home page and try again.", selenium.getText("//ul[@id='globalmsg']/li"));
		ContactCommonTestFunction.AddNewGroup(selenium,m_store.getGid()+m_store.getText(),"",m_store.getCid()+m_store.getSa()+" "+m_store.getCid()+m_store.getSa());
		assertTrue(selenium.isTextPresent("The group name, "+m_store.getGid()+m_store.getText()+", is already in use. Please try a different name."));
		ContactCommonTestFunction.Removegroup(selenium,m_store.getGid()+m_store.getText());
		//assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getText()));
		
		String [] searchtext ={m_store.getCid()+m_store.getSa()+" "+m_store.getCid()+m_store.getSa(),m_store.getCid()+" "+m_store.getCid()};
		ContactCommonTestFunction.RemoveimgButton(selenium,m_store.getGid(),m_store.getText(),searchtext);
		assertFalse(selenium.isTextPresent(m_store.getCid()+m_store.getSa()));
		
		String [] searchtextStrings = {m_store.getCid()+" "+m_store.getCid()};
		ContactCommonTestFunction.CreatNewGroup(selenium,m_store.getGid(),m_store.getText(),searchtextStrings);
		assertEquals("The group name, "+m_store.getGid()+", is already in use. Please try a different name.", selenium.getText("//ul[@id='globalmsg']/li"));
		ContactCommonTestFunction.CreatNewGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getText(),searchtextStrings);
		
		ContactCommonTestFunction.EditGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getGid()+m_store.getRecordNumber1(),"Cancel");
		assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		ContactCommonTestFunction.EditGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getGid()+m_store.getRecordNumber1(),"Save");
		assertTrue(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		ContactCommonTestFunction.Removegroup(selenium, m_store.getGid()+m_store.getRecordNumber1());
		assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		
		ContactCommonTestFunction.ClickmanagegroupsEditbutton(selenium,m_store.getGid(),m_store.getCid()+m_store.getCid());
		/*
		Contacts.Verifymanagegroupsedit(selenium,m_store.getGid(),m_store.getCid()+m_store.getCid());
		Contacts.ManageGroupAddUserAccount(selenium,m_store.getUid()+m_store.getRecordNumber1(),m_store.getRecordNumber1(),m_store.getEmail());
		assertEquals(m_store.getUid()+m_store.getRecordNumber1(), selenium.getText("//table[@id='userlist']/tbody/tr[1]/td[1]"));
		
		Contacts.ManageGroupRemoveContact(selenium,m_store.getGid());
		Contacts.Removegroup(selenium,m_store.getGid());
		*/
		System.out.println("Completed test: testContactLoginSuperAdmin");
		
	}
	
	@Test
	public void testContactLoginRegularUser()
	{
		System.out.println("Beginning test: testContactLoginSuperAdmin");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getUid(), m_store.getRupd());

		ContactCommonTestFunction.ClickViewLink(selenium,m_store.getCid()+m_store.getSa());
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getText(), "", "", "", "", "", "", "", "", Nullpnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getText());
		ContactCommonTestFunction.CreateANewContact(selenium, "", m_store.getCid()+m_store.getText(), "", "", "", "", "", "", "", Nullpnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getText());
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber1(), m_store.getCid()+m_store.getRecordNumber1(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				ContactCommonTestFunction.LongString(), pnumber, " ");
		
		assertEquals("The number of characters cannot exceed 255 characters\nPlease shorten by 4 characters", selenium.getText("//form[@id='contact']/div[1]/fieldset[3]/span"));
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber1(), m_store.getCid()+m_store.getRecordNumber1(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				m_store.getText(), pnumber, "Save and create");
		
		assertTrue(selenium.isTextPresent("Successfully created contact \""+m_store.getCid()+m_store.getRecordNumber1()+" "+m_store.getCid()+m_store.getRecordNumber1()+"\". Create another contact using the form below."));
		
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getRecordNumber1());
		
		ContactCommonTestFunction.CreateANewContact(selenium, m_store.getCid()+m_store.getRecordNumber2(), m_store.getCid()+m_store.getRecordNumber2(), 
				m_store.getText(), m_store.getText(), m_store.getText(), m_store.getText(), m_store.getCode(), m_store.getText(), 
				m_store.getText(), pnumber, "Create");
		ContactCommonTestFunction.ClickDeleteLink(selenium, m_store.getCid()+m_store.getRecordNumber2());
		System.out.println("Completed test: testContactLoginSuperAdmin");
	}
	
	@Test
	public void testGroupLoginRegularUser()
	{
	    System.out.println("Beginning test: testContactLoginSuperAdmin");
	    LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getUid(), m_store.getRupd());
		
		ContactCommonTestFunction.ClickGroupCancelbutton(selenium);
		assertEquals("BlazeCast - Manage contacts", selenium.getTitle());
		ContactCommonTestFunction.AddNewGroup(selenium,m_store.getGid()+m_store.getText(),"","");
		ContactCommonTestFunction.ClickmanagegroupsEditbutton(selenium,"","");
		assertEquals("Unable to find requested object. Please go back to the home page and try again.", selenium.getText("//ul[@id='globalmsg']/li"));
		ContactCommonTestFunction.AddNewGroup(selenium,m_store.getGid()+m_store.getText(),"",m_store.getCid()+m_store.getSa()+" "+m_store.getCid()+m_store.getSa());
		assertTrue(selenium.isTextPresent("The group name, "+m_store.getGid()+m_store.getText()+", is already in use. Please try a different name."));
		ContactCommonTestFunction.Removegroup(selenium,m_store.getGid()+m_store.getText());
		//assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getText()));
		
		String [] searchtext ={m_store.getCid()+m_store.getSa()+" "+m_store.getCid()+m_store.getSa(),m_store.getCid()+" "+m_store.getCid()};
		ContactCommonTestFunction.RemoveimgButton(selenium,m_store.getGid(),m_store.getText(),searchtext);
		assertFalse(selenium.isTextPresent(m_store.getCid()+m_store.getSa()));
		
		String [] searchtextStrings = {m_store.getCid()+" "+m_store.getCid()};
		ContactCommonTestFunction.CreatNewGroup(selenium,m_store.getGid(),m_store.getText(),searchtextStrings);
		assertEquals("The group name, "+m_store.getGid()+", is already in use. Please try a different name.", selenium.getText("//ul[@id='globalmsg']/li"));
		ContactCommonTestFunction.CreatNewGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getText(),searchtextStrings);
		
		ContactCommonTestFunction.EditGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getGid()+m_store.getRecordNumber1(),"Cancel");
		assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		ContactCommonTestFunction.EditGroup(selenium,m_store.getGid()+m_store.getSa(),m_store.getGid()+m_store.getRecordNumber1(),"Save");
		assertTrue(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		ContactCommonTestFunction.Removegroup(selenium, m_store.getGid()+m_store.getRecordNumber1());
		assertFalse(selenium.isTextPresent(m_store.getGid()+m_store.getRecordNumber1()));
		
		ContactCommonTestFunction.ClickmanagegroupsEditbutton(selenium,m_store.getGid(),m_store.getCid()+m_store.getCid());
		/*
		Contacts.Verifymanagegroupsedit(selenium,m_store.getGid(),m_store.getCid()+m_store.getCid());
		Contacts.ManageGroupAddUserAccount(selenium,m_store.getUid()+m_store.getRecordNumber1(),m_store.getRecordNumber1(),m_store.getEmail());
		assertEquals(m_store.getUid()+m_store.getRecordNumber1(), selenium.getText("//table[@id='userlist']/tbody/tr[1]/td[1]"));
		
		Contacts.ManageGroupRemoveContact(selenium,m_store.getGid());
		Contacts.Removegroup(selenium,m_store.getGid());
		*/
		System.out.println("Completed test: testContactLoginSuperAdmin");
		
	}


}
