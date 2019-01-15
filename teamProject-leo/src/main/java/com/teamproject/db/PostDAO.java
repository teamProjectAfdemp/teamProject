package com.teamproject.db;

import com.teamproject.bean.Post;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import com.teamproject.db.Interface.PostDAOinterface;
import com.teamproject.db.Interface.RouteDAOinterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PostDAO extends Database implements PostDAOinterface{
    
    public static PostDAO postDAO = null;

    private PostDAO() {
    }

    public static PostDAO getInstance() {
        if (postDAO == null) {
            postDAO = new PostDAO();
        }
        return postDAO;
    }

    @Override
    public int createPost(Post post) {
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query =  "INSERT INTO `Posts` (`route_id`,`user_id`,`post`)"+
                        "VALUES (?,?,?);";
        try {
            prest = conn.prepareStatement(query);
            prest.setInt(1,post.getRoute_id());
            prest.setInt(2,post.getUser_id());
            prest.setString(3,post.getPost());
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowsInserted;
    }

    @Override
    public void updatePost(int id, int route_id, int user_id, String post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePostById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 public HashMap<Integer,Post> selectPostsByRouteId(Post post){
 Collection<Map<String, Object>> answer = new ArrayList<>();
 String query ="SELECT * FROM `teamproject`.`Posts`\n" +
" WHERE Posts.route_id=`"+post.getRoute_id()+"';";
        answer = getGenericSelect(query);

        HashMap<Integer, Post> postsFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Post tempPost = new Post();
            tempPost.setId((Integer) row.get("id"));
            tempPost.setRoute_id((Integer) row.get("route_id"));
            tempPost.setUser_id((Integer) row.get("user_id"));
            tempPost.setPost((String) row.get("post"));
            postsFound.put(tempPost.getId(), tempPost);
        }
        return postsFound;
 }
 
 public HashMap<Integer,Post> selectAllPosts(){
 Collection<Map<String, Object>> answer = new ArrayList<>();
 String query ="SELECT * FROM `teamproject`.`Posts`;";
        answer = getGenericSelect(query);

        HashMap<Integer, Post> postsFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Post temppost = new Post();
            temppost.setId((Integer) row.get("id"));
            temppost.setRoute_id((Integer) row.get("route_id"));
            temppost.setUser_id((Integer) row.get("user_id"));
            temppost.setPost((String) row.get("post"));
            postsFound.put(temppost.getId(), temppost);
        }
        return postsFound;
 }
 
 public HashMap<Integer,Post> selectPostsByUserId(Post post){
 Collection<Map<String, Object>> answer = new ArrayList<>();
 String query ="SELECT * FROM `teamproject`.`Posts`\n" +
" WHERE Posts.user_id=`"+post.getUser_id()+"';";
        answer = getGenericSelect(query);

        HashMap<Integer, Post> postsFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Post tempPost = new Post();
            tempPost.setId((Integer) row.get("id"));
            tempPost.setRoute_id((Integer) row.get("route_id"));
            tempPost.setUser_id((Integer) row.get("user_id"));
            tempPost.setPost((String) row.get("post"));
            postsFound.put(tempPost.getId(), tempPost);
        }
        return postsFound;
 }
}
