/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.models;

import java.sql.Timestamp;

/**
 *
 * @author nicolas
 */
public class NumRevista {

    private int numero;
    private int n_ejemplares;
    private int n_paginas;
    private Timestamp fecha;

    public NumRevista(int numero, int n_ejemplares, int n_paginas, Timestamp fecha) {
        this.numero = numero;
        this.n_ejemplares = n_ejemplares;
        this.n_paginas = n_paginas;
        this.fecha = fecha;
    }

    public NumRevista(int n_ejemplares, int n_paginas, Timestamp fecha) {
        this.n_ejemplares = n_ejemplares;
        this.n_paginas = n_paginas;
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public int getN_ejemplares() {
        return n_ejemplares;
    }

    public int getN_paginas() {
        return n_paginas;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getNumero()); 
    }
    
    
    
}
