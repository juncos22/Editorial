/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.controllers;

import com.nicolas.editorial.models.Conexion;
import com.nicolas.editorial.models.Dao;
import com.nicolas.editorial.models.Sucursal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class SucursalImpl implements Dao<Sucursal> {

    private Conexion c;
    private PreparedStatement cmd;
    private ResultSet rs;

    public SucursalImpl() {
        c = new Conexion();
    }
    
    @Override
    public void add(Sucursal object) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("insert into sucursal values (null, ?,?,?,?)");
        cmd.setString(1, object.getTelefono());
        cmd.setString(2, object.getDomicilio());
        cmd.setString(3, object.getDni_emp());
        cmd.setInt(4, object.getN_registro());

        cmd.executeUpdate();
    }

    @Override
    public void edit(Sucursal object) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("update sucursal set telefono = ?, domicilio = ?, "
                + "dni_emp = ?, n_registro = ? where codigo = ?");
        
        cmd.setString(1, object.getTelefono());
        cmd.setString(2, object.getDomicilio());
        cmd.setString(3, object.getDni_emp());
        cmd.setInt(4, object.getN_registro());
        cmd.setInt(5, object.getCodigo());
        
        cmd.executeUpdate();
    }

    @Override
    public void delete(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("delete from sucursal where codigo = ?");
        cmd.setString(1, filter); 
        
        cmd.executeUpdate();
    }

    @Override
    public Sucursal getOne(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from sucursal where codigo = ? or telefono = ? "
                + "or domicilio = ?");
        cmd.setString(1, filter);
        cmd.setString(2, filter); 
        cmd.setString(3, filter);
        
        Sucursal suc = null;
        
        rs = cmd.executeQuery();
        
        if (rs.next()) {
            suc = new Sucursal(rs.getInt("codigo"), rs.getString("telefono"), 
                    rs.getString("domicilio"), rs.getString("dni_emp"), rs.getInt("n_registro"));
        }
        
        return suc;
    }

    @Override
    public List<Sucursal> getAll() throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from sucursal");
        rs = cmd.executeQuery();
        
        List<Sucursal> sucursales = new ArrayList<>();
        Sucursal suc;
        
        while (rs.next()) {            
            suc = new Sucursal(rs.getInt("codigo"), rs.getString("telefono"), 
                    rs.getString("domicilio"), rs.getString("dni_emp"), rs.getInt("n_registro"));
            
            sucursales.add(suc);
        }
        
        return sucursales;
    }

    @Override
    public List<Sucursal> getMany(String filter) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
