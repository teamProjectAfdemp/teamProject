package com.teamproject.db;


public interface VehicleDAOinterface {
    void createVehicle(String type, int passengers);
    void updateVehicle(int id, String type, int passengers);
    void deleteVehicle();
    void deleteVehicleById(int id);
}
