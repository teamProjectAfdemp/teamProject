package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.User;
import com.teamproject.db.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WelcomeController {
    User curUser;

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    @RequestMapping({"/", "/index"})
    public ModelAndView welcome(User user, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("redirect:/login");
        return model;
    }

    @GetMapping("/login")
    public ModelAndView loginGet(User user, HttpServletRequest request) {
        // if user's cookie does not match got to login page!
        if (request.getCookies() != null) {
            return new ModelAndView((CookieHandler.validateCookie(request.getCookies())) ? "redirect:/profile" : "login");
        } else {
            return new ModelAndView("login");
        }
    }

    @PostMapping("/login")
    public ModelAndView loginPost(User user, HttpServletRequest request, RedirectAttributes redir) {
        ModelAndView model;
        // if credentials are not correct refresh
        UserDAO userDao = UserDAO.getInstance();
        int userId = userDao.checkUsernamePassword(user.getUsername(), user.getPassword());
        if (userId == 0) {
            redir.addFlashAttribute("modal", "Wrong username or password!");
            return new ModelAndView("redirect:/login");
        }
        // if cannot Validate Cookie refresh!
        if (!CookieHandler.validateCookie(userId, request.getCookies())) {
            redir.addFlashAttribute("modal", "Authentication failed!");
            return new ModelAndView("redirect:/login");
        }
        curUser = new User();
        curUser.setId(userId);
        HttpSession session = session();
        userDao.setUser(curUser);
        session.setAttribute("curUser", curUser);
        model = new ModelAndView("redirect:/allroutes");
        redir.addFlashAttribute("modal", "Logged in succesfully!");
        return model;
    }

    @GetMapping("/signup")
    public ModelAndView signUpPost(User user, HttpServletRequest request) {
        // if user's cookie does not match got to login page!
        return new ModelAndView((CookieHandler.validateCookie(request.getCookies())) ? "redirect:/profile" : "register");
    }

    @PostMapping("/signup")
    public ModelAndView signUp(User user, HttpServletRequest request, RedirectAttributes redir) {
        // if user's cookie does not match got to login page!
        if ((CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/profile");
        }
        UserDAO userDao = UserDAO.getInstance();
        // if user exists reload page!
        if (userDao.checkUser(user.getUsername()) != 0) {
            redir.addFlashAttribute("modal", "Username " + user.getUsername() + " already exists");
            return new ModelAndView("redirect:/signup");
        }
        // if user is created go to login page
        if (userDao.createUser(user.getUsername(), user.getPassword(), user.getFname(), user.getLname()) != 0) {
            redir.addFlashAttribute("modal", "User " + user.getUsername() + " successfully created! \n Please log in!");
            return new ModelAndView("redirect:/login");
        } else {
            redir.addFlashAttribute("modal", "An error occured. Please try again!");
            return new ModelAndView("error");
        }
    }

    @GetMapping("/logout")
    public ModelAndView logOut(HttpServletRequest request) {
        // remove cookie if present!
        CookieHandler.removeCookie(request.getCookies());
        return new ModelAndView("redirect:/login");
    }
}
