/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.restcontroller;

import com.teamproject.bean.Post;
import com.teamproject.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Takis
 */
@RestController
public class PostServiceController {
    
    @Autowired
    PostService postService; 
    
    @RequestMapping(value = "/posts/{routeid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Post>> listRoutePosts( @PathVariable("routeid") int routeid ) {
        
        List<Post> routePosts;
        routePosts = postService.findRoutePosts(routeid);
    
        if(routePosts.isEmpty()){
            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        
        return new ResponseEntity<List<Post>>(routePosts, HttpStatus.OK);
    }
    
}
