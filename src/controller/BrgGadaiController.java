/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BrgGadaiDAO;
import dao.JenisBrgDAO;
import entities.BrgGadai;
import entities.JenisBrg;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evi
 */
public class BrgGadaiController {
  
    private final BrgGadaiDAO bDAO;
    private final JenisBrgDAO jdao;
    
    public BrgGadaiController() {
        this.bDAO = new BrgGadaiDAO();
        this.jdao = new JenisBrgDAO();
    }
   
public void bindingSearch(JTable table, String[] header, String category, String cari){
         String search = cari;
         if (category.equalsIgnoreCase("idJns")) {
                JenisBrg co = (JenisBrg) jdao.search("nmJns", cari).get(0);                
                search = co.getIdJns();
            }
            bindingTabels(table, header, bDAO.search(category, search));
        }


 public List <String> bindingAll(JTable table, String[] header)
    {
        return bindingTabels(table, header, bDAO.getAll());
    }
 
 /**
  * 
  * @param tabel
  * @param header
  * @param bindingTabels untuk menampilkan data yg akan ditampilkan pada bindingall
  */
 
 private List <String> bindingTabels(JTable tabel, String[] header, List<Object> datas) {
      //  BrgGadai l;
        List<String> dataJenis = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            BrgGadai l = (BrgGadai) data;
       //     l = (BrgGadai) data;
            dataJenis.add(l.getIdJns().getIdJns() +" - " + l.getIdJns().getNmJns());
            
            Object[] data1 = {
                i++,
                l.getIdBarang(),
                l.getIdJns().getNmJns(),
                l.getNmBarang(),
                l.getBerat(),
                l.getKualitas()
            };
            model.addRow(data1);
        }
        tabel.setModel(model);
        return dataJenis;
    }
 
 /**
  * 
  * @param idBarang
  * @param idJns
  * @param nmBarang
  * @param berat
  * @param kualitas
  * @param isSave
  * @return save untuk menyimpan data pada tabel brgGadai
  */
   public boolean save(String idBarang,  String idJns, String nmBarang, String berat, String kualitas,  boolean isSave){
        BrgGadai brg = new BrgGadai(idBarang, nmBarang, berat, kualitas);
        String[] bgId = idJns.split(" ");
        brg.setIdJns((JenisBrg) jdao.getById(bgId[0]));
        if (isSave) return bDAO.insert(brg);
        return bDAO.update(brg);
}
   /** 
    * 
    * @param loadJenis untuk menampilkan relasi antara jenis barang dengan tabel brggadai
    */
   public void loadJenis (JComboBox jComboBox) {
        jComboBox.addItem(" - ");
        jdao.getAll().stream().map((object) -> (JenisBrg) object).forEachOrdered((jenisBrg) -> {
            jComboBox.addItem(jenisBrg.getIdJns()+" - "
                    + jenisBrg.getNmJns());
        });
   }
   
   /**
    * 
    * @param idBarang
    * @return delete untuk menghapus data di tabel brgGadai berdasarkan id
    */
        
   public boolean delete(String idBarang) 
   {
        return bDAO.delete(idBarang);
    }
}

