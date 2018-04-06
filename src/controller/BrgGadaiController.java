/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BrgGadaiDAO;
import entities.BrgGadai;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evi
 */
public class BrgGadaiController {
   BrgGadaiDAO bDAO = new BrgGadaiDAO();
   
public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTabels(table, header, bDAO.search(category, cari));  
    }  
 
 public void bindingAll(JTable table, String[] header)
    {
        bindingTabels(table, header, bDAO.getAll());
    }
 
 private void bindingTabels(JTable tabel, String[] header, List<Object> datas) {
        BrgGadai l;
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            l = (BrgGadai) data;
            Object[] data1 = {
                l.getIdBarang(),
                l.getIdJns(),
                l.getNmBarang(),
                l.getBerat(),
                l.getKualitas()
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
    }
}

