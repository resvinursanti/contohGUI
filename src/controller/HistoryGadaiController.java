/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GadaiDAO;
import dao.HistoryGadaiDAO;

/**
 *
 * @author Evi
 */
public class HistoryGadaiController {
    
    
    private final HistoryGadaiDAO hgDAO;
    private final GadaiDAO Gdao;
    
     public HistoryGadaiController() {
        this.hgDAO = new HistoryGadaiDAO();
        this.Gdao = new GadaiDAO();
    }
    
}
