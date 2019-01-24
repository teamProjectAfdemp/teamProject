package com.teamproject.db.Interface;

import com.teamproject.bean.Post;
import java.util.HashMap;

public interface PostDAOinterface {
    public int createPost(Post post);
    public HashMap<Integer, Post> selectAllPosts();
    public HashMap<Integer, Post> selectPostsByRouteId(int id);
    public HashMap<Integer, Post> getPostfromQuery(String query);
    public Post getPostById(int id);
}
