/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Customer;
import dao.CustomerDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TAMU
 */
public class CustomerController {
    CustomerDAO cc = new CustomerDAO();

    public boolean insert(String idCust, Long noKtp, String nmCust, Long noTelp, String pekerjaan, String Alamat){
        Customer c = new Customer();
        c.setIdCust(idCust);
        c.setNoKtp(noKtp);
        c.setNmCust(nmCust);
        c.setNoTelp(noTelp);
        c.setPekerjaan(pekerjaan);
        c.setAlamat(Alamat);
        return cc.insert(c);
    }
    
    public boolean update(String idCust, Long noKtp, String nmCust, Long noTelp, String pekerjaan, String Alamat){
        Customer c = new Customer();
        c.setIdCust(idCust);
        c.setNoKtp(noKtp);
        c.setNmCust(nmCust);
        c.setNoTelp(noTelp);
        c.setPekerjaan(pekerjaan);
        c.setAlamat(Alamat);
        return cc.update(c);
    }
    
    public boolean delete(String id){
        return cc.delete(id);
    }
    public void bindingTabels(JTable table, String[] header, List<Object> datas){
        Customer c;
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas){
            c = (Customer) data;
            Object[] datac={
                c.getIdCust(),
                c.getNoKtp(),
                c.getNmCust(),
                c.getNoTelp(),
                c.getPekerjaan(),
                c.getAlamat()
            };
            model.addRow(datac);
        }
        table.setModel(model);
    }
    
    public void bindingAll(JTable table, String[] header){
        bindingTabels(table, header, cc.getAll());
    }
    
    public void bindingSearch(JTable table, String[] header, String Category, String Cari){
        bindingTabels(table, header, cc.search(Category, Cari));
    }
    
}
