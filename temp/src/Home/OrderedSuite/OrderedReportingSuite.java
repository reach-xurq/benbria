package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.Reporting.class
})

public class OrderedReportingSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testReportingGoToReportsPage",
				"testReportingGoToReportsPage_1",
				"testReportingSearchSuccess",
				"testReportingGoToHomePage"
		};
		return new OrderedTestSuite(Home.Reporting.class, order);
	}

}
