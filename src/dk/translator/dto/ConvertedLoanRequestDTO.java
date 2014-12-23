/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.translator.dto;

import java.io.Serializable;

/**
 *
 * @author Jon
 */
public class ConvertedLoanRequestDTO implements Serializable 
{
    private static final long serialVersionUID = 1L;
   
    private long ssn;
    private int creditScore;
    private double loanAmount;
    private int loanDuration;
    
    public ConvertedLoanRequestDTO() {
    }

    public ConvertedLoanRequestDTO(long ssn, int creditScore, double loanAmount, int loanDuration) {
        this.ssn = ssn;        
        this.creditScore = creditScore;
        this.loanAmount = loanAmount;
        this.loanDuration = loanDuration;
        
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }
    
    
}
