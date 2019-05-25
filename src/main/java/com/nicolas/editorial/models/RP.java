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
public class RP {

    private Revista revista;
    private Periodista periodista;

    public RP(Revista revista, Periodista periodista) {
        this.revista = revista;
        this.periodista = periodista;
    }

    public Revista getRevista() {
        return revista;
    }

    public Periodista getPeriodista() {
        return periodista;
    }

}
