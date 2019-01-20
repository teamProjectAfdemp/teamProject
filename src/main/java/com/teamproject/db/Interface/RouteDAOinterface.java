package com.teamproject.db.Interface;

import com.teamproject.bean.Route;
import java.util.Date;


public interface RouteDAOinterface {
    int createRoute(Route route);
    void updateRoute(int id, int creator_id, String departure, String destination, Date dep_time, Date ar_time, String description);
    void deleteRoute();
    void deleteRouteById(int id);
    Route selectRouteById(int id);
}
