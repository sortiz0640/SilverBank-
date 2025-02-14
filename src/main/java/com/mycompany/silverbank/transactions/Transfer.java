
package com.mycompany.silverbank.transactions;
import com.mycompany.silverbank.Account;
import com.mycompany.silverbank.Transactions;
import com.mycompany.silverbank.utilities.IOHandler;
import com.mycompany.silverbank.enums.TransactionType;


public class Transfer extends Transactions {
    
    private Account destinationAccount;
    
    public Transfer(float amount, Account destinationAccount) {
        super(amount, TransactionType.TRANSFER);
        this.destinationAccount = destinationAccount;
    }
    
    @Override
    public void execute(Account sourceAccount) {
        if (sourceAccount.getBalance() < getAmount()) {
            IOHandler.showString("Not enough balance available.");
            return;
        }
        
        if (destinationAccount == null) {
            IOHandler.showString("Destination account not found");
            return;
        }
        
        sourceAccount.addBalance(-getAmount());                
        destinationAccount.addBalance(getAmount());  
                
    }
    
}
        
