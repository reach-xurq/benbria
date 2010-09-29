package testCases;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import common.LoginCommonTestFunction;
import common.ReportCommonTestFunction;
import common.BroadcastCommonTestFunction;
import common.AdminCommonTestFunction;
import util.SeleniumFactory;
import util.StoreGlobalVariables;
import com.thoughtworks.selenium.Selenium;

public class Report{
	public static Selenium selenium;
	public static StoreGlobalVariables m_store; 
	public String bid;
	
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
		BroadcastCommonTestFunction.NewBroadcastSuperEmail(selenium,m_store.getBid(),m_store.getText(),m_store.getEmail(),m_store.getBid(),m_store.getText());
		LoginCommonTestFunction.ClickLogout(selenium);
	}
	
	@AfterClass
	public static void tearDownafterclass() throws Exception{
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		BroadcastCommonTestFunction.RemoveBroadcast(selenium, m_store.getBid());
		AdminCommonTestFunction.RemoveUser(selenium, m_store.getSa()+m_store.getUid(),false);
		AdminCommonTestFunction.RemoveUser(selenium, m_store.getUid(),false);	
		selenium.close();
	}
	
	@Before
	public void setUp() throws Exception{
		bid = m_store.getBid();
	}
	
	@After
	public void tearDown() throws Exception{
		LoginCommonTestFunction.ClickLogout(selenium);
	}
	
	@Test
	public void testSuperAdminTitle() throws Exception{
		System.out.println("Beginning test: testSuperAdminReportTitle");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		ReportCommonTestFunction.ClickReportTab(selenium);
		ReportCommonTestFunction.ClickSearchButton(selenium,bid);
		ReportCommonTestFunction.VerifySearchresults(selenium,bid);
		ReportCommonTestFunction.ClickTitleItem(selenium,bid);
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		assertTrue(selenium.isTextPresent("Detailed Report for "+bid));
		ReportCommonTestFunction.ClickLinkTab(selenium,"View Report Summary");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"Broadcast Progress");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"Completed Recipient Status");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickViewReportLink(selenium);
		assertTrue(selenium.isTextPresent("Browse Reports"));
		ReportCommonTestFunction.ClickLinkTab(selenium,"[summary]");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickViewReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"[detail]");
		assertTrue(selenium.isTextPresent("Detailed Report for "+bid));
		System.out.println("Completed test: testSuperAdminReportTitle");
	}
	@Test
	public void testAdministratorTitle() throws Exception{
		System.out.println("Beginning test: testSuperAdminReportTitle");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa()+m_store.getUid(), m_store.getAupd());
		ReportCommonTestFunction.ClickReportTab(selenium);
		ReportCommonTestFunction.ClickSearchButton(selenium,bid);
		ReportCommonTestFunction.VerifySearchresults(selenium,bid);
		ReportCommonTestFunction.ClickTitleItem(selenium,bid);
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		assertTrue(selenium.isTextPresent("Detailed Report for "+bid));
		ReportCommonTestFunction.ClickLinkTab(selenium,"View Report Summary");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"Broadcast Progress");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"Completed Recipient Status");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickViewReportLink(selenium);
		assertTrue(selenium.isTextPresent("Browse Reports"));
		ReportCommonTestFunction.ClickLinkTab(selenium,"[summary]");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickViewReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"[detail]");
		assertTrue(selenium.isTextPresent("Detailed Report for "+bid));
		System.out.println("Completed test: testSuperAdminReportTitle");
	}
	@Test
	public void testRigularUserTitle() throws Exception{
		System.out.println("Beginning test: testSuperAdminReportTitle");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getUid(), m_store.getRupd());
		ReportCommonTestFunction.ClickReportTab(selenium);
		ReportCommonTestFunction.ClickSearchButton(selenium,bid);
		ReportCommonTestFunction.VerifySearchresults(selenium,bid);
		ReportCommonTestFunction.ClickTitleItem(selenium,bid);
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		assertTrue(selenium.isTextPresent("Detailed Report for "+bid));
		ReportCommonTestFunction.ClickLinkTab(selenium,"View Report Summary");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"Broadcast Progress");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickDetailReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"Completed Recipient Status");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickViewReportLink(selenium);
		assertTrue(selenium.isTextPresent("Browse Reports"));
		ReportCommonTestFunction.ClickLinkTab(selenium,"[summary]");
		assertTrue(selenium.isTextPresent("Report Summary for "+bid));
		ReportCommonTestFunction.ClickViewReportLink(selenium);
		ReportCommonTestFunction.ClickLinkTab(selenium,"[detail]");
		assertTrue(selenium.isTextPresent("Detailed Report for "+bid));
		System.out.println("Completed test: testSuperAdminReportTitle");
	}

}
