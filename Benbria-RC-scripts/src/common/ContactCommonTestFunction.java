package common;

import static org.junit.Assert.*;
import com.thoughtworks.selenium.Selenium;

public class ContactCommonTestFunction {
	
	public static void ClickContactsTab(Selenium selenium,String tabName)
	{
		if(tabName.equals("contacts"))
		{
			selenium.click("hdr_contact_main");
		}
		else if(tabName.equals("manage contacts"))
		{
			selenium.click("hdr_browse_contact");
		}
		else if(tabName.equals("manage groups"))
		{
			selenium.click("hdr_browse_group");
		}
		else if(tabName.equals("import contacts"))
		{
			selenium.click("hdr_import_contact");
		}
		else if(tabName.equals("create contact"))
		{
			selenium.click("hdr_create_contact");
		}
		else if(tabName.equals("create group"))
		{
			selenium.click("hdr_create_group");
		}
		else {
			selenium.click("cancel");
		}
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickSearch(Selenium selenium, String seachString)
	{
		selenium.type("searchbox", seachString);
		selenium.click("searchsubmit");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ClickViewLink(Selenium selenium,String username)
	{
		ClickContactsTab(selenium,"contacts");
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
			String firstnameString=selenium.getText("//table[@id='contactlist']/tbody/tr["+i+"]/td[3]/a");
			String lastnameString=selenium.getText("//table[@id='contactlist']/tbody/tr["+i+"]/td[2]/a");
			if(username.equals(firstnameString)||username.equals(lastnameString))
			{
				selenium.click("//table[@id='contactlist']/tbody/tr["+i+"]/td[5]/a");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selenium.click("//div[@id='alertbox']/a");
				assertEquals("editYou do not have permission to edit this contact", selenium.getText("//table[@id='contactlist']/tbody/tr["+i+"]/td[5]/span[1]"));
				assertEquals("deleteYou do not have permission to delete this contact", selenium.getText("//table[@id='contactlist']/tbody/tr["+i+"]/td[5]/span[2]"));
		        break;
			}
			if(i==15)
			{
				assertTrue("False, username exist.",false);
			}
		}
	}
	
	public static void ClickDeleteLink(Selenium selenium,String username)
	{
		ClickContactsTab(selenium,"contacts");
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
			String firstnameString=selenium.getText("//table[@id='contactlist']/tbody/tr["+i+"]/td[2]/a");
			String lastnameString=selenium.getText("//table[@id='contactlist']/tbody/tr["+i+"]/td[3]/a");
			if(username.equals(firstnameString)||username.equals(lastnameString))
			{
				selenium.click("//table[@id='contactlist']/tbody/tr["+i+"]/td[5]/a[3]");
				selenium.waitForPageToLoad("30000");
				if(firstnameString.equals("")||lastnameString.equals("")){
					assertTrue(selenium.getConfirmation().matches("^This will permanently delete "+firstnameString+""+lastnameString+" from the system\\. Continue[\\s\\S]$"));
				}
				else{
				    assertTrue(selenium.getConfirmation().matches("^This will permanently delete "+firstnameString+" "+lastnameString+" from the system\\. Continue[\\s\\S]$"));
				}
				break;
			}
			if(i==15)
			{
				assertTrue("False, username exist.",false);
			}
		}
	}
	/*
	 * Create a new contact
	 */
	public static void CreateANewContact(Selenium selenium,String firstname,String lastname,String address1,String address2,
			String city,String state,String zipcode,String country,String notes,String [][]pnumber,String buttonName)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"create contact");
		selenium.type("firstname",firstname);
		selenium.type("lastname",lastname);
		selenium.type("address1",address1);
		selenium.type("address2",address2);
		selenium.type("city",city);
		selenium.type("state",state);
		selenium.type("zipcode",zipcode);
		selenium.type("country",country);
		selenium.type("notes",notes);
		for(int i=0;i<pnumber.length;i++)
		{
			selenium.click("ptype_h_"+i);
			selenium.click("//table[@id='items']/tbody/tr["+(i+1)+"]/td/label["+pnumber[i][0]+"]");
			selenium.type("items:"+i+":pnumber", pnumber[i][1]);
		}
		if(buttonName.equals("Create"))
		{
			selenium.click("submitCreate");
			selenium.waitForPageToLoad("30000");

		}
		else if(buttonName.equals("Save and create"))
		{
			selenium.click("savenew");
			selenium.waitForPageToLoad("30000");

		}
		else if(buttonName.equals("Cancel")){
			selenium.click("cancel");
		}
		else{
			selenium.click("savenew");
		}
	}
	
	/*
	 * choose whether it's a home, work or mobile phone, or email address
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
	
	public static void AddNewGroup(Selenium selenium,String groupname,String description,String searchtext){
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"manage groups");
		selenium.click("addgroup");
		selenium.waitForPageToLoad("30000");
		selenium.type("groupname", groupname);
		selenium.type("description", description);
		selenium.type("searchbox", searchtext);
		selenium.click("searchsubmit");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(searchtext.length()!=0)
		{
			selenium.click("//table[@id='contactlist']/tbody/tr/td");
		}
		selenium.click("creategroup");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void RemoveimgButton(Selenium selenium,String groupname,String description,String []searchtext)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"create group");
		selenium.type("groupname", groupname);
		selenium.type("description", description);
		if(searchtext.length!=0)
		{
			for(int i=0;i<searchtext.length;i++)
			{
				selenium.type("searchbox", searchtext[i]);
				selenium.click("searchsubmit");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selenium.click("//table[@id='contactlist']/tbody/tr/td");
			}
		}
		selenium.click("//table[@id='group']/tbody/tr[1]/td/a/img");
		selenium.click("creategroup");
		selenium.waitForPageToLoad("30000");	
	}
	
	public static void CreatNewGroup(Selenium selenium,String groupname,String description,String []searchtext){
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"create group");
		selenium.type("groupname", groupname);
		selenium.type("description", description);
		if(searchtext.length!=0)
		{
			for(int i=0;i<searchtext.length;i++)
			{
				selenium.type("searchbox", searchtext[i]);
				selenium.click("searchsubmit");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j =1;;j++)
				{
					try {
						if(selenium.getText("//table[@id='contactlist']/tbody/tr["+j+"]/td").equals(searchtext[i]))
						{
							selenium.click("//table[@id='contactlist']/tbody/tr["+j+"]/td");
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
					} catch (Exception e) {
						assertTrue("Unable to find requested the group name", false);
					}
				}
			}
		}
		
		selenium.click("creategroup");
		selenium.waitForPageToLoad("30000");		
	}
	
	public static void EditGroup(Selenium selenium,String oldgroupName,String newgroupName,String clickButton)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"manage groups");
		for(int i=1;;i++)
		{
			try {
				if(selenium.getText("//table[@id='table1']/tbody/tr["+i+"]/td").equals(oldgroupName))
				{
					selenium.click("//table[@id='table1']/tbody/tr["+i+"]/td");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selenium.click("editgroup");
					selenium.waitForPageToLoad("30000");
					selenium.type("groupname", newgroupName);
					if(clickButton.equals("Save"))
					{
						System.out.println("fdsasdfa");
						selenium.click("savegroup");
					}
					else if(clickButton.equals("Cancel"))
					{
						selenium.click("cancel");
					}
					selenium.waitForPageToLoad("30000");
					System.out.println("fdsasdfa");
					break;
				}
			} catch (Exception e) {
				assertTrue("Unable to find requested the group name", false);
			}
		}
		
	}
	
	public static void Removegroup(Selenium selenium,String groupName)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"manage groups");
		for(int i=1;;i++)
		{
			try {
				if(selenium.getText("//table[@id='table1']/tbody/tr["+i+"]/td").equals(groupName))
				{
					selenium.click("//table[@id='table1']/tbody/tr["+i+"]/td");
					selenium.click("removegroup");
					assertTrue(selenium.getConfirmation().matches("^This will permanently delete this group from the system\\. Continue[\\s\\S]$"));
					selenium.waitForPageToLoad("30000");
					break;
				}
			} catch (Exception e) {
				assertTrue("Unable to find requested the group name", false);
			}
		}
	}
	
	public static void ClickGroupCancelbutton(Selenium selenium)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"create group");
		selenium.click("cancel");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickmanagegroupsEditbutton(Selenium selenium,String groupName,String newFirstname)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"manage groups");
		if(groupName.length()!=0)
		{
			for(int i=1;;i++)
			{
				try {
					if(selenium.getText("//table[@id='table1']/tbody/tr["+i+"]/td").equals(groupName))
					{
						selenium.click("//table[@id='table1']/tbody/tr["+i+"]/td");
						selenium.click("editcontact");
						selenium.waitForPageToLoad("30000");
						selenium.type("firstname",newFirstname);
						selenium.click("submitUpdate");
						selenium.waitForPageToLoad("30000");
						break;
					}
				} catch (Exception e) {
					assertTrue("Unable to find requested the group name", false);
				}
			}
		}
		else if(groupName.length()==0)
		{
			selenium.click("editcontact");
			selenium.waitForPageToLoad("30000");
		}
	}
	
	public static void ManageGroupRemoveContact(Selenium selenium,String groupName)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"manage groups");
		if(groupName.length()!=0)
		{
			for(int i=1;;i++)
			{
				try {
					if(selenium.getText("//table[@id='table1']/tbody/tr["+i+"]/td").equals(groupName))
					{
						selenium.click("//table[@id='table1']/tbody/tr["+i+"]/td");
						selenium.click("editcontact");
						selenium.waitForPageToLoad("30000");
						selenium.click("removeContact");
						assertTrue(selenium.getConfirmation().matches("^This will permanently delete this contact from the system\\. Continue[\\s\\S]$"));
						selenium.waitForPageToLoad("30000");
						break;
					}
				} catch (Exception e) {
					assertTrue("Unable to find requested the group name", false);
				}
			}
		}
	}
	
	public static void Verifymanagegroupsedit(Selenium selenium,String groupName,String newFirstname)
	{
		ClickContactsTab(selenium,"contacts");
		ClickContactsTab(selenium,"manage groups");
		if(groupName.length()!=0)
		{
			for(int i=1;;i++)
			{
				try {
					if(selenium.getText("//table[@id='table1']/tbody/tr["+i+"]/td").equals(groupName))
					{
						selenium.click("//table[@id='table1']/tbody/tr["+i+"]/td");
						assertTrue(selenium.isTextPresent(newFirstname));
						break;
					}
				} catch (Exception e) {
					assertTrue("Unable to find requested the group name", false);
				}
			}
		}
	}
	
	public static void ManageGroupAddUserAccount(Selenium selenium,String username,String password,String email)
	{
		selenium.click("editcontact");
		selenium.waitForPageToLoad("30000");
		selenium.click("submitConvert");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", username);
		selenium.type("password", password);
		selenium.type("passwordv", password);
		selenium.type("email", "${email}");
		selenium.click("createUser");
		selenium.waitForPageToLoad("30000");
		selenium.click(email);
		selenium.waitForPageToLoad("30000");
	}
	
	public static String LongString()
	{
		String longString="";
		for(int i=1;i<260;i++)
		{
			String m="m";
			longString=longString+m;
		}
		return longString;
	}
}
