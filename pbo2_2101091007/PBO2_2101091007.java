/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2_2101091007;

import Mia.Dao.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PBO2_2101091007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
       
        try {
            Koneksi koneksi = new Koneksi ();
            Connection con = koneksi.getKoneksi();
            JOptionPane.showMessageDialog(null,"koneksi OK");
       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"  Eroor :" + ex.getMessage());
            Logger.getLogger(PBO2_2101091007.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
