/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GadaiDAO;
import entities.BrgGadai;
import entities.Customer;
import entities.Gadai;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TAMU
 */
public class GadaiController {
    GadaiDAO gdao = new GadaiDAO();
    
    public boolean insert(String idGadai, String idCust, String idBarang, Long jmlPinjaman, String tgl_pengajuan, String Status, Long Sisa)
{
    Gadai a = new Gadai();
    a.setIdGadai(idGadai);
    a.setIdCust(new Customer(idCust));
    a.setIdBarang(new BrgGadai(idBarang));
    a.setJmlPinjaman(jmlPinjaman);
    a.setTglPengajuan(new java.sql.Date(new Long(tgl_pengajuan)));
    a.setStatus(Status);
    a.setSisa(Sisa);
    return gdao.insert(a);
}

public boolean update(String idGadai, String idCust, String idBarang, Long jmlPinjaman, String tgl_pengajuan, String Status, Long Sisa)
{
    Gadai a = new Gadai();
    a.setIdGadai(idGadai);
    a.setIdCust(new Customer(idCust));
    a.setIdBarang(new BrgGadai(idBarang));
    a.setJmlPinjaman(jmlPinjaman);
    a.setTglPengajuan(new java.sql.Date(new Long(tgl_pengajuan)));
    a.setStatus(Status);
    a.setSisa(Sisa);
    return gdao.update(a);
}

 public boolean delete(String id) {
        return gdao.delete(id);
    }
    
 public void bindingAll(JTable table, String[] header)
    {
        bindingTabels(table, header, gdao.getAll());
    }

 public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTabels(table, header, gdao.search(category, cari));  
    }  
 private void bindingTabels(JTable tabel, String[] header, List<Object> datas) {
        Gadai g;
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            g = (Gadai) data;
            Object[] data1 = {
                g.getIdGadai(),
                g.getIdCust(),
                g.getIdBarang(),
                g.getJmlPinjaman(),
                g.getTglPengajuan(),
                g.getStatus(),
                g.getSisa()
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
    }
}
