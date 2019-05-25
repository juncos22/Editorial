/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.controllers;

import com.nicolas.editorial.models.Conexion;
import com.nicolas.editorial.models.Dao;
import com.nicolas.editorial.models.NumRevista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class NumRevistaImpl implements Dao<NumRevista>{
    
    private Conexion c;
    private PreparedStatement cmd;
    private ResultSet rs;

    public NumRevistaImpl() {
        c = new Conexion();
    }
    
    
    
    @Override
    public void add(NumRevista object) throws ClassNotFoundException, SQLException {
    }

    @Override
    public void edit(NumRevista object) throws ClassNotFoundException, SQLException {
    }

    @Override
    public void delete(String filter) throws ClassNotFoundException, SQLException {
    }

    @Override
    public NumRevista getOne(String filter) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public List<NumRevista> getAll() throws ClassNotFoundException, SQLException {
        cmd = c.open().prepareStatement("select * from numRevista");
        rs = cmd.executeQuery();
        
        NumRevista nr;
        
        List<NumRevista> numRevistas = new ArrayList<>();
        
        while (rs.next()) {            
            nr = new NumRevista(rs.getInt("numero"), rs.getInt("n_ejemplares"), rs.getInt("n_paginas"), rs.getTimestamp("fecha"));
            
            numRevistas.add(nr);
        }
        
        return numRevistas;
    }

    @Override
    public List<NumRevista> getMany(String filter) throws ClassNotFoundException, SQLException {
        return null;
    }
    
    
}
