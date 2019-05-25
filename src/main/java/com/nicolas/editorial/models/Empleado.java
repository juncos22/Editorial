/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.models;

/**
 *
 * @author nicolas
 */
public class Empleado {
    
    private String dni;
    private String nombre;
    private String telefono;
    private String direccion;

    public Empleado(String dni, String nombre, String telefono, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
    
}
