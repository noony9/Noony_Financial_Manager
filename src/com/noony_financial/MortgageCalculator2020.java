package com.noony_financial;

public class MortgageCalculator2020 implements IMortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENTAGE = 100;

    private int _principle;
    private double _annualInterest;
    private short _loanTerm;

    public MortgageCalculator2020(int _principle, double _APR, short _loanTerm){
        this._principle = _principle;
        this._annualInterest = _APR;
        this._loanTerm = _loanTerm;
    }
    @Override
    public int get_principle() {

        return _principle;
    }

    private void set_principle(int _principle) {

        this._principle = _principle;
    }

    @Override
    public double get_annualInterest() {

        return _annualInterest;
    }

    private void set_annualInterest(double _APR) {

        this._annualInterest = _APR;
    }

    @Override
    public short get_loanTerm() {

        return _loanTerm;
    }

    private void set_loanTerm(short _loanTerm) {

        this._loanTerm = _loanTerm;
    }

    @Override
    public double calculateMortgage () {

        // calculate user entered annual interest to a monthly interest rate
        double useInterestRate = getMonthlyInterest();

        // calculate user entered Loan Term to number of payments
        int userNumberOfPayments = getNumberOfPayments();

        // calculate mortgage payment
        double userMortgagePayment = _principle * (useInterestRate * Math.pow(1 +
                useInterestRate, userNumberOfPayments)) / (Math.pow(1 + useInterestRate,
                userNumberOfPayments) - 1);

        // return mortgage payment amount
        return userMortgagePayment;
    }

    @Override
    public double getMonthlyInterest() {

        return _annualInterest / PERCENTAGE / MONTHS_IN_YEAR;
    }

    @Override
    public int getNumberOfPayments() {

        return _loanTerm * MONTHS_IN_YEAR;
    }

}
