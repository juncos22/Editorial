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
public class Periodista {
    
    private String dni;
    private String nombre;
    private String telefono;
    private String direccion;
    private String espcialidad;

    public Periodista(String dni, String nombre, String telefono, String direccion, String espcialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.espcialidad = espcialidad;
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

    public String getEspcialidad() {
        return espcialidad;
    }
    
    
}
