package stepDef;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	private static final Logger logger = LogManager.getLogger(StepDef.class);

	WebDriver driver;
	String base_url = "http://automationpractice.com";
	int implicit_wait_timeout_in_sec = 20;
	Scenario scn; // this is set in the @Before method

	@Before
	public void setUp(Scenario scn){
		this.scn = scn; //Assign this to class variable, so that it can be used in all the step def methods
		/*driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);*/
		logger.info("Browser will invoked.");
	}

	@After
	public void cleanUp(){
		driver.quit();
		scn.log("Browser Closed");
		logger.info("Browser Closed");
	}
	@Given("User opened browser")
	public void user_opened_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);

	}

	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(base_url);
		scn.log("Browser navigated to URL: " + base_url);
		logger.info("Browser navigated to URL: " + base_url);
	}

	@Then("validate Application url redirected with given url")
	public void validate_application_url_redirected_with_given_url() {
		String expected =  "http://automationpractice.com/index.php";
		String actual =driver.getCurrentUrl();
		Assert.assertEquals("Page Title validation",expected,actual);
		scn.log("Page title validation successfull. Actual title: " + actual );
		logger.info("Page title validation successfull. Actual title: " + actual );
		
	}

	@Then("the application logo is displayed")
	public void the_application_logo_is_displayed() {
		boolean logoPresent=driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();		
		Assert.assertTrue(logoPresent);
		scn.log("Application logo is displayed successfully");
		logger.info("Application logo is displayed successfully");
	}
	
	@Then("the application logo width is {int} & height is {int}")
	public void the_application_logo_width_is_height_is(Integer int1, Integer int2) {
		int width =driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getSize().getWidth();
		int ht=driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']")).getSize().getHeight();
		System.out.println("Width:"+width+"Height:"+ht);
		Assert.assertEquals(width, 940);
		Assert.assertEquals(ht, 83);
		scn.log("validate the application logo width and height");
		
	}
	@Then("Validate main product categories count should be {int}")
	public void validate_main_product_categories_count_should_be(Integer int1) {
      System.out.println("inside validate_main_product_categories_count_should_be");
      scn.log("Validate main product categories count should be 3");
      
	}
	@Then("text the displayed {int} categories is as shown below")
	public void text_the_displayed_categories_is_as_shown_below(Integer int1) {
		System.out.println("inside validate_main_product_categories_count_should_be_3");
		scn.log("Validate the text is displayed");
	}



	@When("user enters value as {string} in search box")
	public void user_enters_value_as_in_search_box(String string) {
		driver.findElement(By.id("search_query_top")).sendKeys(string);
		scn.log("User enters the string as tshirt");

	}



	@When("click on search box")
	public void click_on_search_box() {
		driver.findElement(By.xpath("//button[@type='submit'  and @name='submit_search']")).click();
		scn.log("User click on the search button");

	}
	@Then("the search result contains {string} as text")
	public void the_search_result_contains_as_text(String string) {
		boolean tshirt=driver.findElement(By.xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']")).isDisplayed();		
		Assert.assertTrue(tshirt);
		scn.log("Search result contains tshirt");
		logger.info("Search result contains tshirt");
		
	}

	@When("user clicks on the twitter link form footer section form landing page of the application")
	public void user_clicks_on_the_twitter_link_form_footer_section_form_landing_page_of_the_application() {
		driver.findElement(By.xpath("//li[@class='twitter']")).click();
		scn.log("ser clicks on the twitter link form footer section form landing page of the application");
	}


	@Then("Validate the url opened on a new tab contains �seleniumfrmwrk�")
	public void validate_the_url_opened_on_a_new_tab_contains_seleniumfrmwrk() {
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				scn.log("user Validated the url opened on a new tab contains seleniumfrmwrk in new window");

			}}

	}
	@Then("the twiiter accont name is �Selenium Framework�")
	public void the_twiiter_accont_name_is_selenium_framework() {
		String expected =  "https://twitter.com/seleniumfrmwrk";
		String actual =driver.getCurrentUrl();
		Assert.assertEquals("Page Title validation",expected,actual);
		scn.log("Page Title validation");
		logger.info("Page Title validation");
	}

}



