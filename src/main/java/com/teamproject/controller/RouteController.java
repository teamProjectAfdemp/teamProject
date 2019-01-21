package com.teamproject.controller;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import com.teamproject.db.PostDAO;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.JavaData;
import com.teamproject.db.ParticipantDAO;
import com.teamproject.db.RouteDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RouteController {

    User curUser;

    @RequestMapping("/allroutes")
    public ModelAndView getAllRoutes(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewRoutes");

        ArrayList<Route> allRoutes = new ArrayList<>();

        RouteDAO routeDAO = RouteDAO.getInstance();
        HashMap<Integer, Route> allRoutesMap = routeDAO.selectAllRoutes();

        allRoutesMap.forEach((k, v) -> allRoutes.add(v));

        model.addObject("allRoutes", allRoutes);

        return model;
    }

    @RequestMapping("/allcreatedroutes")
    public ModelAndView getAllJoinedRoutes(HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
        

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewRoutes");

        ArrayList<Route> allRoutes = new ArrayList<>();

        RouteDAO routeDAO = RouteDAO.getInstance();
        curUser = (User) session().getAttribute("curUser");
        HashMap<Integer, Route> allRoutesMap = routeDAO.selectAllCreatedRoutesById(curUser);

        allRoutesMap.forEach((k, v) -> allRoutes.add(v));

        model.addObject("allRoutes", allRoutes);

        return model;
    }
    
    @RequestMapping("/alljoinedroutes")
    public ModelAndView getAllCreatedRoutes(HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
        

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewRoutes");

        ArrayList<Route> allRoutes = new ArrayList<>();

        RouteDAO routeDAO = RouteDAO.getInstance();
        curUser = (User) session().getAttribute("curUser");
        HashMap<Integer, Route> allRoutesMap = routeDAO.selectAllJoinedRoutesById(curUser);

        allRoutesMap.forEach((k, v) -> allRoutes.add(v));

        model.addObject("allRoutes", allRoutes);

        return model;
    }

    @GetMapping("/route/{id}")
    public ModelAndView viewSingleRoute(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes redir) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "route");

        Route route = RouteDAO.getInstance().selectRouteById(id);

        if (route == null) {
            redir.addFlashAttribute("modal", "Route does not exist!");
            return new ModelAndView("redirect:/");
        }

        ArrayList<Post> routePosts = new ArrayList<Post>( PostDAO.getInstance().selectPostsByRouteId(route.getId()).values() );
        
//        HashMap<Integer,String> routeUsers = new HashMap<><>();
        
//        List< T > asd = new ArrayList<Object>(); 
        
//        for(Post post: routePosts){
//           if( routeUsers.containsKey(post.getUser_id()) )
//        }
//        
        HashMap<Integer,String> usernamesMap =  JavaData.getUsernamesFromPosts(routePosts);
        
        ArrayList<Participant> routeParticipants = new ArrayList<Participant>( ParticipantDAO.getInstance().selectParticipantById(route.getId()).values() ); 
        HashMap<Integer,String> participantsUsernamesMap =  JavaData.getUsernamesFromParticipants(routeParticipants);
        
        
        
//          routeUsers = JavaData.addUsernames(routeUsers,);
        
        model.addObject("aRoute", route);
        model.addObject("routePosts", routePosts);
        model.addObject("usernamesMap", usernamesMap);
        model.addObject("participantsUsernamesMap", participantsUsernamesMap);

        return model;
    }

    @GetMapping("/addroute")
    public ModelAndView getAddRoute(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "addroute");

        return model;
    }

    @PostMapping("/addroute")
    public ModelAndView postAddRoute(Route route, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        RouteDAO routeDAO = RouteDAO.getInstance();

        if (routeDAO.createRoute(route) != 0) {
            return new ModelAndView("redirect:/login");
        } else {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/editroute{id}")
    public ModelAndView getEditRoute(@PathVariable("id") int id, Route updatedRoute, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        System.out.println(id);
        Route routeToEdit = RouteDAO.getInstance().getRouteById(id);

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "editrouteform");
        model.addObject("routeToEdit", routeToEdit);

        return model;
    }

    @PostMapping("/updateroute")
    public ModelAndView postEditRoute(@ModelAttribute("updatedRoute") Route updatedRoute, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        System.out.println(updatedRoute.getId());
        int updated = RouteDAO.getInstance().updateRoute(updatedRoute);

        return new ModelAndView("redirect:/allroutes");
    }

    @GetMapping("/deleteroute{id}")
    public ModelAndView postDeleteUser(@ModelAttribute("userToDelete") Route routeToDelete, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        int updated = RouteDAO.getInstance().deleteRoute(routeToDelete);

        return new ModelAndView("redirect:/allroutes");
    }

}
