/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.silverbank;

import com.mycompany.silverbank.enums.TransactionType;
import java.time.LocalDate;
import java.util.Random;

public abstract class Transactions {
    
    private float amount;
    private String number;
    private LocalDate date;
    private TransactionType type;
    
    public Transactions(float amount, TransactionType type) {
        
        setAmount(amount);
        setReceipt();
        setType(type);
        setDate();
         
    }
    
    public abstract void execute(Account account);
    
    /// GETTERS

    public float getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public TransactionType getType() {
        return type;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public String getStrReceipt() {
        
        String receipt = "Receipt: " + getNumber() + "\n" 
                + "Amount: " + getAmount() + "\n" 
                + "Type: " + getType() + "\n"
                + "Date: " + getDate() + "\n";
        
        return receipt;
   
    }
    
    // SETTERS

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setReceipt() {
        Random random = new Random();
        int randomNumber = 873210 + random.nextInt(147845);
        this.number = "TF-" + randomNumber;
    }

    public void setDate() {
        LocalDate myDate = LocalDate.now();
        this.date = myDate;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}

