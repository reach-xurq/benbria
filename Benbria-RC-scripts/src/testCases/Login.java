package testCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.thoughtworks.selenium.*;
import common.AdminCommonTestFunction;
import common.LoginCommonTestFunction;
import util.SeleniumFactory;
import util.StoreGlobalVariables;

public class Login{
	
	public static Selenium selenium;
	public static StoreGlobalVariables m_store; 

	@BeforeClass
	public static void setUpbeforeclass() throws Exception{
		m_store = new StoreGlobalVariables();
		selenium = SeleniumFactory.getSeleniumInstance(m_store.getBrowser());
		selenium.start();
		selenium.open("/blazecast/login.jsf");
		selenium.windowMaximize();
	}
	
	@AfterClass
	public static void tearDownafterclass() throws Exception{
		selenium.close();
	}
	
	@Before
	public void setUp() throws Exception{
		LoginCommonTestFunction.GoMainPag(selenium);
		
	}
	@After
	public void tearDown() throws Exception{
		
	}
	
	/**
	 * Test login with empty username and passowrd
	 * @throws Exception
	 */

	@Test
	public void testLoginNull() throws Exception
	{
		System.out.println("Beginning test: testLoginNull");
		LoginCommonTestFunction.ClickLogin(selenium);
		assertEquals("Required", selenium.getText("//div[@id='login']/div[2]/div[1]/span"));
		assertEquals("Required", selenium.getText("//div[@id='login']/div[2]/div[2]/span"));
		System.out.println("Completed test: testLoginNull");
	}
	/**
	 * Test login with invalid character input
	 * Test data: username=${uid}, password="admin"
	 * @throws Exception
	 */

