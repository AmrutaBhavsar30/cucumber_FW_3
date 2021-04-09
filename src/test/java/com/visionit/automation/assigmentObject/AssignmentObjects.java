package com.visionit.automation.assigmentObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AssignmentObjects {
	private static final Logger logger = LogManager.getLogger(AssignmentObjects.class);
	WebDriver driver;
		
	private By  searchLOGO=By.xpath("//div//img[@class='logo img-responsive']");
	private By LogoHeight=By.xpath("//img[@height='99']");
	private By Logowidth=By.xpath("//img[@width='350']");
	
	public AssignmentObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void navigateToLandingPgURl(String landingPageURl)
	{
		WebDriverWait wait1=new WebDriverWait(driver, 20);
		Boolean b=wait1.until(ExpectedConditions.urlToBe(landingPageURl));
		Assert.assertEquals("url redirection is fail", true, b);
		logger.info("URL redirection is passed :"+driver.getCurrentUrl());
	}
	
	public void validateTitle(String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation is fail",true, b);
		logger.info("title validated: " + expectedTitle );
	}
		
	public void logoDisplay()
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
		boolean b=driver.findElement(searchLOGO).isDisplayed();
		Assert.assertEquals("logo is not displayed", true, b);
		logger.info("logo is displyed");
	}
	public void logoHeight(String Height)
	{
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		String logoHeight=driver.findElement(LogoHeight).getAttribute(Height);
		Assert.assertEquals("logo height is not match", logoHeight, Height);
		logger.info("loho height is matched");
		
	
		}
	
	public void logoWidth(String Width)
	{
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		String logoWidth=driver.findElement(Logowidth).getAttribute("width");
		Assert.assertEquals("logo width is not matching",logoWidth , Width);
		logger.info("width is matched");
		
		
	}
}
