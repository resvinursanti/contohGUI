/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BrgGadaiDAO;
import dao.CustomerDAO;
import dao.GadaiDAO;
import entities.BrgGadai;
import entities.Customer;
import entities.Gadai;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TAMU
 */
public class GadaiController {
    private final GadaiDAO gDAO;
    private final CustomerDAO cDAO;
    private final BrgGadaiDAO bgDAO;

    public GadaiController() 
    {
        this.gDAO = new GadaiDAO();
        this.cDAO = new CustomerDAO();
        this.bgDAO = new BrgGadaiDAO();
    }
    
    public boolean save(String idGadai, String idCust, String idBrg, Long jmlPinjaman, String tglPengajuan, String status,Long sisa, boolean isSave){
        Gadai ang = new Gadai(idGadai, jmlPinjaman, (new java.sql.Date(new Long(tglPengajuan))), status, sisa);
        String[] csId = idCust.split(" ");
        String[] brgId = idBrg.split(" ");
        ang.setIdCust((Customer) cDAO.getById(csId[0]));
        ang.setIdBarang((BrgGadai) bgDAO.getById(brgId[0]));
        if (isSave) return gDAO.insert(ang);
        return gDAO.update(ang);
}
    
//    public boolean insert(String idGadai, String idCust, String idBarang, Long jmlPinjaman, String tgl_pengajuan, String Status, Long Sisa)
//{
//    Gadai a = new Gadai();
//    a.setIdGadai(idGadai);
//    a.setIdCust(new Customer(idCust));
//    a.setIdBarang(new BrgGadai(idBarang));
//    a.setJmlPinjaman(jmlPinjaman);
//    a.setTglPengajuan(new java.sql.Date(new Long(tgl_pengajuan)));
//    a.setStatus(Status);
//    a.setSisa(Sisa);
//    return gdao.insert(a);
//}
//
//public boolean update(String idGadai, String idCust, String idBarang, Long jmlPinjaman, String tgl_pengajuan, String Status, Long Sisa)
//{
//    Gadai a = new Gadai();
//    a.setIdGadai(idGadai);
//    a.setIdCust(new Customer(idCust));
//    a.setIdBarang(new BrgGadai(idBarang));
//    a.setJmlPinjaman(jmlPinjaman);
//    a.setTglPengajuan(new java.sql.Date(new Long(tgl_pengajuan)));
//    a.setStatus(Status);
//    a.setSisa(Sisa);
//    return gdao.update(a);
//}

 public boolean delete(String id) {
        return gDAO.delete(id);
    }
    
 public void bindingAll(JTable table, String[] header)
    {
        bindingTabels(table, header, gDAO.getAll());
    }

 public void bindingSearch(JTable table, String[] header, String category, String cari){
             String search = cari;
             if (category.equalsIgnoreCase("idCust")) {
                Customer r = (Customer) cDAO.search("nmCust", cari).get(0);                
                search = r.getIdCust();   
                }
             else if (category.equalsIgnoreCase("idBarang")) {
                BrgGadai r = (BrgGadai) bgDAO.search("nmBarang", cari).get(0);                
                search = r.getIdBarang();   
                }
     
            bindingTabels(table, header, gDAO.search(category, search));
        }

 
 private void bindingTabels(JTable tabel, String[] header, List<Object> datas) {
       DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            Gadai g = (Gadai) data;
            Object[] data1 = {
                g.getIdGadai(),
                g.getIdCust().getNmCust(),
                g.getIdBarang().getNmBarang(),
                g.getJmlPinjaman(),
                g.getTglPengajuan(),
                g.getStatus(),
                g.getSisa()
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
    }
     public void loadBarang (JComboBox jComboBox) {
        bgDAO.getAll().stream().map((object) -> (BrgGadai) object).forEachOrdered((brgGadai) -> {
            jComboBox.addItem(brgGadai.getIdBarang()+" - " 
            +brgGadai.getNmBarang());
        });
   }
      public void loadCustomer (JComboBox jComboBox) {
        cDAO.getAll().stream().map((object) -> (Customer) object).forEachOrdered((customer) -> {
            jComboBox.addItem(customer.getIdCust()+" - "
                    +customer.getNmCust());
        });
   }
}
