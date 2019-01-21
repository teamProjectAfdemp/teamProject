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
import java.util.HashMap;

public class JavaData {
    
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
    
    public static HashMap<Integer,String> getUsernamesFromPosts(ArrayList<Post> posts){
        HashMap<Integer,String> usernamesMap = new HashMap<Integer,String>();
        
        for (Post post: posts) {
            if ( !usernamesMap.containsKey(post.getUser_id()) )
                usernamesMap.put(post.getUser_id(), usersMap.get( post.getUser_id() ).getUsername());
        }
       
        return usernamesMap;
    }
    
     public static HashMap<Integer,String> getUsernamesFromParticipants(ArrayList<Participant> participants){
        HashMap<Integer,String> usernamesMap = new HashMap<Integer,String>();
        
        for (Participant participant: participants) {
            if ( !usernamesMap.containsKey(participant.getUser_id()) )
                usernamesMap.put( participant.getUser_id(), usersMap.get( participant.getUser_id() ).getUsername());
        }
       
        return usernamesMap;
    }
    
    
    
}
