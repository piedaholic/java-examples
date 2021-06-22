package com.piedaholic.class_design.interest;

public class SimpleInterest implements InterestCalc {

    @Override
    public double calculateInterest(double principalAmt, double interestRate, double tenure) {
        return (principalAmt * tenure * interestRate) / 100;
    }
}
