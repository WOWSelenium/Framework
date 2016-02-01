package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
	
	String filterBy;
	FindByFilter selector; // to find the element through a selector type
	private WebDriver driver;
	private Element element;
		
	public Methods(WebDriver driver, Element element){
		this.driver = driver;
		this.element = element;
	}
	
	private WebDriver getDriver(){
		return this.driver;		
	}
	
	private Element getElement(){
		return this.element;
	}
	
	
	
	public void executeAction(){
		//Find what type of element is like: Table, button,link, textbox, dropdown, etc. 
		switch(element.getObjType().toString()){		
			case ("textBox"):
				workTextBox(this.getDriver(), this.getElement());
				break;
			case ("link"):
				workLink(this.getDriver(), this.getElement());
				break;
			case ("button"):
				workButton(this.getDriver(), this.getElement());
				break;
			case("dropDown"):
				workDropDown(this.getDriver(), this.getElement());
				break;
			case ("checkBox"):
				workCheckBox(this.getDriver(), this.getElement());
				break;
			case("radioButton"):
				workRadioBtn(this.getDriver(), this.getElement());
				break;
			case ("url"):
				openURL(this.getDriver(),element.getEleValue().toString());
				break;
		}
				
	}
	
	//Methods that a Text box is able to execute filter By
	private void workTextBox(WebDriver driver, Element element){
		
		filterBy = element.getLocatorType().toString();		
		
		switch(filterBy){
		case ("id"):
			if(selector.findById()){
				driver.findElement(By.id(element.getLocatorValue())).clear();					
				driver.findElement(By.id(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}
		// Object not found, what next?
			break;
		case ("name"):
			if(selector.findByName()){
				driver.findElement(By.name(element.getLocatorValue())).clear();
				driver.findElement(By.name(element.getLocatorValue())).sendKeys(element.getEleValue());
			}			
			break;
		case ("classname"):
			if(selector.findByClassName()){
				driver.findElement(By.className(element.getLocatorValue())).clear();					
				driver.findElement(By.className(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}			
			break;
		case ("linktext"):
			if(selector.findByLinkText()){
				driver.findElement(By.linkText(element.getLocatorValue())).clear();					
				driver.findElement(By.linkText(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}			
			break;
		case ("cssselector"):
			if(selector.findByCssSelector()){
				driver.findElement(By.cssSelector(element.getLocatorValue())).clear();					
				driver.findElement(By.cssSelector(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}			
			break;				
		case ("partiallinktext"):
			if(selector.findByPartialLinkText()){
				driver.findElement(By.partialLinkText(element.getLocatorValue())).clear();					
				driver.findElement(By.partialLinkText(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}			
			break;
		case ("tagname"):
			if(selector.findByTagName()){
				driver.findElement(By.tagName(element.getLocatorValue())).clear();					
				driver.findElement(By.tagName(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}			
			break;
		case ("xpath"):
			if(selector.findByXpath()){
				driver.findElement(By.xpath(element.getLocatorValue())).clear();					
				driver.findElement(By.xpath(element.getLocatorValue())).sendKeys(element.getEleValue());	
			}			
			break;
		}
	}
	
	private void workButton(WebDriver driver, Element element){
		filterBy = element.getLocatorType().toString();		
		
		switch(element.getLocatorType().toString()){
		case ("id"):
			if (selector.findById()){
				// Set the value to enter then execute the action
				driver.findElement(By.id(element.getLocatorValue())).click();			
			}
			break;
		// Need to update the rest of the calls
			
		case ("name"):
			if((new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver d){
		    		return driver.findElement(By.name(element.getLocatorValue())).isDisplayed();
		    	}	 
			}))driver.findElement(By.name(element.getLocatorValue())).click();				
			
			break;
		}// switch
	}
	
	private void workLink(WebDriver driver, Element element){
		switch(element.getLocatorType().toString()){
		case ("id"):
			if((new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver d){
		    		return driver.findElement(By.id(element.getLocatorValue())).isDisplayed();
		    	}	 
			})){			
					// Set the value to enter then execute the action
					driver.findElement(By.id(element.getLocatorValue())).click();										
			}
			break;
		case ("name"):
			if((new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver d){
		    		return driver.findElement(By.name(element.getLocatorValue())).isDisplayed();
		    	}	 
			})){					// Set the value to enter then execute the action
				driver.findElement(By.name(element.getLocatorValue())).click();												
			}
			break;
		case ("linkText"):
			if((new WebDriverWait (driver, 25)).until(new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver d){
		    		return driver.findElement(By.linkText(element.getLocatorValue())).isDisplayed();
		    	}	 
			})){					// Set the value to enter then execute the action
				driver.findElement(By.linkText(element.getLocatorValue())).click();												
			}
			break;
		}
	}
	
	private void workDropDown(WebDriver driver, Element element){

		filterBy = element.getLocatorType().toString();		
		
		switch(filterBy){
		case ("id"):
			if(selector.findById()){
				Select dropDownVal = new Select(driver.findElement(By.id(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());					
			}			
			break;
		case ("name"):
			if(selector.findByName()){
				Select dropDownVal = new Select(driver.findElement(By.name(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());					
			}			
			break;
		case ("classname"):
			if(selector.findByClassName()){
				Select dropDownVal = new Select(driver.findElement(By.className(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());						
			}			
			break;
		case ("linktext"):
			if(selector.findByLinkText()){
				Select dropDownVal = new Select(driver.findElement(By.linkText(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());						
			}			
			break;
		case ("cssselector"):
			if(selector.findByCssSelector()){
				Select dropDownVal = new Select(driver.findElement(By.cssSelector(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());					
			}			
			break;				
		case ("partiallinktext"):
			if(selector.findByPartialLinkText()){
				Select dropDownVal = new Select(driver.findElement(By.partialLinkText(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());						
			}			
			break;
		case ("tagname"):
			if(selector.findByTagName()){
				Select dropDownVal = new Select(driver.findElement(By.id(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());						
			}			
			break;
		case ("xpath"):
			if(selector.findByXpath()){
				Select dropDownVal = new Select(driver.findElement(By.id(element.getLocatorValue())));
				dropDownVal.selectByValue(element.getEleValue());						
			}			
			break;
		}
	}
	
	private void workCheckBox(WebDriver driver, Element element){
		switch(element.getLocatorType().toString()){
		case ("id"):
			
			break;
		case ("name"):
			
			break;
		case ("linkText"):
			
			break;
		}
	}
	
	private void workRadioBtn(WebDriver driver, Element element){
		switch(element.getLocatorType().toString()){
		case ("id"):
			
			break;
		case ("name"):
			
			break;
		case ("linkText"):
			
			break;
		}
	}
	
	private void openURL(WebDriver driver,String url){
		System.out.println("https://"+url);
		driver.get("https://"+url);
	}
	
	public void executeActionJS(WebDriver driver, Element element){
				
	}
	
	public int numberOfElements(){
		int amount=0;
		
		return amount;
	}

	/*
	public Element getElement() {
		return element;
	}


	public void setElement(Element element) {
		this.element = element;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	*/
	
}
