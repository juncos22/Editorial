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
public class TmRevista implements TableModel {

    private List<Revista> revistas;

    public TmRevista(List<Revista> revistas) {
        this.revistas = revistas;
    }

    @Override
    public int getRowCount() {
        return revistas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "N° Registro";
            case 1:
                return "Titulo";
            case 2:
                return "Periodicidad";
            case 3:
                return "Tipo";
            default:
                return "N° Revista";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Revista rev = revistas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rev.getN_registro();
            case 1:
                return rev.getTitulo();
            case 2:
                return rev.getPeriodicidad();
            case 3:
                return rev.getTipo();
            default:
                return rev.getN_revista();
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
