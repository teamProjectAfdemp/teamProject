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
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ParticipantController {

    User curUser;
    Route curRoute;
    
    
    @GetMapping("/getparticipants{id}")
    public ModelAndView getParticipants(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes redir) {
        String buttonState = "";
        
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("empty");
        }
        
        ArrayList<Integer> routeParticipants = ParticipantDAO.getInstance().selectParticipantById(id);
        HttpSession session = session();
        curUser = (User) session.getAttribute("curUser");
        curRoute = (Route) session.getAttribute("route"+id);

        if (routeParticipants.contains(curUser.getId())) buttonState = "EXIT";    
        else buttonState = ( routeParticipants.size() < curRoute.getSeats() ) ? "JOIN" : "FULL";
        
        session.setAttribute("buttonState"+id , buttonState);

        ModelAndView model = new ModelAndView("viewParticipants");
        model.addObject("routeParticipants", routeParticipants);
        model.addObject("buttonState", buttonState);

        return model;
    }
    

    @GetMapping("/postparticipants{id}")
    public ModelAndView postParticipants(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes redir) {
        
        HttpSession session = session();
        curUser = (User) session.getAttribute("curUser");
        String buttonState = (String) session.getAttribute("buttonState"+id);
        
        int actionDone = 0;
        if (buttonState.equals("JOIN")) {
            actionDone = ParticipantDAO.getInstance().createParticipant(id, curUser.getId());
        }
        if (buttonState.equals("EXIT")) {
            actionDone = ParticipantDAO.getInstance().deleteParticipant(id, curUser.getId());
        }

        redir.addFlashAttribute("actionDone", actionDone);

        return new ModelAndView("forward:/getparticipants" + id);
    }

//    @RequestMapping("/allparticipants")
//    public ModelAndView getAllParticipants(HttpServletRequest request) {
//
//        // if user's cookie does not match got to login page!
//        if (!(CookieHandler.validateCookie(request.getCookies()))) {
//            return new ModelAndView("redirect:/");
//        }
//
//        ModelAndView model = new ModelAndView("template");
//        model.addObject("includeView", "viewParticipants");
//
//        ArrayList<Participant> allParticipants = new ArrayList<>();
//
////        ParticipantDAO participantDAO = ParticipantDAO.getInstance();
////        HashMap<Integer, Participant> allPArticipantsMap = participantDAO.selectAllparticipants();
////
////        allPArticipantsMap.forEach((k, v) -> allParticipants.add(v));  
//        model.addObject("allParticipants", allParticipants);
//
//        return model;
//    }

//    @GetMapping("/addparticipant")
//    public ModelAndView getAddParticipant(HttpServletRequest request) {
//
//        // if user's cookie does not match got to login page!
//        if (!(CookieHandler.validateCookie(request.getCookies()))) {
//            return new ModelAndView("redirect:/");
//        }
//
//        ModelAndView model = new ModelAndView("template");
//        model.addObject("includeView", "addparticipant");
//
//        return model;
//    }
//
//    @GetMapping("/participants/{id}")
//    public ModelAndView getRouteParticipants(@PathVariable("id") int id, HttpServletRequest request) {
//        // if user's cookie does not match got to login page!
//        if (!(CookieHandler.validateCookie(request.getCookies()))) {
//            return new ModelAndView("empty");
//        }
//
//        ArrayList<Integer> routeParticipants = ParticipantDAO.getInstance().selectParticipantById(id);
//
//        ModelAndView model = new ModelAndView("viewParticipants");
//        model.addObject("routeParticipants", routeParticipants);
//
//        return model;
//    }

//    @GetMapping("/join{id}")
//    public ModelAndView getJoin(@PathVariable("id") int id, HttpServletRequest request) {
//        int joined = 0;
//        // if user's cookie does not match got to login page!
//        if ((CookieHandler.validateCookie(request.getCookies()))) {
//            curUser = (User) session().getAttribute("curUser");
//            joined = ParticipantDAO.getInstance().createParticipant(id, curUser.getId());
//        }
//        return new ModelAndView("empty");
//    }

//    @GetMapping("/exit{id}")
//    public ModelAndView getExit(@PathVariable("id") int id, HttpServletRequest request) {
//        int exit = 0;
//        // if user's cookie match exit the route!
//        if ((CookieHandler.validateCookie(request.getCookies()))) {
//            curUser = (User) session().getAttribute("curUser");
//            exit = ParticipantDAO.getInstance().deleteParticipant(id, curUser.getId());
//        }
//        return new ModelAndView("empty");
//    }

    

}
