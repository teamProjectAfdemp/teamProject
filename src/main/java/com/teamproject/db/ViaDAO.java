/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.db;

import com.teamproject.bean.Vehicle;
import com.teamproject.bean.Via;
import com.teamproject.db.Interface.ViaDAOinterface;
import java.util.HashMap;

/**
 *
 * @author Takis
 */
public class ViaDAO extends Database implements ViaDAOinterface {
    
    public static ViaDAO viaDAO = null;

    private ViaDAO() {
    }

    public static ViaDAO getInstance() {
        if (viaDAO == null) {
            viaDAO = new ViaDAO();
        }
        return viaDAO;
    }

    public void createVia(int route_id, int vehicle_id){
         
     }
    public void updateVia(int id, int route_id, int vehicle_id){
        
    }
    
    public void deleteVia(){
        
    }
    
    public void deleteViaById(int id){
        
    }
    
    public HashMap<Integer,Via> selectAllVias() {
        
        return new HashMap<Integer,Via>();
    }
    
    
}
