
package com.mycompany.silverbank;

import com.mycompany.silverbank.enums.AccountType;
import java.util.ArrayList;
import java.util.Random;

public class Account {
       
    private String name;
    private String id;
    private String number;
    private float balance = 0;
    private Transactions transactions;
    private AccountType type;
    
    public  ArrayList<Transactions> transactionsDatabase = new ArrayList<>(); // Create an ArrayList object  
       
    public Account(String name, String id, AccountType type) {
        
        setName(name);
        setId(id);
        setNumber();
        setType(type);
            
    }
      
    // sets
    
    public void addTransaction(Transactions transactions) {
        transactionsDatabase.add(transactions);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setType(AccountType type) {
        this.type = type;
    }

    private void setNumber() {
        
        Random random = new Random();
        int randomNumber = 38974 + random.nextInt(543123);
        this.number = "ACX-" + randomNumber;
               
    }
    
    public void addBalance(float balance) {
        this.balance += balance;
    }
          
    // gets

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
    
    public AccountType getType() {
        return type;
    }
    
    public float getBalance(){
        return balance;
    }
    
    public String getInfo() {
        
        return "Account Number: " + getNumber() + "\n" +
                "Type: " + getType() + "\n" +
                "Name: " + getName() + "\n" +
                "Id: " + getId() + "\n" +
                "Balance: " + getBalance() + "\n";                     
    } 
    
    public StringBuilder getTransactions() {
        StringBuilder sb = new StringBuilder("Transactions History" + "\n");
        boolean hasTransactions = false;
        
        for (Transactions transactions : transactionsDatabase) {
           
            if (transactions.getStrReceipt() != null) {
                sb.append(transactions.getStrReceipt());
                sb.append("\n");
                hasTransactions = true;
            }               
        }
        
        if (hasTransactions) {
            return sb;
        }
        
        sb.append("No transactions on file");
        return sb;       
    }
}
