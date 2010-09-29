package common;

import static org.junit.Assert.*;

import com.thoughtworks.selenium.*;

public class ReportCommonTestFunction {

	public static void ClickReportTab(Selenium selenium)
	{
		selenium.click("hdr_browse_report");
		selenium.waitForPageToLoad("30000");
	}
	
	/*
	 * Click SearchButton 
	 */
	public static void ClickSearchButton(Selenium selenium,String bidString)
	{
		selenium.type("searchbox", bidString);
		selenium.click("searchsubmit");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Click Title itemlink in the reports module
	 */
	public static void ClickTitleItem(Selenium selenium,String bidString)
	{
		selenium.click("link="+bidString);
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickDetailReportLink(Selenium selenium)
	{
		selenium.click("detail_report_link");
		selenium.waitForPageToLoad("30000");
	}
	
	public static void ClickViewReportLink(Selenium selenium)
	{
		selenium.click("hdr_report_list");
		selenium.waitForPageToLoad("30000");
	}
	
	/*
	 * eg: "link=View Report Summary"
	 * "link=Broadcast Progress"
	 * "link=Completed Recipient Status"
	 * "link=[summary]"
	 * "link=[detail]"
	 */
	public static void ClickLinkTab(Selenium selenium,String linkString)
	{
		selenium.click("link="+linkString);
		selenium.waitForPageToLoad("30000");
	}
	
	/*
	 * Verify search results is not null
	 */
	public static void VerifySearchresults(Selenium selenium,String bidString)
	{
		int m=0;
		for(int i=1;i<16;i++)
		{
			String titltText=selenium.getText("//table[@id='reportlist']/tbody/tr["+i+"]/td[1]/a");
			if(titltText.contains(bidString))
			{
				m++;
				System.out.println("Verify Success");
				break;
			}
		}
		if(m<1)
		{		
			assertTrue("Search Results no exist.", false);
		}
	}
}
