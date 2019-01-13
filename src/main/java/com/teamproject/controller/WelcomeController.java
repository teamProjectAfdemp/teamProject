package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.User;
import com.teamproject.db.UserDAO;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class WelcomeController {

    User curUser;

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    @GetMapping( {"/","/index"} )
    public ModelAndView welcome(User user) {
        ModelAndView model = new ModelAndView("welcome");
        String includedLinks;
        
        // if user is not logged in return log in and sign up
        // if user is logged in return log out!
        includedLinks = (session().getAttribute("curUser") == null) ? "welcomeLogin" : "welcomeLogout";
        // add the included file name as attribute to the ModelView
        model.addObject("welcomeInclude", includedLinks);

        return model;
    }

    @GetMapping("/login")
    public ModelAndView loginGet(User user) {

        return new ModelAndView( (session().getAttribute("curUser") == null)? "login" :"redirect:/profile" );
    }

    @PostMapping("/login")
    public ModelAndView loginPost(User user) {

        ModelAndView model;
        UserDAO userDao = UserDAO.getInstance();
        int userId = userDao.checkUsernamePassword(user.getUsername(), user.getPassword());

        if (userId == 0) {
            return new ModelAndView("login");
        }

        curUser = new User();
        curUser.setId(userId);
        HttpSession session = session();
        userDao.setUser(curUser);
        session.setAttribute("curUser", curUser);
        model = new ModelAndView("redirect:/profile");
        // user bean will be automatically binded to view . refer @ModelAttribute

        return model;
    }

    @GetMapping("/signup")
    public ModelAndView signUpPost(User user) {
        ModelAndView model = new ModelAndView("register");
        return model;
    }

    @PostMapping("/signup")
    public ModelAndView signUp(User user) {

        UserDAO userDao = UserDAO.getInstance();
        // if user exists reload page!
       if  (userDao.checkUser(user.getUsername()) != 0) 
           return new ModelAndView("redirect:/signup");
        // if user is created go to login page
       if (userDao.createUser(user.getUsername(), user.getPassword(), user.getFname(), user.getLname()) != 0)
           return new ModelAndView("redirect:/login");
       else return new ModelAndView("error");
    }

    @GetMapping("/logout")
    public ModelAndView logOut() {
        HttpSession session = session();
        session.setAttribute("curUser", null);
        return new ModelAndView("redirect:/");
    }
}
