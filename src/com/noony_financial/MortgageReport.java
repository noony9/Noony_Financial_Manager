package com.noony_financial;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
    }

    private static String formatCurrency(double value){
        // format mortgage payment into currency string
        String valueFormatted = NumberFormat.getCurrencyInstance().format(value);
        return valueFormatted;
    }

    public void printMortgage(){
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

}
