package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Session implements ISession {

    private int _serviceSelection;
    private Scanner _userInput = new Scanner(System.in);
    private IAccount _account = new Account(1234, 0);

    public double readNumber(String prompt, double min, double max) {

        double value = 0.0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                value = _userInput.nextDouble();
                if (value >= min && value <= max) {
                    validInput = true;
                }
                else {
                    System.out.println("You have entered an invalid value. Enter a number between: " +
                                    min + " " + "and" + " " + max + "\n");
                    // clear the buffer
                    _userInput.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("You have entered an invalid character: " + "(" +  e.getMessage() + ")." + " " +  "Enter a number between: " +
                        min + " " + "and" + " " + max + "\n");
                // clear the buffer
                _userInput.next();
            }
        }
        return value;
    }

    public void greetUser(){

        System.out.println("\n");
        System.out.println("Welcome to Noony's Financial Manager\n\n");
    }

    public boolean selectService() {
        boolean inSession = true;
        // prompt user to select service
        _serviceSelection = (int) readNumber("Please enter the number of the service you wish to access and " +
                "press enter.\n" +
                "[1] Account Management\n" +
                "[2] Mortgage Calculator\n" + "[3] Exit Program\n", 1, 3);

        // continue to prompt user until user enters a correct value
        if (!((_serviceSelection == 1) || (_serviceSelection == 2) || (_serviceSelection == 3))) {
            System.out.println("Invalid Entry.  Please enter a valid selection.\n");
        }
        else if (_serviceSelection == 3)
            inSession = false;
        return inSession;
    }

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

                    var value = readNumber("Enter amount to deposit: ", 0, 5000000);
                    try {
                        _account.deposit(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Amount Deposited:" + " " + value + "\n");
                    break;
                }
                case 2: {

                    var value = readNumber("Enter amount to withdraw: ", 0,
                            _account.getAccountBalance());
                    try {
                        _account.withdraw(value);
                    }
                    catch (InsufficientFundsException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Amount withdrawn:" + " " + value + "\n");
                    break;
                }
                case 3: {
                    System.out.println("Account Balance: " + -_account.getAccountBalance() + "\n");
                    break;
                }
                default: {
                    break;
                }
            } // end switch

            // return user to main screen
            selectService();

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
            System.out.println("Press any key to continue...");

            // return user to main screen
            selectService();

        } // end else
        else if (_serviceSelection == 3){
            System.out.println("Exiting program...");
        }
    } // end method
} // end class
