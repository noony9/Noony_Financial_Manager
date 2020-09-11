package com.noony_financial;

import com.noony_financial_exceptions.InsufficientFundsException;

import java.io.IOException;

public class Account implements IAccount {
    private float _accountBalance;


    public Account(int _accountID, float _accountBalance){
        this._accountBalance = _accountBalance;
    }

    @Override
    public void deposit(float value) throws IOException {
        if (value <= 0){
            throw new IOException();
        }
        _accountBalance += value;
    }

    @Override
    public void withdraw(float value) throws InsufficientFundsException {
        if (value > _accountBalance){
            throw new InsufficientFundsException();
        }
        _accountBalance -= value;
    }

    public float getAccountBalance(){
        return _accountBalance;
    }
}
