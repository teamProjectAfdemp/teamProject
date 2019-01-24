package com.teamproject.db;

import com.teamproject.db.core.Database;
import com.teamproject.bean.Post;
import com.teamproject.db.Interface.PostDAOinterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PostDAO extends Database implements PostDAOinterface{
    
    private static PostDAO postDAO = null;

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
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    @Override
    public HashMap<Integer, Post> selectAllPosts() {
        String query = "SELECT * FROM `teamproject`.`Posts`;";
        return getPostfromQuery(query);
    }
    
    @Override
    public HashMap<Integer, Post> selectPostsByRouteId(int id) {
       String query = "SELECT * FROM `teamproject`.`Posts` WHERE `route_id` = '"+ id + "' ORDER BY `created` ASC ;";        
       return getPostfromQuery(query);
    }
    
    @Override
    public HashMap<Integer, Post> getPostfromQuery(String query) {
        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        HashMap<Integer, Post> postFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Post post = new Post();
            post.setId((Integer) row.get("id"));
            post.setRoute_id((Integer) row.get("route_id"));
            post.setUser_id((Integer) row.get("user_id"));
            post.setPost((String) row.get("post"));
            post.setCreated( ((Date) row.get("created")).toString());
            postFound.put(post.getId(), post);
        }
        return postFound;
    }    
    
    @Override
    public Post getPostById(int id) {
        Post post = new Post();
        String query = ("SELECT * FROM `teamproject`.`Posts` WHERE `id` = '" + id + "';");

        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);
        
        for (Map<String, Object> row : answer) {
            post.setId( (Integer) row.get("id"));
            post.setRoute_id((Integer) row.get("route_id"));
            post.setUser_id((Integer) row.get("user_id"));
            post.setPost((String) row.get("post"));
        }
        return post;
    }
}
