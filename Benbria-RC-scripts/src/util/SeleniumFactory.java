/**
 * SeleniumFactory.java
 * Description: Selenium instance builder.
 * Comments: Used to generate the Selenium instance for test cases.
 * JDK 1.6, Selenium 1.0.3
 */

package util;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumFactory {
	
	/**
	 * Generate and return a Selenium instance
	 * @return 
	 * Selenium class instance
	 * @see com.thoughtworks.selenium.DefaultSelenium
	 */	
	public static Selenium getSeleniumInstance(String browser) {
		
		return new DefaultSelenium("127.0.0.1", 4444, browser, "http://192.168.215.37");
		
	}
	
}
