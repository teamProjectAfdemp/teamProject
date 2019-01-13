package com.teamproject.db.Interface;

import java.util.Date;


public interface RouteDAOinterface {
    void createRoute(int creator_id, String departure, String destination, Date dep_time, Date ar_time, String description);
    void updateRoute(int id, int creator_id, String departure, String destination, Date dep_time, Date ar_time, String description);
    void deleteRoute();
    void deleteRouteById(int id);
}
