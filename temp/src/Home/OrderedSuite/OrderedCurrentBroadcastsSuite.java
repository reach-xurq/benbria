package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.CurrentBroadcasts.class
})

public class OrderedCurrentBroadcastsSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testCurrentBroadcastsGoToBroadcastSummaryPage",
				"testCurrentBroadcastsGoToHomePage"
		};
		return new OrderedTestSuite(Home.CurrentBroadcasts.class, order);
	}

}
