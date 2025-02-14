
package com.mycompany.silverbank;
import com.mycompany.silverbank.transactions.Withdrawal;
import com.mycompany.silverbank.transactions.Deposit;
import com.mycompany.silverbank.transactions.Transfer;
import com.mycompany.silverbank.utilities.IOHandler;
import com.mycompany.silverbank.enums.TransactionType;
import com.mycompany.silverbank.enums.AccountType;
import java.util.ArrayList;

public class SilverBank {

    // Account database
    public static ArrayList<Account> accountDatabase = new ArrayList<>(); // Create an ArrayList object    
    
    // Builder
    public SilverBank() {}
    
    // Get account based on ID
    public Account getAcct() {
        
        String id = IOHandler.getString("CardHolder Id: ");
        for (Account account : accountDatabase) {

            if (account.getId().equals(id)) {              
                return account;
            }
        }
        return null;
    }
    
    // Account creation
    public void setupAccount() {
        
        String name = IOHandler.getString("CardHolder Name");
        String id = IOHandler.getString("CardHolder Id:");
        
        String[] options = {"CHECKING", "SAVINGS", "BUSINESS"};  
        String input = IOHandler.getOptionMenu(options);         
        AccountType type = AccountType.valueOf(input);
        
        Account newAccount = new Account(name, id, type);
        accountDatabase.add(newAccount);
        
        IOHandler.showString(newAccount.getInfo());        
    }
    
    // Delete account based on ID
    public void deleteAccount() {
        
        String id = IOHandler.getString("CardHolder Id: ");
        boolean accountFound = false;
        
        for (Account account: accountDatabase) {
            
            if (account.getId().equals(id)) {
                accountDatabase.remove(account);
                accountFound = true;
                break;
                
            }    
        }  
        
        if (accountFound) {
            IOHandler.showString("Account was deleted succesfully");
            return;
        }
        
        IOHandler.showString("Account not found");
    }
      
    // Transactions module
    public void performTransaction(TransactionType type) {
        
        float amount = 0;
        Account account = getAcct();
        
        if (account == null) {
            IOHandler.showString("Account not found");
            return;
        }
        
        IOHandler.showString("Account: " + account.getNumber() + "\n" + "Available Balance: " + account.getBalance());
        amount = IOHandler.getFloat("Amount: ");
        
        Transactions transaction = null;
        switch (type) {
            case DEPOSIT:
                transaction = new Deposit(amount);
                break;

            case WITHDRAWAL:
                transaction = new Withdrawal(amount);
                break;

            case TRANSFER:

                IOHandler.showString("Please enter destination account CardHolder ID");
                Account destinationAccount = getAcct();                
                IOHandler.showString("Source account: " + account.getInfo() + "\n\n" + "Destination account: " + destinationAccount.getInfo());               
                transaction = new Transfer(amount, destinationAccount);
                
                break;
        }
        
        transaction.execute(account);
        IOHandler.showString(transaction.getStrReceipt());
        account.addTransaction(transaction);  
    }
    
    // Accounts registered general report
    public void generateAccountReport() {
        
        StringBuilder sb = new StringBuilder("All accounts: " + "\n");
        boolean hasAccounts = false;
        
        for (Account account: accountDatabase) {
            
            if (account.getInfo() != null) {
                sb.append(account.getInfo());
                sb.append("\n");
                hasAccounts = true;
            }        
        }
        
        if (hasAccounts) {
            IOHandler.showString(sb.toString());
            return;
        }            
        
        IOHandler.showString("No available accounts on file");
    }
    
    // Transactions report by account id
    public void generateTransactionReport() {
        
        Account account = getAcct(); // Reutilizamos el método para obtener la account
        StringBuilder sb = new StringBuilder();
        boolean hasTransactions = false;
        
        if (account != null) {
            
            sb.append(account.getTransactions());
            hasTransactions = true;
        } 
        
        if (hasTransactions) {
            IOHandler.showString(sb.toString());
            return;
        }
        
        IOHandler.showString("Account not found");
  
    }
    
public static void main(String[] args) {
        
    Menu startApp = new Menu();
    startApp.main();
       
    }
}
