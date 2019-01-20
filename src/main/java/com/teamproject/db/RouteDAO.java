package com.teamproject.db;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import com.teamproject.db.Interface.RouteDAOinterface;
import java.sql.Blob;
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
    public int createRoute(Route route) {
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query =  "INSERT INTO `Routes` (`creator_id`,`title`,`shortdesc`,`description`,`seats`,`dep_time`,`ar_time`,`image`)"+
                        "VALUES (?,?,?,?,?,?,?,?);";
        System.out.println(query);
        try {
            prest = conn.prepareStatement(query);
            prest.setInt(1,route.getCreator_id());
            prest.setString(2,route.getTitle());
            prest.setString(3,route.getShortdesc());
            prest.setString(4,route.getDescription());
            prest.setInt(5,route.getSeats());
            prest.setString(6,route.getDep_time());
            prest.setString(7,route.getAr_time());
            prest.setString(8,route.getImage());
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    @Override
    public void updateRoute(int id, int creator_id, String title, String shortdesc, Date dep_time, Date ar_time, String description) {
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
        return getRoutefromQuery(query);
    }

    public HashMap<Integer, Route> getRoutefromQuery(String query) {

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        HashMap<Integer, Route> routeFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Route route = new Route();
            route.setId((Integer) row.get("id"));
            route.setCreator_id((Integer) row.get("creator_id"));
            route.setTitle((String) row.get("title"));
            route.setShortdesc((String) row.get("shortdesc"));
            route.setDescription((String) row.get("description"));
            route.setSeats((Integer) row.get("seats"));
            route.setDep_time( (String) row.get("dep_time"));
            route.setAr_time( (String) row.get("ar_time") );
            //route.setCreated((String) row.get("created"));
            route.setImage((String) row.get("image"));
            routeFound.put(route.getId(), route);
        }
        return routeFound;
    }

    public Route getRouteById(int id) {
        Route route = new Route();

        String query = ("SELECT * FROM `teamproject`.`Routes` WHERE `id` = '" + id + "';");

        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);

        for (Map<String, Object> row : answer) {
            route.setId((Integer) row.get("id"));
            route.setCreator_id((Integer) row.get("creator_id"));
            route.setTitle((String) row.get("title"));
            route.setShortdesc((String) row.get("shortdesc"));
            route.setDescription((String) row.get("description"));
            route.setSeats((Integer) row.get("seats"));
            route.setDep_time( (String) row.get("dep_time"));
            route.setAr_time( (String) row.get("ar_time") );
            //route.setCreated((String) row.get("created"));
            route.setImage((String) row.get("image"));

            System.out.println(row.get("id"));
            System.out.println("ONE MORE USER");
        }

        System.out.println(route.getId());

        return route;
    }

    public int updateRoute(Route route) {

        String query = "UPDATE `teamproject`.`Routes` SET `title` = '" + route.getTitle()
                + "' ,`shortdesc` = '" + route.getShortdesc() + "' ,`description` = '" + route.getDescription()
                + "' ,`seats` = '" + route.getSeats() + "' ,`dep_time` = '" + route.getDep_time() 
                + "' ,`ar_time` = '" + route.getAr_time() + "' ,`image` = '" + route.getImage() +
                "' WHERE `id` = '" + route.getId() + "';";

        System.out.println(query);
        return execUpdateInsert(query);

    }

    public int deleteRoute(Route route) {

        String query = "DELETE FROM `teamproject`.`Routes` WHERE `id` = '" + route.getId() + "';";

        System.out.println(query);
        return execUpdateInsert(query);
    }
    
    public Route selectRouteById(int id){
        
        String query = "SELECT * FROM `teamproject`.`Routes` WHERE `id` = '" + id +"';";
        
        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);
        
        Route route =  new Route();
        
        for (Map<String, Object> row : answer) {
            route.setId((Integer) row.get("id"));
            route.setCreator_id((Integer) row.get("creator_id"));
            route.setTitle((String) row.get("title"));
            route.setShortdesc((String) row.get("shortdesc"));
            route.setDescription((String) row.get("description"));
            route.setSeats((Integer) row.get("seats"));
            route.setDep_time( (String) row.get("dep_time"));
            route.setAr_time( (String) row.get("ar_time") );
            //route.setCreated((String) row.get("created"));
            route.setImage((String) row.get("image"));
        }
        
        return route;
    }
}
