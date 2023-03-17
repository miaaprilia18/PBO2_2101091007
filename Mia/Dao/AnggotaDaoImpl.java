/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mia.Dao;

import Mia.Model.Anggota;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author user
 */
public class AnggotaDaoImpl implements AnggotaDao {

    @Override
    public void insert(Connection con, Anggota anggota) throws Exception {
        String sql = "Insert into anggota values (?,?,?,?,)";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,anggota.getKodeanggota());
        ps.setString(2,anggota.getNamaanggota());
        ps.setString(3,anggota.getAlamat());
        ps.setString(4,anggota.getJeniskelamin());
        ps.executeUpdate();
       
    }
    
    
}
