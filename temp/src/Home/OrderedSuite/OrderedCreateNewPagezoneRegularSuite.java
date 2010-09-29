package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.CreateNewPagezoneRegular.class
})

public class OrderedCreateNewPagezoneRegularSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testPagezoneRegularGoToManagePagingGroupsPage",
				"testPagezoneRegularGoToHomePage"
		};
		return new OrderedTestSuite(Home.CreateNewPagezoneRegular.class, order);
	}

}
