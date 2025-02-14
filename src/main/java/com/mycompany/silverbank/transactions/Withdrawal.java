
package com.mycompany.silverbank.transactions;
import com.mycompany.silverbank.Account;
import com.mycompany.silverbank.Transactions;
import com.mycompany.silverbank.utilities.IOHandler;
import com.mycompany.silverbank.enums.TransactionType;


public class Withdrawal extends Transactions {
    
    public Withdrawal(float amount) {
        super(amount, TransactionType.WITHDRAWAL);
    }
    
    @Override
    public void execute(Account account) {
        if (account.getBalance() < getAmount()) {
            IOHandler.showString("Balance insuficiente.");
            return;
        }
        account.addBalance(-getAmount());
    }
}
