package com.teamproject.db.Interface;


public interface PostDAOinterface {
    void createPost(int route_id, int user_id, String post);
    void updatePost(int id, int route_id, int user_id, String post);
    void deletePost();
    void deletePostById(int id);
}
