package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.Contacts.class
})

public class OrderedContactsSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testContactsManageContactsPage",
				"testContactsManageGroupsPage",
				"testContactsImportContactsPage",
				"testContactsContactInformationPage",
				"testContactsGroupInformationPage",
				"testContactsContactSearchSuccess",
				"testContactsGoToHomePage"
		};
		return new OrderedTestSuite(Home.Contacts.class, order);
	}

}
