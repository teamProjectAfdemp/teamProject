/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.db;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Post;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JavaData extends Database{
    
    private static HashMap<Integer,User> usersMap;
    private static HashMap<Integer,Route> routesMap;
    private static HashMap<Integer,Post> postsMap;
    private static HashMap<Integer,Participant> routeHasUsers;
    
    static {
        usersMap = UserDAO.getInstance().selectAllUsers();
        routesMap = RouteDAO.getInstance().selectAllRoutes();
        postsMap = PostDAO.getInstance().selectAllPosts();
        routeHasUsers = ParticipantDAO.getInstance().selectAllParticipants();
    }
    
    public static ArrayList<User> selectAllUsers() {
        return new ArrayList<User>();
       
    }
    
}
