package com.teamproject.db;

import com.teamproject.db.core.Database;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.Interface.RouteDAOinterface;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public class RouteDAO extends Database implements RouteDAOinterface {

    private static RouteDAO routeDAO = null;
    private static ArrayList<Integer> routesIdsList = new ArrayList();

    private RouteDAO() {
    }

    public static RouteDAO getInstance() {
        if (routeDAO == null) {
            routeDAO = new RouteDAO();
            routeDAO.selectAllRoutesIds();
        }
        return routeDAO;
    }

    @Override
    public ArrayList<Integer> getRoutesIdsList() {
        return routesIdsList;
    }

    private void selectAllRoutesIds() {
        String query = "SELECT `id` FROM `teamproject`.`Routes`;";

        Collection<Map<String, Object>> answer = getGenericSelect(query);

        routesIdsList.clear();
        for (Map<String, Object> row : answer) {
            routesIdsList.add((Integer) row.get("id"));
        }
    }

    @Override
    public List<Integer> selectCreatedRoutesIds(int userId) {
        String query = "SELECT `id` FROM `teamproject`.`Routes` WHERE `creator_id` = '" + userId + "';";
        
        Collection<Map<String, Object>> answer = getGenericSelect(query);
        List<Integer> routes = new ArrayList();

        answer.forEach((row) -> routes.add((Integer) row.get("id")));

        return routes;
    }

    @Override
    public List<Integer> selectJoinedRoutesIds(int userId) {
        String query = "SELECT `Routes`.`id` FROM `Routes` \n"
                + "INNER JOIN `Participants` \n"
                + "ON `Participants`.`route_id`= `Routes`.`id`\n"
                + "WHERE `Participants`.`user_id` = '" + userId + "';";
        
        Collection<Map<String, Object>> answer = getGenericSelect(query);
        List<Integer> routes = new ArrayList();

        answer.forEach((row) -> routes.add((Integer) row.get("id")));

        return routes;
    }

    @Override
    public int createRoute(Route route, MultipartFile file) {
        User curUser = (User) session().getAttribute("curUser");
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query = "INSERT INTO `Routes` (`creator_id`,`title`,`shortdesc`,`description`,`seats`,`dep_time`,`ar_time`,`image`)"
                + "VALUES (?,?,?,?,?,?,?,?);";
        try {
            prest = conn.prepareStatement(query);
            prest.setInt(1, curUser.getId());
            prest.setString(2, route.getTitle());
            prest.setString(3, route.getShortdesc());
            prest.setString(4, route.getDescription());
            prest.setInt(5, route.getSeats());
            prest.setString(6, route.getDep_time());
            prest.setString(7, route.getAr_time());
            prest.setBlob(8, getBlobInputStream(file));
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // update usernames list if route was created
        if (rowsInserted > 0) {
            routeDAO.selectAllRoutesIds();
        }
        return rowsInserted;
    }

    private InputStream getBlobInputStream(MultipartFile filePart) {
        InputStream inputStream = null; // input stream of the upload file
        try {
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }
        return inputStream;
    }

    @Override
    public HashMap<Integer, Route> selectAllRoutes() {
        String query = "SELECT * FROM `teamproject`.`Routes`;";
        return getRoutefromQuery(query);
    }

    @Override
    public HashMap<Integer, Route> selectAllCreatedRoutesById(User user) {
        String query = ("SELECT * FROM `teamproject`.`Routes` WHERE `creator_id` = '" + user.getId() + "';");
        return getRoutefromQuery(query);
    }

    @Override
    public HashMap<Integer, Route> selectAllJoinedRoutesById(User user) {
        String query = ("SELECT Routes.* FROM teamproject.Routes INNER JOIN Participants on Participants.route_id=Routes.id "
                + " WHERE user_id = '" + user.getId() + "';");
        return getRoutefromQuery(query);
    }

    @Override
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
            route.setDep_time((String) row.get("dep_time"));
            route.setAr_time((String) row.get("ar_time"));
            route.setImage(stringFromBlob((byte[]) row.get("image")));
            routeFound.put(route.getId(), route);
        }
        return routeFound;
    }

    private String stringFromBlob(byte[] byteArray) {
        String base64Image = null;
        if (byteArray != null)  
            base64Image = Base64.getEncoder().encodeToString(byteArray);
        return base64Image;
    }

    @Override
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
            route.setDep_time((String) row.get("dep_time"));
            route.setAr_time((String) row.get("ar_time"));
            route.setImage(stringFromBlob((byte[]) row.get("image")));
        }
        return route;
    }
    
    @Override
    public int updateRoute(Route route) {
        String query = "UPDATE `teamproject`.`Routes` SET `title` = '" + route.getTitle()
                + "' ,`shortdesc` = '" + route.getShortdesc() + "' ,`description` = '" + route.getDescription()
                + "' ,`seats` = '" + route.getSeats() + "' ,`dep_time` = '" + route.getDep_time()
                + "' ,`ar_time` = '" + route.getAr_time() + "' WHERE `id` = '" + route.getId() + "';";
        return execUpdateInsert(query);
    }

    @Override
    public Route selectRouteById(int id) {
        String query = "SELECT * FROM `teamproject`.`Routes` WHERE `id` = '" + id + "';";

        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);
        Route route = new Route();

        for (Map<String, Object> row : answer) {
            route.setId((Integer) row.get("id"));
            route.setCreator_id((Integer) row.get("creator_id"));
            route.setTitle((String) row.get("title"));
            route.setShortdesc((String) row.get("shortdesc"));
            route.setDescription((String) row.get("description"));
            route.setSeats((Integer) row.get("seats"));
            route.setDep_time((String) row.get("dep_time"));
            route.setAr_time((String) row.get("ar_time"));
            route.setImage(stringFromBlob((byte[]) row.get("image")));
        }
        return route;
    }
}
