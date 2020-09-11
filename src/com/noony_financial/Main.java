package com.noony_financial;

public class Main {

    public static void main(String[] args) {

        // establish a new console session
        ISession activeSession = new Session();

        // greet user
        activeSession.greetUser();

        // allow user to select service
        activeSession.selectService();

        // validation testing - 1
        // System.out.println(activeSession.serviceSelection());

        // provide service
        activeSession.provideService();
        // provide report of services completed

    }
}
