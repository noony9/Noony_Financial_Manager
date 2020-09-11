package com.noony_financial;

import java.text.NumberFormat;

public class Reports implements IReports {

    @Override
    public String formatCurrency(double value){

        // format mortgage payment into currency string
        String valueFormatted = NumberFormat.getCurrencyInstance().format(value);
        return valueFormatted;
    }

    @Override
    public void printMortgage(IMortgageCalculator calculator){

        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = formatCurrency(mortgage);

        // display the results of user input Principle, Annual Interest, Loan Term and the calculated Monthly Mortgage
        System.out.println("-------------------------------------------");
        System.out.println("Total Principle Amount: " + calculator.get_principle());
        System.out.println("Annual Interest: " + calculator.get_annualInterest());
        System.out.println("Loan Term: " + calculator.get_loanTerm());
        System.out.println("-------------------------------------------");
        System.out.println("Monthly Mortgage: " + formattedMortgage);

    }

    @Override
    public void printAccountBalance(IAccount account) {

        System.out.println("Account Balance: " + -account.getAccountBalance());
    }

}
