package com.teamproject.db;

import com.teamproject.bean.Route;
import com.teamproject.db.Interface.RouteDAOinterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
    public int createRoute(int creator_id, String departure, String destination, String description) {
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query =  "INSERT INTO `Routes` (`creator_id`,`departure`,`destination`,`dep_time`,`ar_time`,`description`)"+
                        "VALUES (?,?,?,?,?,?);";
        try {
            prest = conn.prepareStatement(query);
            prest.setInt(1,creator_id);
            prest.setString(2,departure);
            prest.setString(3,destination);
            prest.setString(4,"NOW()");
            prest.setString(5,"NOW()");
            prest.setString(6,description);
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
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
    
    public HashMap<Integer, Route> selectAllRoutes() {
        String query = "SELECT * FROM `teamproject`.`Routes`;";
        return getUsersfromQuery(query);
    }
    
    public HashMap<Integer, Route> getUsersfromQuery(String query) {

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        HashMap<Integer, Route> routeFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Route route = new Route();
            route.setId((Integer) row.get("id"));
            route.setCreator_id((Integer) row.get("creator_id"));
            route.setDeparture((String) row.get("departure"));
            route.setDestination((String) row.get("destination"));
            route.setDep_time( (Date) row.get("dep_time"));
            route.setAr_time( (Date) row.get("ar_time") );
            route.setDescription((String) row.get("description"));
            routeFound.put(route.getId(), route);
        }
        return routeFound;
    }
}
