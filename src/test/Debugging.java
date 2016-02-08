package test;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Element;
import utils.InputData;
import utils.Methods;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

//import org.junit.AfterClass;



@RunWith(value = Parameterized.class)

public class Debugging {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static Element objMap;
	private static List<Element> list;
	
	private static String sourceFile = "C:\\Users\\opg7470\\workspace\\SeleniumWebApps\\InputSource\\sourceFile.csv";
	
	public Debugging(Element obj){
		Debugging.objMap = obj;
	}
	
	@SuppressWarnings("rawtypes")
	@Parameters	
	public static Collection testData() throws IOException {	
		Debugging.list = InputData.getTestData4Ele(sourceFile);
		return Debugging.list;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/* code for using IE */
		/*File file = new File("C:/Selenium/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();*/

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get("https://test2.mywoodmen.org/MyWoodmen/Login/login.cfm");
        // TEST
        //driver.get("http://webt1/rater/rate.html");
        driver.manage().window().maximize();     
        
        //Login oLogin = new Login(driver);
        //oLogin.doLogin();
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		Methods objElement = new Methods(driver, Debugging.objMap);
		
		objElement.executeAction();
		
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)){
            fail(verificationErrorString);
        }
	}

}
