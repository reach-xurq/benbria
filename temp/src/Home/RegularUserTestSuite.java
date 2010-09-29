package Home;

import static Util.SeleniumFactory.selenium;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import Util.CommonTestFunction;
import Util.SeleniumFactory;
import Util.StoreGlobalVariables;

@RunWith(Suite.class)
@SuiteClasses({
	Home.OrderedSuite.OrderedUsePreconfiguredBroadcastSuite.class,
	Home.OrderedSuite.OrderedCreateNewSuite.class,
	Home.OrderedSuite.OrderedCreateNewPagezoneRegularSuite.class,
	Home.OrderedSuite.OrderedReportingSuite.class,
	Home.OrderedSuite.OrderedContactsSuite.class,
	Home.OrderedSuite.OrderedCurrentBroadcastsSuite.class,
	Home.UpcomingBroadcasts.class
})

public class RegularUserTestSuite {
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		if (StoreGlobalVariables.homeFlag == 0) {
			new StoreGlobalVariables();
			SeleniumFactory.initSelenium(StoreGlobalVariables.browser);
			CommonTestFunction.testCaseInit();
			CommonTestFunction.perConditions();
		}
		CommonTestFunction.loginBehavior("user");
	}

	@AfterClass public static void tearDownAfterClass() throws Exception {
		CommonTestFunction.logoutBehavior();
		if (StoreGlobalVariables.homeFlag == 0) {
			CommonTestFunction.removeBroadcast();
			selenium.close();
		}
	}
	
	public static Test suite() {
		return new JUnit4TestAdapter(RegularUserTestSuite.class);
	}

}
