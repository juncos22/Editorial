/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.controllers;

import com.nicolas.editorial.models.Conexion;
import com.nicolas.editorial.models.Dao;
import com.nicolas.editorial.models.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class EmpleadoImpl implements Dao<Empleado> {

    private Conexion c;
    private PreparedStatement cmd;
    private ResultSet rs;

    public EmpleadoImpl() {
        c = new Conexion();
    }

    @Override
    public void add(Empleado object) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("insert into empleado values (?,?,?,?)");
        cmd.setString(1, object.getDni());
        cmd.setString(2, object.getNombre());
        cmd.setString(3, object.getTelefono());
        cmd.setString(4, object.getDireccion());

        cmd.executeUpdate();
    }

    @Override
    public void edit(Empleado object) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("update empleado set telefono = ?, direccion = ? "
                + "where dni = ?");
        
        cmd.setString(1, object.getTelefono());
        cmd.setString(2, object.getDireccion());
        cmd.setString(3, object.getDni());

        cmd.executeUpdate();
    }

    @Override
    public void delete(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("delete from empleado where dni = ?");
        cmd.setString(1, filter); 
        cmd.executeUpdate();
    }

    @Override
    public Empleado getOne(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from empleado where dni = ? or nombre = ?");
        cmd.setString(1, filter);
        cmd.setString(2, filter); 
        
        rs = cmd.executeQuery();
        
        Empleado emp = null;
        
        if (rs.next()) {            
            emp = new Empleado(rs.getString("dni"), rs.getString("nombre"), 
                    rs.getString("telefono"), rs.getNString("direccion"));
        }
        
        return emp;
        
    }

    @Override
    public List<Empleado> getAll() throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from empleado");
        rs = cmd.executeQuery();
        
        List<Empleado> empleados = new ArrayList<>();
        Empleado emp;
        
        while (rs.next()) {            
            emp = new Empleado(rs.getString("dni"), rs.getString("nombre"), 
                    rs.getString("telefono"), rs.getString("direccion"));
            
            empleados.add(emp);
        }
        
        return empleados;
        
    }

    @Override
    public List<Empleado> getMany(String filter) throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from empleado where dni = ? or nombre = ?");
        cmd.setString(1, filter);
        cmd.setString(2, filter);
        
        rs = cmd.executeQuery();
        
        List<Empleado> empleados = new ArrayList<>();
        Empleado emp;
        
        while (rs.next()) {            
            emp = new Empleado(rs.getString("dni"), rs.getString("nombre"), 
                    rs.getString("telefono"), rs.getString("direccion"));
            
            empleados.add(emp);
        }
        
        return empleados;
    }

}
