package com.noony_financial;

import java.text.NumberFormat;

public interface IReports {

    public String formatCurrency(double value);

    public void printMortgage(IMortgageCalculator calculator);

    public void printAccountBalance(IAccount account);
}


