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
public class TmEmpleado implements TableModel {

    private List<Empleado> empleadoList;

    public TmEmpleado(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int getRowCount() {
        return empleadoList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Dni";
            case 1:
                return "Nombre";
            case 2:
                return "Telefono";
            default:
                return "Direccion";
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
        Empleado emp = empleadoList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return emp.getDni();
            case 1:
                return emp.getNombre();
            case 2:
                return emp.getTelefono();
            default:
                return emp.getDireccion();
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
