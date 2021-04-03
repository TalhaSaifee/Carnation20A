package com.testingShashtra1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synthesis.keyword.Keyword;



public class RegressionTest  
{
	@Test
	public void tc_02()
	{
	Keyword keyword=new Keyword();
		keyword.openBrowser("Chrome");
		keyword.launchurl("http://www.testingshastra.com/");
		keyword.click("a[href='http://testingshastra.com/pages/Assignments.html']","cssSelector");
		keyword.click("a[href='http://testingshastra.com/Assignments/First.html']","cssSelector");
		keyword.click("button#btn","cssSelector");
		
		keyword.switchToWindow("Second Window");
		
		keyword.click("button#close-btn","cssSelector");
		String actualmessage = keyword.getTextOfElement("body>p","cssSelector");

	Assert.assertEquals(actualmessage, "Congratulation ! You have scucessfully completed the assignment.");
	}
}
