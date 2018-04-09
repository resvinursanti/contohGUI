/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AngsuranGadaiDAO;
import dao.CustomerDAO;
import dao.GadaiDAO;
import entities.Angsurangadai;
import entities.Customer;
import entities.Gadai;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evi
 */
public class AngsuranGadaiController {
    
    private final AngsuranGadaiDAO aDAO;
    private final GadaiDAO gDAO;
    private final CustomerDAO cDAO;

    public AngsuranGadaiController() {
        this.aDAO = new AngsuranGadaiDAO();
        this.gDAO = new GadaiDAO();
        this.cDAO = new CustomerDAO();
    }
    
     public boolean save(String idAngsuran, String idGadai, String idCust, String tglAngsur, Integer jmlAngsur, Integer denda, boolean isSave){
        Angsurangadai ang = new Angsurangadai(idAngsuran, new java.sql.Date(new Long(tglAngsur)), jmlAngsur, denda);
        String[] gdId = idGadai.split(" ");
        String[] csId = idCust.split(" ");
        ang.setIdGadai((Gadai) gDAO.getById(gdId[0]));
        ang.setIdCust((Customer) cDAO.getById(csId[0]));
        if (isSave) return aDAO.insert(ang);
        return aDAO.update(ang);
}
      public void loadGadai (JComboBox jComboBox) {
        gDAO.getAll().stream().map((object) -> (Gadai) object).forEachOrdered((gadai) -> {
            jComboBox.addItem(gadai.getIdGadai());
        });
   }
      public void loadCustomer (JComboBox jComboBox) {
        cDAO.getAll().stream().map((object) -> (Customer) object).forEachOrdered((customer) -> {
            jComboBox.addItem(customer.getIdCust()+" - "
                    +customer.getNmCust());
        });
   }
//public boolean insert(String idAngsuran, String idGadai, String idCust, String tglAngsur, Integer jmlAngsur, Integer denda )
//{
//    Angsurangadai a = new Angsurangadai();
//    a.setIdAngsuran(idAngsuran);
//    a.setIdGadai(new Gadai(idGadai));
//    a.setIdCust(new Customer(idCust));
//    a.setTglAngsur(new java.sql.Date(new Long(tglAngsur)));
//    a.setJmlAngsur(jmlAngsur);
//    a.setDenda(denda);
//    return aDAO.insert(a);
//}
//
//public boolean update(String idAngsuran,String idGadai,  String idCust, String tglAngsur, Integer jmlAngsur, Integer denda)
//{
//    Angsurangadai a = new Angsurangadai();
//    a.setIdAngsuran(idAngsuran);
//    a.setIdGadai(new Gadai(idGadai));
//    a.setIdCust(new Customer(idCust));
//    a.setTglAngsur(new java.sql.Date(new Long(tglAngsur)));
//    a.setJmlAngsur(jmlAngsur);
//    a.setDenda(denda);
//    return aDAO.update(a);
//}

 public boolean delete(String id) {
        return aDAO.delete(id);
    }
    
 public void bindingAll(JTable table, String[] header)
    {
        bindingTabels(table, header, aDAO.getAll());
    }

 public void bindingSearch(JTable table, String[] header, String category, String cari){
         String search = cari;
             if (category.equalsIgnoreCase("idCust")) {
                Customer r = (Customer) cDAO.search("nmCust", cari).get(0);                
                search = r.getIdCust();   
         }
     
            bindingTabels(table, header, aDAO.search(category, search));
        }
 
 private void bindingTabels(JTable tabel, String[] header, List<Object> datas) {
      DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            Angsurangadai l = (Angsurangadai) data;
            Object[] data1 = {
                l.getIdAngsuran(),
                l.getIdGadai(),
                l.getIdCust().getNmCust(),
                l.getTglAngsur(),
                l.getJmlAngsur(),
                l.getDenda()
                
                
      //          if (l.getTglAngsur <= Date) {
                
          //  }
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
    }
}