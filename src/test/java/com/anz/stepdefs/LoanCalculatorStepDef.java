package com.anz.stepdefs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.anz.commonutils.WebDriverUtils;
import com.anz.pageoperations.LoanCalculatorPageOperations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanCalculatorStepDef {

	WebDriver driver;

	@Before
	public void beforeCucumber() throws IOException {
		driver = WebDriverUtils.launchBrowser();

	}

	@Given("User navigated to anz loan calculator url {string}")
	public void user_navigated_to_anz_loan_calculator_url(String string) throws IOException {

		WebDriverUtils.launchUrl();
		PageFactory.initElements(driver, LoanCalculatorPageOperations.class);
	}

	@When("User selects application type {string}")
	public void user_selects_application_type(String string) {

		LoanCalculatorPageOperations.selectApplicationType(string);
	}

	@When("User selects Number of dependants {string}")
	public void user_selects_number_of_dependants(String string) {
		LoanCalculatorPageOperations.selectDependents(string);
	}

	@When("User selects Property type {string}")
	public void user_selects_property_type(String string) {
		LoanCalculatorPageOperations.selectPropertyType(string);

	}

	@When("User enters Annual income before tax amount {string}")
	public void user_enters_annual_income_before_tax_amount(String string) {

		LoanCalculatorPageOperations.enterAnnualIncome(string);
	}

	@When("User enters Annual other income amount {string}")
	public void user_enters_annual_other_income_amount(String string) {

		LoanCalculatorPageOperations.enterOtherIncome(string);
	}

	@When("User enters monthly living expenses amount {string}")
	public void user_enters_monthly_living_expenses_amount(String string) {
		LoanCalculatorPageOperations.enterMonthlyLivingExpenses(string);

	}

	@When("User enters current home loan monthly repayments {string}")
	public void user_enters_current_home_loan_monthly_repayments(String string) {
		LoanCalculatorPageOperations.enterHomeLoanRepayment(string);

	}

	@When("User enters other loan monthly repayments {string}")
	public void user_enters_other_loan_monthly_repayments(String string) {
		LoanCalculatorPageOperations.enterOtherLoanRepayment(string);
	}

	@When("User enters other monthly commitments {string}")
	public void user_enters_other_monthly_commitments(String string) {
		LoanCalculatorPageOperations.enterOtherCommitments(string);

	}

	@When("User enters total credit card limits {string}")
	public void user_enters_total_credit_card_limits(String string) {
		LoanCalculatorPageOperations.enterCreditLimits(string);

	}

	@When("Click on work out how much i could borrow button")
	public void click_on_work_out_how_much_i_could_borrow_button() throws InterruptedException {
		LoanCalculatorPageOperations.clickBorrowEstimateButton();

	}

	@Then("Verify borrowing estimate amount equal to {string}")
	public void verify_borrowing_estimate_amount_equal_to(String string) {
		LoanCalculatorPageOperations.verifyBorrowEstimateAmount(string);
	}

	@Then("Click on start over button")
	public void click_on_start_over_button() {
		LoanCalculatorPageOperations.clickStartOverButton();
	}

	@Then("Verify form is cleared")
	public void verify_form_is_cleared() {
		LoanCalculatorPageOperations.verifyFormCleared();
	}

	@When("Verify {string} message is displayed")
	public void verify_message_is_displayed(String string) {
		LoanCalculatorPageOperations.verifyBorrowErrorMessage(string);
	}

	@After
	public void afterCucumber(Scenario scenario) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(srcFile);
		scenario.attach(fileContent, "image/png", scenario.getName());
		driver.quit();
	}
	//end of class
}
