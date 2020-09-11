package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

import java.io.IOException;

public interface ISession {

    public void greetUser();

    public void selectService();

    public void provideService();
}
