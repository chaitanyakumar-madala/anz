package com.anz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanCalculatorPage {

	@FindBy(xpath = "//label[@for='application_type_single']")
	public static WebElement single;
	
	@FindBy(xpath = "//label[@for='application_type_single']//input")
	public static WebElement singleInput;
	
	@FindBy(xpath = "//label[@for='application_type_joint']")
	public static WebElement joint;
	
	@FindBy(xpath = "//select[@title='Number of dependants']")
	public static WebElement noOfdependents;
	
	@FindBy(xpath = "//label[@for='borrow_type_home']")
	public static WebElement typeHome;
	
	@FindBy(xpath = "//label[@for='borrow_type_home']//input")
	public static WebElement typeHomeInput;
	
	@FindBy(xpath = "//label[@for='borrow_type_investment']")
	public static WebElement typeInvestment;
	
	@FindBy(xpath = "//label[contains(text(),'Your annual income (before tax)')]/parent::div//input")
	public static WebElement annualIncome;
	
	@FindBy(xpath = "//label[contains(text(),'Your annual other income (optional)')]/parent::div//input")
	public static WebElement otherIncome;
	
	@FindBy(xpath = "//label[contains(text(),'Monthly living expenses ')]/parent::div//input")
	public static WebElement livingExpenses;
	
	@FindBy(xpath = "//label[contains(text(),'Current home loan monthly') and contains(.,'repayments')]/parent::div//input")
	public static WebElement homeLoanRepayment;
	
	@FindBy(xpath = "//label[contains(text(),'Other loan monthly repayments')]/parent::div//input")
	public static WebElement otherLoanRepayment;
	
	@FindBy(xpath = "//label[contains(text(),'Other monthly commitments')]/parent::div//input")
	public static WebElement otherCommitments;
	
	@FindBy(xpath = "//label[contains(text(),'Total credit card limits')]/parent::div//input")
	public static WebElement creditLimits;
	
	@FindBy(xpath = "//button[@id='btnBorrowCalculater']")
	public static WebElement borrowEstimateButton;
	
	@FindBy(xpath = "//span[@id='borrowResultTextAmount']")
	public static WebElement borrowEstimateAmount;
	
	@FindBy(xpath = "//div[@class='result__restart']/button[@class='start-over']")
	public static WebElement startOverButton;
	
	@FindBy(xpath = "//div[@class='borrow__error__text']")
	public static WebElement borrowErrorMessage;
}
