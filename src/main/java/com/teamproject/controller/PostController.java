package com.teamproject.controller;

import com.teamproject.bean.Post;
import com.teamproject.bean.User;
import com.teamproject.db.PostDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    User curUser;

    @GetMapping("/allposts")
    public ModelAndView getAllPost(HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewPosts");

        ArrayList<Post> allPosts = new ArrayList<>();

        PostDAO postDAO = PostDAO.getInstance();
        HashMap<Integer, Post> allPostMap = postDAO.selectAllPosts();

        allPostMap.forEach((k, v) -> allPosts.add(v));

        model.addObject("allPosts", allPosts);

        return model;
    }


    @PostMapping("/addpost")
    public ModelAndView postAddPost(Post post, HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");

        PostDAO.getInstance().createPost(post);
       
        return new ModelAndView("redirect:/route/"+post.getRoute_id());
    }
    
//    @GetMapping("/edipost/{id}")
//    public ModelAndView getEditPost(@PathVariable("id") int id, Post updatedPost, HttpServletRequest request) {
//
//         // if user's cookie does not match got to login page!
//        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
//
//        Post postToEdit =  PostDAO.getInstance().getPostById( id );
//
//        ModelAndView model = new ModelAndView("template");
//        model.addObject("includeView", "editpostform");
//        model.addObject("postToEdit",postToEdit);
//
//        return  model;
//    }
//
//    @PostMapping("/updatepost")
//    public ModelAndView postEditPost(@ModelAttribute("updatedPost")Post updatedPost){
//
//        if (session().getAttribute("curUser") == null)
//            return new ModelAndView("redirect:/");
//
//        System.out.println(updatedPost.getId());
//        int updated = PostDAO.getInstance().updatePost(updatedPost);
//
//        return new ModelAndView("redirect:/allpost");
//    }
//
//    @GetMapping("/deletepost{id}")
//    public ModelAndView postDeletePost(@ModelAttribute("postToDelete")Post postToDelete){
//
//        if (session().getAttribute("curUser") == null)
//            return new ModelAndView("redirect:/");
//
//        int updated = PostDAO.getInstance().deletePost(postToDelete);
//
//        return new ModelAndView("redirect:/allpost");
//    }
}
