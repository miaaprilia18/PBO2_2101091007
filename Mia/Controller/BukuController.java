/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mia.Controller;

import Mia.Dao.BukuDao;
import Mia.Dao.BukuDaoImpl;
import Mia.Dao.Koneksi;
import Mia.Model.Buku;
import Mia.View.FormBuku;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class BukuController {
    
   private FormBuku formBuku;
    private Buku buku;
    private BukuDao bukuDao;
    private Connection con;
    private Koneksi koneksi;
    
    public BukuController(FormBuku formBuku){
        try {
            this.formBuku = formBuku;
            bukuDao = new BukuDaoImpl();
            con = new Koneksi().getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bersihForm(){
        formBuku.getTxtKodebuku().setText("");
        formBuku.getTxtJudul().setText("");   
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");
    }
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setKodebuku(formBuku.getTxtKodebuku().getText());
            buku.setJudul(formBuku.getTxtJudul().getText());
            buku.setPengarang(formBuku.getTxtPengarang().getText());
            buku.setPenerbit(formBuku.getTxtPenerbit().getText());
            bukuDao.insert(con, buku);
            JOptionPane.showMessageDialog(formBuku, "Entri OK");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            buku.setKodebuku(formBuku.getTxtKodebuku().getText());
            buku.setJudul(formBuku.getTxtJudul().getText());
            buku.setPengarang(formBuku.getTxtPengarang().getText());
            buku.setPenerbit(formBuku.getTxtPenerbit().getText());
            bukuDao.update(con, buku);
            JOptionPane.showMessageDialog(formBuku, "Update Ok");
        } catch (Exception ex) {
           Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            bukuDao.delete(con, buku);
            JOptionPane.showMessageDialog(formBuku, "Delete Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cari(){
        try {
            String kode = formBuku.getTxtKodebuku().getText();
            buku = bukuDao.getBuku(con, kode);
            if(buku != null){
                formBuku.getTxtJudul().setText(buku.getJudul());
                formBuku.getTxtPengarang().setText(buku.getPengarang());
                formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            }else {
                JOptionPane.showMessageDialog(formBuku, "Data tidak ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formBuku.getTblBuku().getModel();
            tabel.setRowCount(0);
            List<Buku> list = bukuDao.getAllBuku(con);
            for (Buku buku : list) {
                Object[] row = {
                    buku.getKodebuku(),
                    buku.getJudul(),
                    buku.getPengarang(),
                    buku.getPenerbit()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
