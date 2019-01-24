package com.teamproject.db.Interface;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface RouteDAOinterface {
    public ArrayList<Integer> getRoutesIdsList();
    public List<Integer> selectCreatedRoutesIds(int userId);
    public List<Integer> selectJoinedRoutesIds(int userId);
    public int createRoute(Route route, MultipartFile file);
    public HashMap<Integer, Route> selectAllRoutes();
    public HashMap<Integer, Route> selectAllCreatedRoutesById(User user);
    public HashMap<Integer, Route> selectAllJoinedRoutesById(User user);
    public HashMap<Integer, Route> getRoutefromQuery(String query);
    public Route getRouteById(int id);
    public int updateRoute(Route route);
    public Route selectRouteById(int id);
}
