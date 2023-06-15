/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mia.Dao;

import Mia.Model.Pengembalian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author user
 */
public class PengembalianDaoImpl implements PengembalianDao {

    @Override
    public void insert(Connection con, Pengembalian pengembalian) throws Exception {
        String sql = "insert into pengembalian values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getKodeanggota());
        ps.setString(2, pengembalian.getKodebuku());
        ps.setString(3, pengembalian.getTglpinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
         ps.setDouble(6, pengembalian.getDenda());
         ps.executeUpdate();
   
    }

    @Override
    public void update(Connection con, Pengembalian pengembalian) throws Exception {
         String sql = "update pengembalian set tglkembali=? "
                + "where kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getKodeanggota());
        ps.setString(2, pengembalian.getKodebuku());
        ps.setString(3, pengembalian.getTglpinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
         ps.setDouble(6, pengembalian.getDenda());
         ps.executeUpdate();
    }

    @Override
    public void delete(Connection con, Pengembalian pengembalian) throws Exception {
      
    }

    @Override
    public Pengembalian getPengembalian(Connection con, String kodeanggota, String kodebuku, String tglpinjam) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pengembalian> getAllPengembalian(Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
