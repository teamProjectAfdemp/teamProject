package com.teamproject.db.Interface;

import com.teamproject.bean.Post;
import java.util.HashMap;


public interface PostDAOinterface {
    int createPost(Post post);
    void updatePost(int id, int route_id, int user_id, String post);
    void deletePost();
    void deletePostById(int id);
    
    HashMap<Integer,Post> selectPostsByRouteId(Post post);
    HashMap<Integer,Post> selectAllPosts();
    HashMap<Integer,Post> selectPostsByUserId(Post post);
}
