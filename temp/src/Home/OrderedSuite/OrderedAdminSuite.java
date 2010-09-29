package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.Admin.class
})

public class OrderedAdminSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testAdminGoToHomePage",
				"testAdminGoToManageUsersPage",
				"testAdminGoToUserInformationPage",
				"testAdminGoToHomePage_1",
				"testAdminGoToManagePagingPage",
				"testAdminGoToHomePage_2"
		};
		return new OrderedTestSuite(Home.Admin.class, order);
	}

}
