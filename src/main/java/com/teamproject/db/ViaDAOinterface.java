package com.teamproject.db;


public interface ViaDAOinterface {
    void createVia(int route_id, int vehicle_id);
    void updateVia(int id, int route_id, int vehicle_id);
    void deleteVia();
    void deleteViaById(int id);
}
