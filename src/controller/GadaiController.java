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
import java.util.ArrayList;
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
    
    /**
     * 
     * @param idGadai
     * @param idCust
     * @param idBrg
     * @param jmlPinjaman
     * @param tglPengajuan
     * @param status
     * @param sisa
     * @param isSave
     * @return save untuk menyimpan data pada tabel gadai
     */
    
    public boolean save(String idGadai, String idCust, String idBrg, Long jmlPinjaman, String tglPengajuan, Long sisa, String status, boolean isSave){
        Gadai ang = new Gadai(idGadai, jmlPinjaman, (new java.sql.Date(new Long(tglPengajuan))), sisa, status);
        String[] csId = idCust.split(" ");
        String[] brgId = idBrg.split(" ");
   //     String[] hsgId = idHistorygadai.split(" ");
        ang.setIdCust((Customer) cDAO.getById(csId[0]));
        ang.setIdBarang((BrgGadai) bgDAO.getById(brgId[0]));
 //       ang.setIdHistorygadai((HistoryGadai)hgDAO.getById(hsgId[0]));
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

    /**
     * 
     * @param id
     * @return delete untuk mengapus data pada tabel gadai
     */
 public boolean delete(String id) {
        return gDAO.delete(id);
    }
    
 public List <String> bindingAll(JTable table, String[] header)
    {
        return bindingTabels(table, header, gDAO.getAll());
    }

 
 /**
  * 
  * @param table
  * @param header
  * @param category
  * @param cari 
  * @return bindingSearch untuk mencari data pada tabel gadai
  */
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
//             else if(category.equalsIgnoreCase("idHistorygadai")) {
//                HistoryGadai r = (HistoryGadai) hgDAO.search("status", cari).get(0);                
//                search = r.getIdHistorygadai();
//             }
//     
            bindingTabels(table, header, gDAO.search(category, search));
        }

 /**
  * 
  * @param tabel
  * @param header
  * @param datas
  * @return bindingTabels untuk menampilkan data pada tabel gadai
  */
 private List<String> bindingTabels(JTable tabel, String[] header, List<Object> datas) {
        List<String> dataJenis = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            Gadai g = (Gadai) data;
            dataJenis.add(g.getIdCust().getIdCust() +" - "+g.getIdCust().getNmCust() + ";" + g.getIdBarang().getIdBarang() +" - "+ g.getIdBarang().getNmBarang());
    //        dataJenis.add(g.getIdHistorygadai().getIdHistorygadai() +" - "+g.getIdHistorygadai().getStatus());
            Object[] data1 = {
                g.getIdGadai(),
                g.getIdCust().getNmCust(),
                g.getIdBarang().getNmBarang(),
                g.getJmlPinjaman(),
                g.getTglPengajuan(),
                g.getSisa(),
                g.getStatus()
    //            g.getIdHistorygadai().getStatus()
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
        return dataJenis;
    }
 
 /**
  * 
  * @param loadBarang untuk menampilkan relasi antara tabel barang dan gadai pada combobox
  */
     public void loadBarang (JComboBox jComboBox) {
         
       jComboBox.addItem(" - ");
        bgDAO.getAll().stream().map((object) -> (BrgGadai) object).forEachOrdered((brgGadai) -> {
       jComboBox.addItem(brgGadai.getIdBarang()+" - " 
            +brgGadai.getNmBarang());
        });
   }
     
     /**
      * 
      * @param loadCustomer untuk menampilkan relasi antara tabel customer dan gadai pada combobox
      */
      public void loadCustomer (JComboBox jComboBox) {
           jComboBox.addItem(" - ");
        cDAO.getAll().stream().map((object) -> (Customer) object).forEachOrdered((customer) -> {
            jComboBox.addItem(customer.getIdCust()+" - "
                    +customer.getNmCust());
        });
   }
      
//       public void loadHistory (JComboBox jComboBox) {
//           jComboBox.addItem(" - ");
//        hgDAO.getAll().stream().map((object) -> (HistoryGadai) object).forEachOrdered((historygadai) -> {
//            jComboBox.addItem(historygadai.getIdHistorygadai()+" - "
//                    +historygadai.getStatus());
//        });
//   }
}
