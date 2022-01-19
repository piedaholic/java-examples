package com.piedaholic.oops.designs;

public class SimpleInterest implements InterestCalc {

    @Override
    public double calculateInterest(double principalAmt, double interestRate, double tenure) {
        return (principalAmt * tenure * interestRate) / 100;
    }
}
