/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.models;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nicolas
 * @param <T>
 */
public interface Dao<T> {

    void add(T object) throws ClassNotFoundException, SQLException;

    void edit(T object) throws ClassNotFoundException, SQLException;

    void delete(String filter) throws ClassNotFoundException, SQLException;

    T getOne(String filter) throws ClassNotFoundException, SQLException;

    List<T> getAll() throws ClassNotFoundException, SQLException;

    List<T> getMany(String filter) throws ClassNotFoundException, SQLException;
}
