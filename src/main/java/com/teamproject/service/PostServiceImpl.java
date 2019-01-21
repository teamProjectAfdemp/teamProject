/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.service;

import com.teamproject.bean.Post;
import com.teamproject.db.PostDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Takis
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    public boolean addPost(Post post) {
        if ( PostDAO.getInstance().createPost(post) == 1) return true;
        return false;
    }

    public boolean updatePost(Post post) {
        return false;
    }

    public List<Post> findRoutePosts(int routeid) {
        
        HashMap<Integer,Post> postMap = PostDAO.getInstance().selectPostsByRouteId(routeid);

        List<Post> routePosts = new ArrayList<>();
        postMap.forEach((k, v) -> routePosts.add(v));

        return routePosts;
    }
}
