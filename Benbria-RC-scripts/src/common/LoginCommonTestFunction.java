package common;

import util.StoreGlobalVariables;
import com.thoughtworks.selenium.Selenium;

public class LoginCommonTestFunction {

	/**
	 * Complete login behavior
	 * @param username
	 * @param password
	 * Correct username and password to login.
	 * @return
	 * Assertion condition
	 */
	public static boolean loginBehavior(Selenium selenium, String type, StoreGlobalVariables glo) {
		String username, password, verify;
		if(type.equals("super")) {
			username = glo.getSa();
			password = glo.getSapd();
			verify = "Admin";
		}
		else if(type.equals("admin")) {
			username = glo.getSa()+glo.getUid();
			password = glo.getAupd();
			verify = glo.getCid()+glo.getSa()+" "+glo.getCid()+glo.getSa();
		}
		else {
			username = glo.getUid();
			password = glo.getRupd();
			verify = glo.getCid()+" "+glo.getCid();
		}
		selenium.type("username", username);
		selenium.type("password", password);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
		return selenium.isTextPresent("hello "+verify+"!");
	}
	
	public static void loginCustom(Selenium selenium, String username, String password) {
		selenium.type("username", username);
		selenium.type("password", password);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("30000");
	}
	
	/**
	 * Complete logout behavior
	 * @return
	 * Assertion condition
	 */
	public static void logoutBehavior(Selenium selenium) {
		selenium.click("logout");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void TypeUserName(Selenium selenium,String userName) {
		selenium.type("username", userName);
	}

	public static void TypePassword(Selenium selenium,String password) {
		selenium.type("password", password);
	}
	
	public static void ClickLogin(Selenium selenium) {
		selenium.click("login_submit");
	}
	
	public static void ClickLogout(Selenium selenium) {
		selenium.click("logout");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void LoginBlazeCast(Selenium selenium,String userName,String password){
		selenium.type("username", userName);
		selenium.type("password", password);
		selenium.click("login_submit");
		selenium.waitForPageToLoad("15000");
	}
	
	public static void GoMainPag(Selenium selenium)
	{
		selenium.click("hdr_home_link");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickEnglishLink(Selenium selenium){
		selenium.click("link=English");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickFrenchLink(Selenium selenium){;
		selenium.click("//form[@id='locale_form']/a[2]");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickForgotPassword(Selenium selenium){
		selenium.click("forgot_password");
		selenium.waitForPageToLoad("30000");		
	}
	
	public static void ClickCreateAnAccount(Selenium selenium)
	{
		selenium.click("create_account_link");
		selenium.waitForPageToLoad("30000");
	}

	public static void ClickChangePassword(Selenium selenium){
		selenium.click("changePassword");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickHere(Selenium selenium){
		selenium.click("message:nextpage");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickFeedBackLink(Selenium selenium)
	{
		selenium.click("feedback_link");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void TypeFeedbackInformation(Selenium selenium,String name,String email,String subject,String notes)
	{
		selenium.type("name", name);
		selenium.type("email", email);
		selenium.type("subject", subject);
		selenium.type("notes", notes);
	}
	
	public static void ClickFeedbackButton(Selenium selenium){
		selenium.click("feedback_btn");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickCancelButton(Selenium selenium){
		selenium.click("public_cancel_btn");
		selenium.waitForPageToLoad("30000");
	}
	
	/*
	 * Type information for textbox in Create new user account pag.
	    "username"
		"password"
		"passwordv"
		"email"
		"firstname"
		"lastname"
		"address1"
		"address2"
		"city"
		"state"
		"zipcode"
		"country"
		"notes"
	 */
	public static void TypeText(Selenium selenium,String textboxname,String value)
	{
		selenium.type(textboxname, value);
	}
	
	/*
	 * Type information for textbox in Create new user account pag.
	 * Home Phone : itemNumber = 1
	 * Work Phone : itemNumber = 2
	 * Mobile Phone: itemNumber = 3
	 * Email : itemNumber = 4
	 */
	public static void TypeText(Selenium selenium,String value,int row,int itemNumber)
	{
		selenium.click("ptype_h_"+(row-1));
		selenium.click("//table[@id='items']/tbody/tr["+row+"]/td/label["+itemNumber+"]");
		selenium.type("items:"+(row-1)+":pnumber", value);
		
	}
	
	/*
	 * Create an account
	 */
	public static void CreateAccount(Selenium selenium,String username,String password,String email,String firstname,
			String lastname,String address1,String address2,String city,String state,String zipcode,
			String country,String notes,String [][]pnumber)
	{
		selenium.click("create_account_link");
		selenium.waitForPageToLoad("30000");
		TypeText(selenium,"username",username);
		TypeText(selenium,"password",password);
		TypeText(selenium,"passwordv",password);
		TypeText(selenium,"email",email);
		TypeText(selenium,"firstname",firstname);
		TypeText(selenium,"lastname",lastname);
		TypeText(selenium,"address1",address1);
		TypeText(selenium,"address2",address2);
		TypeText(selenium,"city",city);
		TypeText(selenium,"state",state);
		TypeText(selenium,"zipcode",zipcode);
		TypeText(selenium,"country",country);
		TypeText(selenium,"notes",notes);
		for(int i=0;i<pnumber.length;i++)
		{
			selenium.click("ptype_h_"+i);
			selenium.click("//table[@id='items']/tbody/tr["+(i+1)+"]/td/label["+pnumber[i][0]+"]");
			selenium.type("items:"+i+":pnumber", pnumber[i][1]);
		}
		selenium.click("requestAccess");
		selenium.waitForPageToLoad("30000");
		if(selenium.isTextPresent("We have successfully received your request. You will be notified via email when your account is ready."))
		{
			GoMainPag(selenium);
		}
		else {
			System.out.println("Plase see,there are some error message");
		}
	}
	
	/*
	 * Click 'Submit request' and 'Cancel' button in  Create new user account pag.
	 */
	public static void Clickbutton(Selenium selenium,String buttonName)
	{
		if(buttonName.equals("Submit request"))
		{
			selenium.click("requestAccess");
			selenium.waitForPageToLoad("30000");
		}
		else if(buttonName.equals("Cancel"))
		{
        	selenium.click("cancel");
        	selenium.waitForPageToLoad("30000");
		}
		else {
			System.out.println("The specific button doesn't exist, please verify if your button name is correct!");
		}
	}	
	
}
