package utils;

public class Element {

	//private Locator locatorPair; initial design class, get replaced by the elements at first level
	// displayed below (locatorType & locatorValue)
	
	private String locatorType;
	private String locatorValue;
	
	private String inputValue;
	private String objType;
	
	
	//locator type: will have information of what locator type of the 8 available is used to identify the object 
	//locator value: represent the object value
	//inputValue: is the value to drive by data-driven
	//            is the value to enter for a text box control, drop down value to be select,
	//objType: is a description of the object that is to be handled in order to properly identify the action/method
	public String getLocatorType() {
		return locatorType;
	}
	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}
	public String getLocatorValue() {
		return locatorValue;
	}
	public void setLocatorValue(String locatorValue) {
		this.locatorValue = locatorValue;
	}
	public String getEleValue() {
		return inputValue;
	}
	public void setEleValue(String eltValue) {
		this.inputValue = eltValue;
	}
	public String getObjType() {
		return objType;
	}
	public void setObjType(String action) {
		this.objType = action;
	}
	
}
