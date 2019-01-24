package com.teamproject.controller;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Post;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.ParticipantDAO;
import com.teamproject.db.PostDAO;
import com.teamproject.db.RouteDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
     @GetMapping("/participants/{id}")
    public ModelAndView getRouteParticipants(@PathVariable("id") int id, HttpServletRequest request){
         // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
        
        ArrayList<Participant> routeParticipants = new ArrayList<>(ParticipantDAO.getInstance().selectParticipantById(id).values());   
        
        ModelAndView model =  new ModelAndView("viewParticipants");
        model.addObject("routeParticipants", routeParticipants);
        
        return model;
    }
    
     @GetMapping("/join{id}")
    public ModelAndView getJoin(@PathVariable("id") int id, HttpServletRequest request) { 
        int joined =0;
        // if user's cookie does not match got to login page!
        if ((CookieHandler.validateCookie(request.getCookies()))) {
           curUser = (User) session().getAttribute("curUser");
           joined = ParticipantDAO.getInstance().createParticipant(id, curUser.getId());
        }
        return new ModelAndView("empty");
    }
    
     @GetMapping("/exit{id}")
    public ModelAndView getExit(@PathVariable("id") int id, HttpServletRequest request) { 
        int exit = 0;
        // if user's cookie match exit the route!
        if ((CookieHandler.validateCookie(request.getCookies()))) {
           curUser = (User) session().getAttribute("curUser");
           exit = ParticipantDAO.getInstance().deleteParticipant(id, curUser.getId());
        }
        return new ModelAndView("empty");
    }
}
