package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.RouteDAO;
import java.util.ArrayList;
import java.util.HashMap;

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
}
