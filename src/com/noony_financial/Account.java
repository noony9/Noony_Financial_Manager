package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

public class Account implements IAccount {
    private int _accountID = 0;
    private double _accountBalance = 0;


    public Account(int _accountID, double _accountBalance){
        this._accountID = _accountID;
        this._accountBalance = _accountBalance;
    }

    @Override
    public void deposit(double value) throws Exception {
        if (value <= 0){
            throw new Exception();
        }
        _accountBalance += value;
    }

    @Override
    public void withdraw(double value) throws InsufficientFundsException {
        if (value > _accountBalance){
            throw new InsufficientFundsException();
        }
        _accountBalance -= value;
    }

    public double getAccountBalance(){
        return _accountBalance;
    }
}
