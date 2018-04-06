/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AngsuranGadaiDAO;
import entities.Angsurangadai;
import entities.Customer;
import entities.Gadai;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evi
 */
public class AngsuranGadaiController {
    AngsuranGadaiDAO aDAO = new AngsuranGadaiDAO();

public boolean insert(String idAngsuran, String idGadai, String idCust, String tglAngsur, Integer jmlAngsur, Integer denda )
{
    Angsurangadai a = new Angsurangadai();
    a.setIdAngsuran(idAngsuran);
    a.setIdGadai(new Gadai(idGadai));
    a.setIdCust(new Customer(idCust));
    a.setTglAngsur(new java.sql.Date(new Long(tglAngsur)));
    a.setJmlAngsur(jmlAngsur);
    a.setDenda(denda);
    return aDAO.insert(a);
}

public boolean update(String idAngsuran,String idGadai,  String idCust, String tglAngsur, Integer jmlAngsur, Integer denda)
{
    Angsurangadai a = new Angsurangadai();
    a.setIdAngsuran(idAngsuran);
    a.setIdGadai(new Gadai(idGadai));
    a.setIdCust(new Customer(idCust));
    a.setTglAngsur(new java.sql.Date(new Long(tglAngsur)));
    a.setJmlAngsur(jmlAngsur);
    a.setDenda(denda);
    return aDAO.update(a);
}

 public boolean delete(String id) {
        return aDAO.delete(id);
    }
    
 public void bindingAll(JTable table, String[] header)
    {
        bindingTabels(table, header, aDAO.getAll());
    }

 public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTabels(table, header, aDAO.search(category, cari));  
    }  
 private void bindingTabels(JTable tabel, String[] header, List<Object> datas) {
        Angsurangadai l;
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            l = (Angsurangadai) data;
            Object[] data1 = {
                l.getIdAngsuran(),
                l.getIdGadai(),
                l.getIdCust(),
                l.getTglAngsur(),
                l.getJmlAngsur(),
                l.getDenda(),
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
    }
}