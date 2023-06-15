/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mia.Dao;

import Mia.Model.Anggota;
import java.util.List;
import java.sql.Connection;

/**
 *
 * @author user
 */
public interface AnggotaDao {
    
   public void insert ( Connection con, Anggota anggota ) throws Exception;
   public void update (Connection con,Anggota anggota ) throws Exception;
   public void delete (Connection con,Anggota anggota ) throws Exception;
   public Anggota getAnggota (Connection con,String kode) throws Exception;
   public Anggota getAllAnggota(Connection con ,String kode) throws Exception;
   public List<Anggota> getAllAnggota(Connection con ) throws Exception;
  
    
}