	@Test
	public void testInputInvalid() throws Exception{
		System.out.println("Beginning test: testInputInvalid");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getIllegalSignal(), m_store.getSapd());
		String errorString = "Username can only contain numbers, letters, period (.), underscore (_) and dash (-), please try again.";
		assertEquals(errorString, selenium.getText("//div[@id='login']/div[2]/div[1]/span"));
		System.out.println("Completed test: testInputInvalid");
	}
	/**
	 * Test login with wrong password
	 * Test data: username="admin", password is a random num
	 * @throws Exception
	 */

	@Test
	public void testLoginFailWithWrongPassword() throws Exception{
		System.out.println("Beginning test: testLoginFailWithWrongPassword");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getUid());
		String errorString = "Login Failed. Please verify your username and password and try again";
		assertEquals(errorString, selenium.getText("//div[@id='login']/div[2]/ul/li"));
		System.out.println("Completed test: testLoginFailWithWrongPassword");
	}
	/**
	 * Test login with wrong username
	 * Test data: username="aadmin", password="admin"
	 * @throws Exception
	 */

	@Test
	public void testLoginFailWithWrongUsername() throws Exception{
		System.out.println("Beginning test: testLoginFailWithWrongUsername");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getExtratext()+m_store.getSa(), m_store.getSa());
		String errorString = "Username \"aadmin\" does not exist, please try again";
		assertEquals(errorString, selenium.getText("//div[@id='login']/div[2]/ul/li"));
		System.out.println("Completed test: testLoginFailWithWrongUsername");
	}
	/**
	 * Test login with too long username
	 * Test data: a too long username, password="admin"
	 * @throws Exception
	 */

	@Test
	public void testLoginFailWithLongUsername() throws Exception {
		System.out.println("Beginning test: testLoginFailWithLongUsername");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getText()+m_store.getText()+m_store.getText()+m_store.getText()+m_store.getText()+m_store.getText(), m_store.getSapd());
		String errorString = "username: Validation Error: Value is greater than allowable maximum of '25'";
		assertEquals(errorString, selenium.getText("//div[@id='login']/div[2]/div[1]/span"));
		System.out.println("Completed test: testLoginFailWithLongUsername");
	}
	/**
	 * Test login with too long password
	 * Test data: a too long password, username="admin"
	 * @throws Exception
	 */

	@Test
	public void testLoginFailWithLongPassword() throws Exception{
		System.out.println("Beginning test: testLoginFailWithLongPassword");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa() ,m_store.getText()+m_store.getText()+m_store.getText()+m_store.getText()+m_store.getText()+m_store.getText());
		String errorString = "password: Validation Error: Value is greater than allowable maximum of '25'";
		assertEquals(errorString, selenium.getText("//div[@id='login']/div[2]/div[2]/span"));
		System.out.println("Completed test: testLoginFailWithLongPassword");
	}
	/**
	 * Test login with too short username
	 * Test data: a too short username, password="admin"
	 * @throws Exception
	 */

	@Test
	public void testLoginFailWithShortUsername() throws Exception{
		System.out.println("Beginning test: testLoginFailWithShortUsername");
		LoginCommonTestFunction.TypeUserName(selenium, m_store.getExtratext());
		LoginCommonTestFunction.TypePassword(selenium, m_store.getSapd());
		LoginCommonTestFunction.ClickLogin(selenium);
		String errorString = "Too short, must be at least 3characters";
		assertEquals(errorString, selenium.getText("//div[@id='login']/div[2]/div[1]/span"));
		System.out.println("Completed test: testLoginFailWithShortUsername");
	}
	/**
	 * Test login with correct username and password
	 * Test logout function
	 * Test data: username="admin", password="admin"
	 * @throws Exception
	 */

	@Test
	public void testLoginSuccess() throws Exception{
		System.out.println("Beginning test: testLoginSuccess");
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		assertTrue(selenium.isTextPresent("hello Admin! (profile)  (log out)"));
		LoginCommonTestFunction.ClickLogout(selenium);
		assertTrue(selenium.isTextPresent("Welcome, please log in"));
		System.out.println("Completed test: testLoginSuccess");
	}
	
	/**
	 * Test to go to specified page
	 * @throws Exception
	 */

	@Test
	public void testGoToSpecifiedPage() throws Exception{
		System.out.println("Beginning test: testGoToSpecifiedPage");
		LoginCommonTestFunction.ClickFrenchLink(selenium);
		assertTrue(selenium.isTextPresent("Bienvenue, veuillez vous identifier"));
		LoginCommonTestFunction.ClickEnglishLink(selenium);
		assertTrue(selenium.isTextPresent("Welcome, please log in"));
		System.out.println("Completed test: testGoToSpecifiedPage");
	}

	
	@Test
	public void testForgetPassword() throws Exception{
		System.out.println("Beginning test: testForgetPassword");
		LoginCommonTestFunction.ClickForgotPassword(selenium);
		selenium.click("changePassword");
		assertEquals("Required", selenium.getText("//form[@id='message']/fieldset/ol/li[1]/span"));
		LoginCommonTestFunction.TypeText(selenium,"email",m_store.getText());
		selenium.click("changePassword");
		assertEquals("Invalid email address", selenium.getText("//form[@id='message']/fieldset/ol/li[1]/span"));
		LoginCommonTestFunction.TypeText(selenium,"email","2323"+m_store.getEmail());
		LoginCommonTestFunction.ClickChangePassword(selenium);
		assertEquals("The email address you entered is not in the system.", selenium.getText("//form[@id='message']/ul/li"));
		LoginCommonTestFunction.TypeText(selenium,"email",m_store.getEmail());
		LoginCommonTestFunction.ClickChangePassword(selenium);
		LoginCommonTestFunction.ClickHere(selenium);
		assertEquals("BlazeCast - Login", selenium.getTitle());
		System.out.println("Completed test: testForgetPassword");
	}
	

	@Test
	public void testFeedback() throws Exception{
		System.out.println("Beginning test: testFeedback");
		LoginCommonTestFunction.ClickFeedBackLink(selenium);
		LoginCommonTestFunction.ClickCancelButton(selenium);
		assertTrue(selenium.isTextPresent("Welcome, please log in"));
		LoginCommonTestFunction.ClickFeedBackLink(selenium);
		LoginCommonTestFunction.TypeFeedbackInformation(selenium, m_store.getSa(), m_store.getEmail(), m_store.getText(), m_store.getText());
		LoginCommonTestFunction.ClickFeedbackButton(selenium);
		assertEquals("Thank you for sending us your feedback.", selenium.getText("//ul[@id='message:globalmsg']/li"));
		LoginCommonTestFunction.ClickHere(selenium);
		assertTrue(selenium.isTextPresent("Welcome, please log in"));
		System.out.println("Completed test: testFeedback");
	}
	
	@Test
	public void testCreateAccount() throws Exception{
		System.out.println("Beginning test: testCreateAccount");
		String[][]pumber={{"1",m_store.getCode()},{"3",m_store.getCode()}};
		LoginCommonTestFunction.ClickCreateAnAccount(selenium);
		assertEquals("Create new user account", selenium.getText("//form[@id='user']/h1"));
		LoginCommonTestFunction.Clickbutton(selenium,"Cancel");
		assertEquals("Welcome, please log in", selenium.getText("//div[@id='login']/div[2]/h1"));
		LoginCommonTestFunction.CreateAccount(selenium,m_store.getUid(),m_store.getRupd(),m_store.getEmail(),m_store.getCid(),
				m_store.getCid(),m_store.getText(),m_store.getText(),m_store.getText(),m_store.getText(),
				m_store.getCode(),m_store.getText(),m_store.getText(),pumber);
		assertEquals("Duplicated contact method", selenium.getText("//table[@id='items']/tbody/tr[2]/td/span"));
		LoginCommonTestFunction.TypeText(selenium,m_store.getRecordNumber2(),2,3);
		LoginCommonTestFunction.Clickbutton(selenium,"Submit request");
		assertEquals("Invalid cell phone number", selenium.getText("//table[@id='items']/tbody/tr[2]/td/span"));
		LoginCommonTestFunction.TypeText(selenium,m_store.getRecordNumber1()+m_store.getRecordNumber3(),2,3);
		LoginCommonTestFunction.TypeText(selenium,m_store.getBadEmail(),3,4);
		selenium.click("requestAccess");
		assertEquals("Invalid number or email", selenium.getText("//table[@id='items']/tbody/tr[3]/td/span"));
		LoginCommonTestFunction.TypeText(selenium,m_store.getEmail(),3,4);
		LoginCommonTestFunction.Clickbutton(selenium,"Submit request");
		assertTrue(selenium.isTextPresent("We have successfully received your request. You will be notified via email when your account is ready."));
		LoginCommonTestFunction.GoMainPag(selenium);
		LoginCommonTestFunction.LoginBlazeCast(selenium, m_store.getSa(), m_store.getSapd());
		AdminCommonTestFunction.RemoveUser(selenium,m_store.getUid(),true);
		LoginCommonTestFunction.ClickLogout(selenium);
		System.out.println("Completed test: testCreateAccount");
	}
}
