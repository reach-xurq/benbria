/**
 * AdminTestSuite.java
 * Description: Admin test suit.
 * Comments: Used to test all Admin module test cases.
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
	                                                   
})

public class AdminTestSuite {	
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		new StoreGlobalVariables();
		SeleniumFactory.initSelenium(StoreGlobalVariables.browser);
		CommonTestFunction.testCaseInit();
		CommonTestFunction.perConditions();
	}

	@AfterClass public static void tearDownAfterClass() throws Exception {
		selenium.close();
	}
	
	public static Test suite() {
		return new JUnit4TestAdapter(AdminTestSuite.class);
	}
	
}
