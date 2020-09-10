package com.noony_financial;

public interface IMortgageCalculator {

    int get_principle();

    double get_annualInterest();

    short get_loanTerm();


    double calculateMortgage ();

    double getMonthlyInterest();

    int getNumberOfPayments();

}
