/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.JOptionPane;

/**
 *
 * @author jamin
 */
public class DeleteWarning {
   
    public boolean displayMessage(String message){
        return (JOptionPane.showConfirmDialog(null, message, "Delete?", JOptionPane.YES_NO_OPTION) != 1 );
    }
    
}
