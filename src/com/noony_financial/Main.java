package com.noony_financial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Session session = new Session();
//
//        int value = 0;
//        value = (int) session.readNumber("Enter a number", 1, 3);
//        System.out.println(value);
//    }

        // establish a new console session
        ISession activeSession = new Session();

        while(true){
            // greet user
            activeSession.greetUser();


            // allow user to select service
            activeSession.selectService();

            // validation testing - 1
            // System.out.println(activeSession.serviceSelection());

            // provide service
            activeSession.provideService();
        }

        // provide report of services completed

    }

}
