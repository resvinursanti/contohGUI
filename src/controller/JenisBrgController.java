/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JenisBrgDAO;
import entities.JenisBrg;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evi
 */
public class JenisBrgController {
    
   JenisBrgDAO jbDAO = new JenisBrgDAO();
   
   public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTabels(table, header, jbDAO.search(category, cari));  
    }  
 
 public void bindingAll(JTable table, String[] header)
    {
        bindingTabels(table, header, jbDAO.getAll());
    }
 
 private void bindingTabels(JTable tabel, String[] header, List<Object> datas) {
        JenisBrg l;
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            l = (JenisBrg) data;
            Object[] data1 = {
                l.getIdJns(),
                l.getNmJns()
                
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
    }
}


   
