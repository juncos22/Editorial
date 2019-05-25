/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicolas.editorial.models;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author nicolas
 */
public class TmSucursal implements TableModel {

    private List<Sucursal> sucursales;

    public TmSucursal(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public int getRowCount() {
        return sucursales.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Codigo";
            case 1:
                return "Telefono";
            case 2:
                return "Domicilio";
            case 3:
                return "Dni Empleado";
            default:
                return "N° Registro";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex != 0 && columnIndex != 4) {
            return String.class;
        } else {
            return Integer.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sucursal suc = sucursales.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return suc.getCodigo();
            case 1:
                return suc.getTelefono();
            case 2:
                return suc.getDomicilio();
            case 3:
                return suc.getDni_emp();
            default:
                return suc.getN_registro();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
