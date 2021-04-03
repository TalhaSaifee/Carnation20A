package com.synthesis.keyword;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	
	WebDriver driver=null;
	
	public void openBrowser(String browserName)
	{
	switch (browserName)
	{
	case "Firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println("launching Firefox driver");
	break;
	case "Chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("launching chrome driver");
		
	break;
	case "IE":
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		System.out.println("launching ie driver");	
	case "Headless":
		driver=new HtmlUnitDriver();
    	
    	default:
    		
    		System.out.println("Invalid Brouser name"+browserName);	
    		break;
    		
	}
}
	public void launchurl(String url)
	{
	
	driver.get(url);
	System.out.println("Launching URL"+url);	
	}
	
	private WebElement getWebElement(String locator,String locatorType)
	{
		WebElement element=null;
		switch(locatorType)
		{
			case "xpath":
				element=driver.findElement(By.xpath(locator));
			       break;
			case "cssSelector":
				element=driver.findElement(By.cssSelector(locator));
				break;
			case "name":
				element= driver.findElement(By.name(locator));
		case "className":
			element= driver.findElement(By.xpath(locator));
			     break;
		case "id":
			
			element= driver.findElement(By.id(locator));
		
			
	
		        break;
     }
		return  element;
		
		
		
	}
	public void click(String locator,String locatorType)
	{
		getWebElement(locator,locatorType).click();
		
}
	public void sendKeys()
	{
		
	}
	public void enterText(String  locator,String locatorType,String text)
	{
		getWebElement(locator,locatorType).sendKeys(text);
	}
	public void switchToWindow(String windowTitle)
	{
		Set<String> allHandles=driver.getWindowHandles();
	 	for(String handle: allHandles  )
	 	{
	 		if(driver.switchTo().window(handle).getTitle().equalsIgnoreCase(windowTitle))
	 		{
	 	     break;
	 	    }
		
	       }
	
	   }
	public String getTextOfElement(String  locator,String locatorType) {
		// TODO Auto-generated method stub
		return getWebElement(locator,locatorType).getText();	
	}
	}



