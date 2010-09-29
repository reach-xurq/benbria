/**
 * BroadcastTestSuite.java
 * Description: Broadcast test suit.
 * Comments: Used to test all Broadcast module test cases.
 * JDK 1.6, JUnit 4.8.2
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	
})

public class BroadcastTestSuite {	
	public static Test suite() {
		return new JUnit4TestAdapter(BroadcastTestSuite.class);
	}
}
