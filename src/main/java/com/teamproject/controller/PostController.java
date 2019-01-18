package com.teamproject.controller;

import com.teamproject.bean.Post;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.PostDAO;
import com.teamproject.db.RouteDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("/addpost")
    public ModelAndView getAddPost(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "addpost");

        return model;
    }

    @PostMapping("/addpost")
    public ModelAndView postAddPost(Post post, HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");

        PostDAO postDAO = PostDAO.getInstance();
//        UserDAO userDao = UserDAO.getInstance();
        // if user exists reload page!
//       if  (userDao.checkUser(user.getUsername()) != 0)
//           return new ModelAndView("redirect:/signup");
        // if user is created go to login page
        if (postDAO.createPost(post) != 0) {
            return new ModelAndView("redirect:/login");
        } else {
            return new ModelAndView("error");
        }
    }
    
//    @GetMapping("/edipost{id}")
//    public ModelAndView getEditPost(@PathVariable("id") int id, Post updatedPost) {
//
//        if (session().getAttribute("curUser") == null)
//            return new ModelAndView("redirect:/");
//
//        System.out.println(id);
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
