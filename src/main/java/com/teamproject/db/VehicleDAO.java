package com.teamproject.db;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Vehicle;
import com.teamproject.db.Interface.ParticipantDAOinterface;
import com.teamproject.db.Interface.VehicleDAOinterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class VehicleDAO extends Database implements VehicleDAOinterface{

    public static VehicleDAO vehicleDAO = null;

    private VehicleDAO() {
    }

    public static VehicleDAO getInstance() {
        if (vehicleDAO == null) {
            vehicleDAO = new VehicleDAO();
        }
        return vehicleDAO;
    }

    public void createVehicle(String type, int passengers){
        
    }
    
    public void updateVehicle(int id, String type, int passengers){
        
    }
    
    public void deleteVehicle(){
        
    }
    
    public void deleteVehicleById(int id){
        
    }
    
    
    public HashMap<Integer,Vehicle> selectAllVehicles() {
        
        return new HashMap<Integer,Vehicle>();
    }

}
    