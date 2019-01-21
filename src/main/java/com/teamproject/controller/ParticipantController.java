package com.teamproject.controller;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.ParticipantDAO;
import com.teamproject.db.RouteDAO;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public class ParticipantController {
    
    User curUser;

    @RequestMapping("/allparticipants")
    public ModelAndView getAllParticipants(HttpServletRequest request) {
        
        // if user's cookie does not match got to login page!
        if ( !(CookieHandler.validateCookie(request.getCookies())) ) return new ModelAndView("redirect:/");
        

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewParticipants");

        ArrayList<Participant> allParticipants = new ArrayList<>();

        ParticipantDAO participantDAO = ParticipantDAO.getInstance();
        HashMap<Integer, Participant> allPArticipantsMap = participantDAO.selectAllparticipants();

        allPArticipantsMap.forEach((k, v) -> allParticipants.add(v));

        model.addObject("allRoutes", allParticipants);

        return model;
    }    
}
