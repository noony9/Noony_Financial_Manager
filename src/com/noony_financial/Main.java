package com.noony_financial;

public class Main {

    public static void main(String[] args) {

        // greet user
        Console.greetUser();

        // prompt user to enter Principle amount and assign to userPrincipleAmount variable
        int userPrincipleAmount = (int) Console.readNumber("Principle: ", 1_000, 1_000_000);

        // prompt user to enter APR and assign to userAPR variable
        double userAnnualInterest = Console.readNumber("Annual Percentage Rate: ", 0, 30);

        // prompt user to enter total Loan Term in Months and assign to userLoanTerm variable
        short userLoanTerm = (short) Console.readNumber("Loan Term: ", 1, 30);

        // instantiate a new mortgage calculator using input provided by user
        IMortgageCalculator calculator = new MortgageCalculator2020(userPrincipleAmount, userAnnualInterest, userLoanTerm );

        // instantiate a new mortgage report using the mortgage calculator instance
        MortgageReport report = new MortgageReport(calculator);

        // print the mortgage report
        report.printMortgage(calculator);
    }
}
