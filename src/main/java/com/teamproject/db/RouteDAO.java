package com.teamproject.db;

import com.teamproject.db.Interface.RouteDAOinterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class RouteDAO extends Database implements RouteDAOinterface{
    
    public static RouteDAO routeDAO = null;

    private RouteDAO() {
    }

    public static RouteDAO getInstance() {
        if (routeDAO == null) {
            routeDAO = new RouteDAO();
        }
        return routeDAO;
    }

    @Override
    public void createRoute(int creator_id, String departure, String destination, Date dep_time, Date ar_time, String description) {
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query =  "INSERT INTO `Routes` (`creator_id`,`departure`,`destination`,`dep_time`,`ar_time`,`description`)"+
                        "VALUES (?,?,?,?,?,?);";
        try {
            prest = conn.prepareStatement(query);
            prest.setInt(1,1);
            prest.setString(2,"athens");
            prest.setString(3,"mykonos");
            prest.setString(4,"NOW()");
            prest.setString(5,"NOW()");
            prest.setString(4,"Nixtes Sti Mikono");
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return rowsInserted;
    }

    @Override
    public void updateRoute(int id, int creator_id, String departure, String destination, Date dep_time, Date ar_time, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRoute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRouteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
