package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    User users = new User();
    User curUser;
//        public ArrayList<User> allUsers  = new ArrayList<>();

    @GetMapping("/login")
    public ModelAndView loginGet(User user) {
        HttpSession session = session();
        curUser = (User) session.getAttribute("curUser");
        if (curUser != null) {
            return new ModelAndView("forward:/profile");
        }
        return new ModelAndView("login");
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
        model = new ModelAndView("forward:/profile");
        // user bean will be automatically binded to view . refer @ModelAttribute

        return model;
    }

    @GetMapping("/signup")
    public ModelAndView signUp(User user) {
        return new ModelAndView("error");
    }

    @GetMapping("/logout")
    public ModelAndView logOut() {
        HttpSession session = session();
        session.setAttribute("curUser", null);
        return new ModelAndView("chatup");
    }

    @PostMapping("/register")
    public ModelAndView create(User user) {
        ModelAndView model = new ModelAndView("view");
        // user bean will be automatically binded to view . refer @ModelAttribute

        users.setFname(user.getFname());
        users.setLname(user.getLname());
        users.setUsername(user.getUsername());
//			users.setPassword(user.getPassword());
        return model;
    }

    @GetMapping("/register")
    public ModelAndView viewData(User user) {

        ModelAndView model = new ModelAndView("registeruser");
        return model;
    }
    
    
    @GetMapping("/profile")
    public ModelAndView userProfile() {
        ModelAndView model = new ModelAndView("profile");
        return model;
    }
    
    
    @GetMapping("/allusers")
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView("viewUsers");

        ArrayList<User> allUsers = new ArrayList<>();

        UserDAO userDAO = UserDAO.getInstance();
        HashMap<Integer, User> allUsersMap = userDAO.selectAllUsers();

        allUsersMap.forEach((k, v) -> allUsers.add(v));

        model.addObject("allUsers", allUsers);

        return model;
    }
}
