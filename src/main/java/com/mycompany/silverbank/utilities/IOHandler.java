
package com.mycompany.silverbank.utilities;

import javax.swing.JOptionPane;

public class IOHandler {
    
    // Shows message box and returns user input (string)
    public static String getString(String message) {
            
        String input = JOptionPane.showInputDialog(message);
        return input;
        
    }
    
    // Shows message box and returns user input (int)
    public static int getInt(String message) {
        
        int input = Integer.parseInt(JOptionPane.showInputDialog(message));
        return input;
    }
    
    // Shoes message box and returns user input (float)
    public static float getFloat(String message) {
        
        float input = Float.parseFloat(JOptionPane.showInputDialog(message));
        return input;
        
    }
    
    // Shows basic message box
    public static void showString(String message) {
        
        JOptionPane.showMessageDialog(null, message);
     
    }
       
    // Shows options input box based on String array
    public static String getOptionMenu(String[] options) {

        String input = (String) JOptionPane.showInputDialog(
            null,
            "Select an option",
            "Options Menu",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]     
        );

        return input;    
    }
}
