package com.teamproject.controller;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.ParticipantDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
