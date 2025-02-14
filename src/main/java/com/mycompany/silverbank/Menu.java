
package com.mycompany.silverbank;

import com.mycompany.silverbank.utilities.IOHandler;
import com.mycompany.silverbank.enums.TransactionType;
import com.mycompany.silverbank.enums.MenuType;
import com.mycompany.silverbank.enums.ReportType;
import com.mycompany.silverbank.enums.AccountMenu;

public class Menu {
    
    private boolean isActive;
    
    SilverBank bank = new SilverBank();
    public Menu() {}
    
    public void main() {
        
        isActive = true;     
        while (isActive) {
            
            String[] options = {"ACCOUNTS", "TRANSACTIONS", "REPORTS", "EXIT"};
            String input = IOHandler.getOptionMenu(options);            
            MenuType type = MenuType.valueOf(input);
            
            switch (type) {
                case ACCOUNTS: accountMenu(); break;
                case TRANSACTIONS: transactionsMenu(); break;
                case REPORTS: reportMenu(); break;
                case EXIT: isActive = false; break;
            }       
        }     
    }
    
    public void accountMenu() {
        
        String[] options = {"CREATE", "DELETE", "EXIT"};
        String input = IOHandler.getOptionMenu(options);
        
        AccountMenu type = AccountMenu.valueOf(input);
        
        switch (type) {
            case CREATE: bank.setupAccount(); break;
            case DELETE: bank.deleteAccount(); break;
            case EXIT: break;
        }      
    } 
    
    public void transactionsMenu() {
        String[] options = {"DEPOSIT", "WITHDRAWAL", "TRANSFER"};
        String input = IOHandler.getOptionMenu(options);
        
        TransactionType type = TransactionType.valueOf(input);
        bank.performTransaction(type);
            
    }
    
    public void reportMenu() {
        
        String[] options = {"ALL_ACCOUNTS", "TRANSACTIONS_REPORT", "EXIT"};
        String input = IOHandler.getOptionMenu(options);
        
        ReportType type = ReportType.valueOf(input);
        
        switch (type) {
            case ALL_ACCOUNTS: bank.generateAccountReport(); break;
            case TRANSACTIONS_REPORT: bank.generateTransactionReport(); break;
            case EXIT: break;
        }
    }
    

}
