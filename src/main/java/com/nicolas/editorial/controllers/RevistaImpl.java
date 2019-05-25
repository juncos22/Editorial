/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.controllers;

import com.nicolas.editorial.models.Conexion;
import com.nicolas.editorial.models.Dao;
import com.nicolas.editorial.models.Revista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class RevistaImpl implements Dao<Revista> {

    private Conexion c;
    private PreparedStatement cmd;
    private ResultSet rs;

    public RevistaImpl() {
        c = new Conexion();
    }

    @Override
    public void add(Revista object) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("insert into revista values (null, ?,?,?,?)");
        cmd.setString(1, object.getTitulo());
        cmd.setInt(2, object.getPeriodicidad());
        cmd.setString(3, object.getTipo());
        cmd.setInt(4, object.getN_revista());

        cmd.executeUpdate();
    }

    @Override
    public void edit(Revista object) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("update revista set titulo = ?, "
                + "periodicidad = ?, tipo = ?, n_revista = ? where n_registro = ?");
        cmd.setString(1, object.getTitulo());
        cmd.setInt(2, object.getPeriodicidad());
        cmd.setString(3, object.getTipo());
        cmd.setInt(4, object.getN_revista());
        cmd.setInt(5, object.getN_registro()); 

        cmd.executeUpdate();
    }

    @Override
    public void delete(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("delete from revista where titulo = ?");
        cmd.setString(1, filter); 
        
        cmd.executeUpdate();
    }

    @Override
    public Revista getOne(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from revista where titulo = ?");
        cmd.setString(1, filter); 
        
        rs = cmd.executeQuery();
        
        Revista rev = null;
        
        if (rs.next()) {            
            rev = new Revista(rs.getInt("n_registro"), rs.getString("titulo"), 
                    rs.getInt("periodicidad"), rs.getString("tipo"), rs.getInt("n_revista"));
        }
        
        return rev;
        
    }

    @Override
    public List<Revista> getAll() throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from revista");
        
        rs = cmd.executeQuery();
        
        List<Revista> revList = new ArrayList<>();
        Revista rev;
        
        while (rs.next()) {            
            rev = new Revista(rs.getInt("n_registro"), rs.getString("titulo"), 
                    rs.getInt("periodicidad"), rs.getString("tipo"), rs.getInt("n_revista"));
            
            revList.add(rev);
        }
        
        return revList;
    }

    @Override
    public List<Revista> getMany(String filter) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
