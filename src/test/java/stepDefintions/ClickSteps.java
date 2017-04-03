package stepDefintions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import configureEnvironment.PropertiesHandler;
import cucumber.api.java.en.Then;

/**
 * This class contains methods to allow you to click on an element
 * More steps examples here: https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/canned_steps.md
 * @author estefafdez
 */
public class ClickSteps {
	WebDriver driver;
	
    /******** Log Attribute ********/
    private static Logger log = Logger.getLogger(ClickSteps.class);
	
	public ClickSteps(){
		 driver= Hooks.driver;
	}

	/** Click on a WebElement */
	@Then("^I click on element having (.+) \"(.*?)\"$") 
	public void click(String type, String key) throws Exception
	{
		By element = PropertiesHandler.getCompleteElement(type, key);
		driver.findElement(element).click();
		log.info("Click on element by "+type+": " + element);	
	}
 
	/** Double click on a WebElement */
	@Then("^I double click on element having (.+) \"(.*?)\"$") 
	public void doubleClick(String type, String key) throws Exception
	{
		Actions action = new Actions(driver);
		By element = PropertiesHandler.getCompleteElement(type, key);
		action.moveToElement(driver.findElement(element)).doubleClick().perform();
		log.info("Double click on element: " + element);	
	}
		
	/** Click on a link having text */
	@Then("^I click on link having text \"(.*?)\"$")
	public void clickElementByLink(String text)
	{
		By element = PropertiesHandler.getCompleteElement("linkText", text);
		driver.findElement(element).click();
		log.info("Click on link having text: " + text);
	}
		
	/** Click on a link having partial text */
	@Then("^I click on link having partial text \"(.*?)\"$")
	public void clickElementByPartialLink(String text)
	{
		By element = PropertiesHandler.getCompleteElement("partialLinkText", text);
		driver.findElement(element).click();
		log.info("Click on link having partial text: " + text);
	}

}
