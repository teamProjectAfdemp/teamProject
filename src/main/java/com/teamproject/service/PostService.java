/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.service;

import com.teamproject.bean.Post;
import java.util.List;

/**
 *
 * @author Takis
 */
public interface PostService {
    
    boolean addPost(Post post);
    boolean updatePost(Post post);
    List<Post> findRoutePosts(int routeid);
   
}
