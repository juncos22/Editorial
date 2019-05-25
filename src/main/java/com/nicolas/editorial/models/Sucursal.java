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
public class Sucursal {

    private int codigo;
    private String telefono;
    private String domicilio;
    private String dni_emp;
    private int n_registro;

    public Sucursal(String telefono, String domicilio, String dni_emp, int n_registro) {
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.dni_emp = dni_emp;
        this.n_registro = n_registro;
    }

    public Sucursal(int codigo, String telefono, String domicilio, String dni_emp, int n_registro) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.dni_emp = dni_emp;
        this.n_registro = n_registro;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDni_emp() {
        return dni_emp;
    }

    public int getN_registro() {
        return n_registro;
    }

}
