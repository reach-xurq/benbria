package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.UsePreconfiguredBroadcast.class
})

public class OrderedUsePreconfiguredBroadcastSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testPreBroadcastGoToBroadcastSummaryPage",
				"testPreBroadcastGoToPreconfiguredBroadcastsPage",
				"testPreBroadcastSearchSuccess",
				"testPreBroadcastGoToHomePage"
		};
		return new OrderedTestSuite(Home.UsePreconfiguredBroadcast.class, order);
	}

}
