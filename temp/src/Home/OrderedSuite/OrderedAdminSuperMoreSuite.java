package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.AdminSuperMore.class
})

public class OrderedAdminSuperMoreSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testAdminSuperMoreGoToLicensingPage",
				"testAdminSuperMoreGoToRecordGreetingPage"
		};
		return new OrderedTestSuite(Home.AdminSuperMore.class, order);
	}

}
