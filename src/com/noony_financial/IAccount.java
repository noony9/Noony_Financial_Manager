package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

public interface IAccount {

    public void deposit(double value) throws Exception;

    public void withdraw(double value) throws InsufficientFundsException;

    public double getAccountBalance();
}
