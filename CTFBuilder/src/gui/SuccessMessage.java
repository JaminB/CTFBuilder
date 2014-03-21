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
public class SuccessMessage {
     public void displayMessage(String message){
         Object[] options = { "OK" };
        JOptionPane.showOptionDialog(null, message, "Success",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, options, options[0]);
    }
}
