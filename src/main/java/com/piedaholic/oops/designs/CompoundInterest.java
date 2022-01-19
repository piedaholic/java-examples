package com.piedaholic.oops.designs;

public class CompoundInterest implements InterestCalc {

	@Override
	public double calculateInterest(double principalAmt, double interestRate, double tenure) {
		double initialPrincipalAmt = principalAmt;
		for (int year = 0; year < (int) tenure; year++) {
			principalAmt = principalAmt + (principalAmt * interestRate) / 100;
		}
		principalAmt = principalAmt + (principalAmt * interestRate * (tenure - Math.floor(tenure)) / 100);
		return principalAmt - initialPrincipalAmt;
	}
	
	public double calculateInterestUsingFormula(double principalAmt, double interestRate, double tenure) {
		double initialPrincipalAmt = principalAmt;
		principalAmt  = principalAmt * Math.pow((1 + interestRate/100), tenure);
		return principalAmt - initialPrincipalAmt;
	}

}
