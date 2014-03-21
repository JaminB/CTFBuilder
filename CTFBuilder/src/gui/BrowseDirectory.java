/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author jamin
 */
public class BrowseDirectory {
    public String browse(){
      JFileChooser chooser = new JFileChooser();
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int result = chooser.showOpenDialog(null);
      if (JFileChooser.APPROVE_OPTION == result) {
            File file = chooser.getSelectedFile();
            return file.getAbsolutePath().toString();
      }
      return "";
    }
}
