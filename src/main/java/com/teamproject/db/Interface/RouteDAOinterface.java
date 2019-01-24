package com.teamproject.db.Interface;

import com.teamproject.bean.Route;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;


public interface RouteDAOinterface {
    int createRoute(Route route,MultipartFile filePart);
    void updateRoute(int id, int creator_id, String departure, String destination, Date dep_time, Date ar_time, String description);
    void deleteRoute();
    void deleteRouteById(int id);
    Route selectRouteById(int id);
}
