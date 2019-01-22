package com.teamproject.controller;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import com.teamproject.db.ParticipantDAO;
import com.teamproject.db.RouteDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ParticipantController {
    
    User curUser;

    @RequestMapping("/allparticipants")
    public ModelAndView getAllParticipants(HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
        

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewParticipants");

        ArrayList<Participant> allParticipants = new ArrayList<>();

//        ParticipantDAO participantDAO = ParticipantDAO.getInstance();
//        HashMap<Integer, Participant> allPArticipantsMap = participantDAO.selectAllparticipants();
//
//        allPArticipantsMap.forEach((k, v) -> allParticipants.add(v));  
        model.addObject("allParticipants", allParticipants);

        return model;
    }    
    
    @GetMapping("/addparticipant")
    public ModelAndView getAddParticipant(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "addparticipant");

        return model;
    }

    @PostMapping("/addparticipant")
    public ModelAndView postAddParticipant(Route route, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        RouteDAO routeDAO = RouteDAO.getInstance();

//        if (routeDAO.createRoute(route) != 0) {
//            return new ModelAndView("redirect:/login");
//        } else {
//            
//        }
        return new ModelAndView("error");
    }
}
