package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.RouteDAO;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    User curUser;
    
    @GetMapping("/allroutes")
    public ModelAndView getAllRoutes() {
        // if no user is logged in go to welcome page!
        if (session().getAttribute("curUser") == null) 
            return new ModelAndView("redirect:/");
        
        ModelAndView model = new ModelAndView("viewRoutes");
        
        ArrayList<Route> allRoutes = new ArrayList<>();
        
        RouteDAO routeDAO =  RouteDAO.getInstance();
        HashMap<Integer, Route> allRoutesMap = routeDAO.selectAllRoutes();

        allRoutesMap.forEach((k, v) -> allRoutes.add(v));

        model.addObject("allRoutes", allRoutes);

        return model;
    }
    
    @GetMapping("/addroute")
    public ModelAndView signUpPost(User user) {
        ModelAndView model = new ModelAndView("addroute");
        return model;
    }
    
    @PostMapping("/addroute")
    public ModelAndView signUp(Route route) {

        RouteDAO routeDAO = RouteDAO.getInstance();
        UserDAO userDao = UserDAO.getInstance();
//         if user exists reload page!
//       if  (userDao.checkUser(curUser.getUsername()) != 0) 
//           return new ModelAndView("redirect:/signup");
//         if user is created go to login page
       if (routeDAO.createRoute(route) != 0)
           return new ModelAndView("redirect:/login");
       else return new ModelAndView("error");
    }
}
