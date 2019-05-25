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
public class Revista {

    private int n_registro;
    private String titulo;
    private int periodicidad;
    private String tipo;
    private int n_revista;

    public Revista(int n_registro, String titulo, int periodicidad, String tipo, int n_revista) {
        this.n_registro = n_registro;
        this.titulo = titulo;
        this.periodicidad = periodicidad;
        this.tipo = tipo;
        this.n_revista = n_revista;
    }

    public Revista(String titulo, int periodicidad, String tipo, int n_revista) {
        this.titulo = titulo;
        this.periodicidad = periodicidad;
        this.tipo = tipo;
        this.n_revista = n_revista;
    }

    public int getN_registro() {
        return n_registro;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getN_revista() {
        return n_revista;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }

}
