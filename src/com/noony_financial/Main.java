package com.noony_financial;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int userPrincipleAmount = 0;
        double userAPR = 0.0;
        short userLoanTerm = 0;

        // prompt user to enter Total Principle Amount, APR & Loan Term in Months
        userPrincipleAmount = (int) readNumbers("Principle: ", 1_000, 1_000_000);

        // prompt user to enter APR
        userAPR = readNumbers("Annual Percentage Rate: ", 0, 30);

        // prompt user to enter total Loan Term in Months
        userLoanTerm = (short) readNumbers("Loan Term: ", 1, 30);

        // display the results of user input Total Principle Amount, APR and Term of Loan
        System.out.println("Total Principle Amount: " + userPrincipleAmount);
        System.out.println("APR: " + userAPR);
        System.out.println("Term of Loan: " + userLoanTerm + "\n");

        // calculate monthly mortgage payment
        double userMonthlyMortgagePayment = calculateMortgage(userPrincipleAmount, userAPR, userLoanTerm);

        // format monthly mortgage payment into currency string
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(userMonthlyMortgagePayment);

        // display the formatted monthly mortgage amount
        System.out.println("Monthly Mortgage Payment: " + mortgageFormatted);

    }
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENTAGE = 100;

    public static double readNumbers(String prompt, double min, double max){
        Scanner userInput = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = userInput.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.print("Enter a value between: " + min + " and " + max + "\n");
        }
        return value;
    }

    public static double convertAnnualToMonthlyInterest(double annualInterestRate){
        double monthlyInterestRate = annualInterestRate / PERCENTAGE / MONTHS_IN_YEAR;
        return monthlyInterestRate;
    }

    public static int loanYearsToMonths(int years){
        int totalMonths = years * MONTHS_IN_YEAR;
        return totalMonths;
    }

    public static double calculateMortgage (int userPrincipleAmount, double userAPR, int userLoanTerm) {
        // calculate user entered APR to a monthly interest rate
        double userMonthlyInterestRate = convertAnnualToMonthlyInterest(userAPR);

        // calculate user entered Loan Term to number of payments
        int userNumberOfPayments = loanYearsToMonths(userLoanTerm);

        // calculate monthly mortgage payment
        double userMonthlyMortgagePayment = userPrincipleAmount * (userMonthlyInterestRate * Math.pow(1 +
                userMonthlyInterestRate, userNumberOfPayments)) / (Math.pow(1 + userMonthlyInterestRate,
                userNumberOfPayments) - 1);

        // return monthly mortgage payment amount
        return userMonthlyMortgagePayment;
    }
}
