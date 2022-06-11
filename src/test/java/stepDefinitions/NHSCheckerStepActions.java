package stepDefinitions;
import java.util.Properties;

import actionPages.NHSCheckerPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverStart;

public class NHSCheckerStepActions{

	static WebDriver driver;
	private Properties properties;
	private final String propertyFilePath= "Configuration.properties";

	@Given("Opened NHS Costs Checker in {string} and clicked on start button")
	public void opened_nhs_costs_checker_in_browser_and_clicked_on_start_button(String browser) throws InterruptedException {
		driver = WebDriverStart.launchBrowser(browser);
		WebDriverStart.openUrl("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");
		PageFactory.initElements(driver, NHSCheckerPage.class);
		NHSCheckerPage.clickStartButton();
		Thread.sleep(200);

	}

	@When("Select country {string}")
	public void selected_country(String country) throws InterruptedException {
		NHSCheckerPage.selectCountry(country);
		Thread.sleep(200);
	}

	@And("Click next")
	public void click_next() throws InterruptedException {
		NHSCheckerPage.clickNext();
		Thread.sleep(1000);
	}

	@And("select Yes")
	public void select_yes() {
		NHSCheckerPage.setSelectYes();
	}

	@And("select No")
	public void select_no() {
		NHSCheckerPage.setSelectNo();
	}

	@When("Enter invalid BOD {string}")
	public void enter_invlaid_dob(String dob) throws InterruptedException {
		Thread.sleep(500);
		NHSCheckerPage.enterDateOfBirth(dob);
	}

	@Then("Verify Date Validation")
	public void validate_dob() throws InterruptedException {
		Thread.sleep(500);
		System.out.println(NHSCheckerPage.validateBOD());
		if (NHSCheckerPage.validateBOD() != "")
		{
			NHSCheckerPage.validateBOD().equalsIgnoreCase("Enter your date of birth");
		    NHSCheckerPage.validateBOD().equalsIgnoreCase("Check the year you were born is correct");
		}
	}
	@And("Enter valid BOD {string}")
	public void enter_dob(String dob) throws InterruptedException {
		Thread.sleep(500);
		NHSCheckerPage.enterDateOfBirth(dob);
	}

	@When("Select partner tax claim {string}")
	public void Select_partner_tax_claim(String partner_taxclaim) {
		NHSCheckerPage.selectPartnerTaxClaim(partner_taxclaim);
	}

	@When("Select partner paid {string}")
	public void Select_partner_paid(String partner_paid) {
		NHSCheckerPage.selectPartnerPaid(partner_paid);
	}

	@When("Select partner paid for Univarsal Crdit {string}")
	public void Select_partner_univarsal_crdit(String univaral_credit) {
		NHSCheckerPage.selectPartnerUnivalCredit(univaral_credit);
	}

	@Then("Show result whether get help from NHS or not")
	public void result_whether_get_help_from_nhs_or_not() {
		NHSCheckerPage.displayResult();
	}

	@After
	public void teardown() {
		driver.quit();
	}

}
