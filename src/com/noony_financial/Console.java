package com.noony_financial;

import java.util.Scanner;

public class Console {

    private static Scanner userInput = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max){
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

    public static void greetUser(){
        System.out.println("\n");
        System.out.println("Welcome to Noony's Mortgage Calculator, please enter your name: ");
        String userName = userInput.nextLine();
        System.out.println(userName + ", " + "to calculate your monthly mortgage amount, please " +
                "enter your total Principle, Annual Interest Rate and Loan Term in years.\n");
    }
}
