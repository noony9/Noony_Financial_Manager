package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

import java.io.IOException;
import java.util.Scanner;

public class Session implements ISession {

    private int _serviceSelection;
    private final boolean validInput = false;
    private final Scanner _userInput = new Scanner(System.in);
    private IAccount _account;


    public double readNumber(String prompt, double min, double max) {
        double value;
        while (true){
            System.out.print(prompt);
            value = _userInput.nextDouble();
            while(!_userInput.hasNextDouble()){
                System.out.print("Enter a numeric value between: " + min + " and " + max + "\n");
                break;
            }
            if (value >= min && value <= max)
                break;
            System.out.print("Enter a value between: " + min + " and " + max + "\n");
        }
        return value;
    }

    @Override
    public void greetUser(){

        System.out.println("\n");
        System.out.println("Welcome to Noony's Financial Manager\n\n");
    }

    @Override
    public void selectService() {
        // prompt user to select service
        _serviceSelection = (int) readNumber("Please enter the number of the service you wish to access and " +
                "press enter.\n" +
                "[1] Account Management:\n" +
                "[2] Mortgage Calculator:\n", 1, 2);

        // continue to prompt user until user enters a correct value
        if (!((_serviceSelection == 1) || (_serviceSelection == 2))) {
            System.out.println("Invalid Entry.  Please enter a valid selection.\n");
            _serviceSelection = Integer.parseInt(_userInput.nextLine());
        }
    }

    @Override
    public void provideService() {

        if (_serviceSelection == 1) {
            // present user with account management UI
            System.out.println("=Account Management=\n");

            // get user input
            _serviceSelection = (int) readNumber("Please enter the number of the service you wish to access" +
                    " and " + "press enter.\n" +
                    "[1] Make a deposit:\n" +
                    "[2] Make a withdraw:\n" +
                    "[3] View account balance:\n", 1, 3);

            // provide selected service
            switch (_serviceSelection) {
                case 1: {
                    System.out.println("Enter amount to deposit: ");
                    try {
                        float value = _userInput.nextFloat();
                        _account.deposit(value);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case 2: {
                    System.out.println("Enter amount to withdraw: ");
                    try {
                        float value = _userInput.nextFloat();
                        _account.withdraw(value);
                    } catch (InsufficientFundsException e) {
                        e.printStackTrace();
                    }
                }
                case 3: {
                    System.out.println("Account Balance: " + -_account.getAccountBalance());
                }
                default: {
                    break;
                }
            } // end switch
        } // end if
        else if (_serviceSelection == 2){

            // present user with Mortgage Calculator UI
            System.out.println("=Mortgage Calculator=\n");

            // prompt user to enter current Principle amount
            int userPrincipleAmount = (int) readNumber("Enter current Principle: ", 1_000, 1_000_000);

            // prompt user to enter current Annual Interest
            double userAnnualInterest = readNumber("Enter current Annual Interest: ", 0, 30);

            // prompt user to enter remaining Loan Term
            short userLoanTerm = (short) readNumber("Enter remaining Loan Term: ", 1, 30);

            // calculate user's mortgage
            IMortgageCalculator calculator = new MortgageCalculator2020(userPrincipleAmount, userAnnualInterest,
                    userLoanTerm);

            // print the mortgage report
            IReports report = new Reports();
            report.printMortgage(calculator);
        } // end else
    } // end method
} // end class
