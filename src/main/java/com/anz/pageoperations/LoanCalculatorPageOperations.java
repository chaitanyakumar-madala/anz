package com.anz.pageoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.anz.pages.LoanCalculatorPage;

public class LoanCalculatorPageOperations extends LoanCalculatorPage {

	static WebDriver driver;

	public LoanCalculatorPageOperations(WebDriver driver) {
		LoanCalculatorPageOperations.driver = driver;
	}

	public static void selectApplicationType(String applicationType) {
		if (applicationType.equalsIgnoreCase("single")) {
			single.click();
		} else if (applicationType.equalsIgnoreCase("joint")) {
			joint.click();
		}
	}

	public static void selectDependents(String dependents) {
		Select selectDep= new Select(noOfdependents);
		selectDep.selectByVisibleText(dependents);
	}

	public static void selectPropertyType(String propertyType) {
		if (propertyType.equalsIgnoreCase("Home to live in")) {
			typeHome.click();
		} else if (propertyType.equalsIgnoreCase("Residential investment")) {
			typeInvestment.click();
		}
	}
	
	public static void  enterAnnualIncome(String income) {
		annualIncome.clear();
		annualIncome.sendKeys(income);
	}
	
	public static void enterOtherIncome(String income) {
		otherIncome.clear();
		otherIncome.sendKeys(income);
	}
	
	public static void enterMonthlyLivingExpenses(String expenses) {
		livingExpenses.clear();
		livingExpenses.sendKeys(expenses);
	}
	
	public static void enterHomeLoanRepayment(String loanAmount) {
		homeLoanRepayment.clear();
		homeLoanRepayment.sendKeys(loanAmount);
	}
	
	public static void enterOtherLoanRepayment(String loanAmount) {
		otherLoanRepayment.clear();
		otherLoanRepayment.sendKeys(loanAmount);
	}
	
	public static void enterOtherCommitments(String amount) {
		otherCommitments.clear();
		otherCommitments.sendKeys(amount);
	}
	
	public static void enterCreditLimits(String limit) {
		creditLimits.clear();
		creditLimits.sendKeys(limit);
	}
	
	public static void clickBorrowEstimateButton() throws InterruptedException {
		borrowEstimateButton.click();
		Thread.sleep(5000);
	}

	public static void verifyBorrowEstimateAmount(String amount)  {
		 Assert.assertEquals(borrowEstimateAmount.getText(), amount, "Borrow Estimate amount not equals Expeccted amount");
		 
	}
	
	public static void clickStartOverButton() {
		startOverButton.click();
	}
	
	public static void verifyFormCleared() {
		Assert.assertEquals(singleInput.getAttribute("checked"),"true","Application type not reset");
		Select selectDep= new Select(noOfdependents);
		Assert.assertEquals(selectDep.getFirstSelectedOption().getText(),"0","Number of dependents not reset");
		Assert.assertEquals(typeHomeInput.getAttribute("checked"),"true","Property type not reset");
		Assert.assertEquals(annualIncome.getAttribute("value"),"0","Annual income not reset");
		Assert.assertEquals(otherIncome.getAttribute("value"),"0","Other Annual income not reset");
		Assert.assertEquals(livingExpenses.getAttribute("value"),"0","Monthly living expenses not reset");
		Assert.assertEquals(homeLoanRepayment.getAttribute("value"),"0","Home Loan repayment not reset");
		Assert.assertEquals(otherLoanRepayment.getAttribute("value"),"0","Other Loan repayment not reset");
		Assert.assertEquals(otherCommitments.getAttribute("value"),"0","Other commitments not reset");
		Assert.assertEquals(creditLimits.getAttribute("value"),"0","Total credit Limits not reset");
		Assert.assertEquals(borrowEstimateAmount.getText(),"$0","Estimated borrow amount not reset");
	}
	
	public static void verifyBorrowErrorMessage(String message) {
		Assert.assertEquals(borrowErrorMessage.getText(), message,"borrow error message is not equal to expected message");
	}
}
