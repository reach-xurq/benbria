/**
 * HomeTestSuite.java
 * Description: Home test suit.
 * Comments: Used to test all Home module test cases.
 * JDK 1.6, JUnit 4.8.2
 */

import static Util.SeleniumFactory.selenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import Util.CommonTestFunction;
import Util.SeleniumFactory;
import Util.StoreGlobalVariables;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	Home.NewbroadcastForHome.class,
	Home.SuperAdminTestSuite.class,
	Home.AdministratorTestSuite.class,
	Home.RegularUserTestSuite.class
})

public class HomeTestSuite {	
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		new StoreGlobalVariables();
		StoreGlobalVariables.homeFlag = 1;
		SeleniumFactory.initSelenium(StoreGlobalVariables.browser);
		CommonTestFunction.testCaseInit();
		CommonTestFunction.perConditions();
	}

	@AfterClass public static void tearDownAfterClass() throws Exception {
		CommonTestFunction.removeBroadcast();
		selenium.close();
	}
	
	public static Test suite() {
		return new JUnit4TestAdapter(HomeTestSuite.class);
	}
	
}
