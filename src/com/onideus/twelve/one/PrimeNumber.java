package com.onideus.twelve.one;

import java.util.List;

public class PrimeNumber {
    private boolean primeNumber;
    private List<Integer> factorList;

    public boolean isPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(boolean primeNumber) {
        this.primeNumber = primeNumber;
    }

    public List<Integer> getFactorList() {
        return factorList;
    }

    public void setFactorList(List<Integer> factorList) {
        this.factorList = factorList;
    }
}
