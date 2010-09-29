/**
 * SeleniumFactory.java
 * Description: Selenium instance builder.
 * Comments: Used to generate the Selenium instance for test cases.
 * JDK 1.6, Selenium 1.0.3
 */

package Util;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumFactory {

	public static Selenium selenium;
	
	/**
	 * Generate and return a Selenium instance
	 * @return 
	 * Selenium class instance
	 * @see com.thoughtworks.selenium.DefaultSelenium
	 */	
	public static void initSelenium(String browser) {
		selenium = new DefaultSelenium("localhost", 4444, browser, "http://192.168.215.37");
	}
	
}
