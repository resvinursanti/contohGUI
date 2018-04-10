/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Evi
 */
public class HistoryGadaiDAO {
    private  Session session;
    private Transaction transaction;
    private SessionFactory factory;
    public FunctionsDAO fdao;
    
    public HistoryGadaiDAO() {
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
    }
    public Object getById(String Id) {
        return fdao.getById("from HISTORY_GADAI where idHistorygadai='" + Id + "'");
    }
    
}
