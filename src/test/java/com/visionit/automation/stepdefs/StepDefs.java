package com.visionit.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.visionit.automation.assigmentObject.AssignmentObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	private static final Logger logger = LogManager.getLogger(StepDefs.class);


	WebDriver driver;
	String base_url="http://automationpractice.com/";
	int implicit_timeout_in_sec=20;
	Scenario scn;

	AssignmentObjects assignmentObjects;

	@Before
	public void setup(Scenario scn) {
		this.scn=scn;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_timeout_in_sec, TimeUnit.SECONDS);
		driver.get(base_url);

		assignmentObjects= new AssignmentObjects(driver);
	}


	@After(order=1)
	public void cleanUp()
	{
		driver.quit();
		scn.log("Browser Closed");
	}
	
	@After(order=2)
	public void takeSceenShot(Scenario s)
	{
		if(scn.isFailed())
		{
			TakesScreenshot srcShot = (TakesScreenshot)driver;
			byte[] data = srcShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png","Failed Step Name : "+ s.getName());
		}
		else
		{
			scn.log("Test case is passed, no screen shot captured");
		}
	}
	
	
	// @URLredirection 
	@Given("User Opend the application url")
	public void user_opend_the_application_url() {
		WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
		scn.log("1driver navigated to base url :"+base_url);
		logger.info("2driver navigated to base url :"+base_url);
	}

	@When("user is on appllication main page")
	public void user_is_on_appllication_main_page() {
		scn.log(driver.getTitle());
		logger.info("app main page");

	}

	@Then("user navigate to landing page url: {string}")
	public void user_navigate_to_landing_page_url(String expectedurl)
	{
		assignmentObjects.navigateToLandingPgURl(expectedurl);
		scn.log("1URL redirection is passed");

	}


	// @titleValidation
	@Then("application title should be {string}")
	public void application_title_should_be(String expectedTitle) {
		//Assert.assertEquals("title are not validated",expectedTitle, driver.getTitle());

		assignmentObjects.validateTitle(expectedTitle);
		scn.log("1application tilte matched and it is :"+driver.getTitle());
	}

	//@LogoDisplay
	@Deprecated
	@When("User open the browser")
	public void user_open_the_browser() {

	}


	@Then("application logo should be displayed")
	public void application_logo_should_be_displayed() {
		assignmentObjects.logoDisplay();
		scn.log("logo displayed successfully");
	}
	// @LogoHeight
	@Then("application logo height should be {string}")
	public void application_logo_height_should_be(String Actuallogoheight) {
		assignmentObjects.logoHeight(Actuallogoheight);
		scn.log("height is matching :");
	}

	// @LogoWidth
	@Then("application logo width should be {string}")
	public void application_logo_width_should_be(String Actuallogowidth) {
		assignmentObjects.logoWidth(Actuallogowidth);
		scn.log("logo width matching");
	}




}
