Feature: ANZ loan Calculator

@smoke
Scenario: Verify a person has borrowing estimate of specific amount
Given User navigated to anz loan calculator url "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow"
When User selects application type "Single"
And User selects Number of dependants "0"
And User selects Property type "Home to live in"
And User enters Annual income before tax amount "80000"
And User enters Annual other income amount "10000"
And User enters monthly living expenses amount "500"
And User enters current home loan monthly repayments "0"
And User enters other loan monthly repayments "100"
And User enters other monthly commitments "0"
And User enters total credit card limits "10000"
And Click on work out how much i could borrow button
Then Verify borrowing estimate amount equal to "$482,000"

@smoke1
Scenario: Verify Clicking on start over button clears the form
Given User navigated to anz loan calculator url "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow"
When User selects application type "Single"
And User selects Number of dependants "0"
And User selects Property type "Home to live in"
And User enters Annual income before tax amount "80000"
And User enters Annual other income amount "10000"
And User enters monthly living expenses amount "500"
And User enters current home loan monthly repayments "0"
And User enters other loan monthly repayments "100"
And User enters other monthly commitments "0"
And User enters total credit card limits "10000"
And Click on work out how much i could borrow button
And Click on start over button
Then Verify form is cleared

@smoke2
Scenario: Verify entering only one dollar for living expenses leaving all fields as zero and clicking Borrow buttons gives Based on the details you have  entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641 message
Given User navigated to anz loan calculator url "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow"
When User selects application type "Single"
And User selects Number of dependants "0"
And User selects Property type "Home to live in"
And User enters Annual income before tax amount "0"
And User enters Annual other income amount "0"
And User enters monthly living expenses amount "1"
And User enters current home loan monthly repayments "0"
And User enters other loan monthly repayments "0"
And User enters other monthly commitments "0"
And User enters total credit card limits "0"
And Click on work out how much i could borrow button
And Verify "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500." message is displayed