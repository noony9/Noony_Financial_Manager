package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

import java.io.IOException;

public interface IAccount {

    public void deposit(float value) throws IOException;

    public void withdraw(float value) throws InsufficientFundsException;

    public float getAccountBalance();
}
