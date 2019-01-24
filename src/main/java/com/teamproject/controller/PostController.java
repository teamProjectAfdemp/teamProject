package com.teamproject.controller;

import com.teamproject.bean.Post;
import com.teamproject.bean.User;
import com.teamproject.db.PostDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    User curUser;
    
    @GetMapping("/posts/{id}")
    public ModelAndView getRoutePosts(@PathVariable("id") int id, HttpServletRequest request){
         // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
        
        ArrayList<Post> routePosts = new ArrayList<>(PostDAO.getInstance().selectPostsByRouteId(id).values());
        
        ModelAndView model =  new ModelAndView("viewPosts");
        model.addObject("routePosts", routePosts);
        
        return model;
    }

    @PostMapping("/addpost")
    public ModelAndView postAddPost(Post post, HttpServletRequest request) {
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");

        PostDAO.getInstance().createPost(post);
       
        return new ModelAndView("redirect:/route/"+post.getRoute_id());
    }
}
