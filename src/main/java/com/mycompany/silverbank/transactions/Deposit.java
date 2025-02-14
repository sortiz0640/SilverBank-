
package com.mycompany.silverbank.transactions;
import com.mycompany.silverbank.Account;
import com.mycompany.silverbank.Transactions;
import com.mycompany.silverbank.enums.TransactionType;

public class Deposit extends Transactions {
       
    public Deposit(float amount) {
        super(amount, TransactionType.DEPOSIT);
    }
    
    @Override
    public void execute(Account account) {
        System.out.print(getAmount());       
        account.addBalance(getAmount());
    }
    
}
