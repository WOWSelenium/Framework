package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindByFilter {

	private WebDriver driver;
	private Element element;
	
	public FindByFilter(WebDriver driver, Element element){
		this.driver = driver;
		this.element = element;		
	}
	
	public Boolean findById(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.id(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByName(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.name(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByClassName(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.className(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByCssSelector(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.cssSelector(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByLinkText(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.linkText(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByPartialLinkText(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.partialLinkText(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByTagName(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.tagName(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
	
	public Boolean findByXpath(){
		return (new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
	    		return driver.findElement(By.xpath(element.getLocatorValue())).isDisplayed();
	    	}	 
		});		
	}
}
