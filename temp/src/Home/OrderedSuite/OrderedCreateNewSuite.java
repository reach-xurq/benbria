package Home.OrderedSuite;

import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.gargoylesoftware.base.testing.OrderedTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	Home.CreateNew.class
})

public class OrderedCreateNewSuite {
	
	public static Test suite() {
		String[] order=new String[] {
				"testCreateNewGoToCreateMessagePage",
				"testCreateNewGoToCreateMessagePage_1",
				"testCreateNewGoToCreateMessagePage_2"
		};
		return new OrderedTestSuite(Home.CreateNew.class, order);
	}

}
