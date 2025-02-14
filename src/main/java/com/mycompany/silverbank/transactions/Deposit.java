
package com.mycompany.silverbank.transactions;
import com.mycompany.silverbank.Account;
import com.mycompany.silverbank.Transactions;
import com.mycompany.silverbank.enums.TransactionType;

public class Deposit extends Transactions {
       
    public Deposit(float monto) {
        super(monto, TransactionType.DEPOSIT);
    }
    
    @Override
    public void execute(Account cuenta) {
        System.out.print(getAmount());       
        cuenta.addBalance(getAmount());
    }
    
}
