package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Users;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    public Users users = new Users();
//        public ArrayList<User> allUsers  = new ArrayList<>();

    @PostMapping("/register")
    public ModelAndView create(Users user) {
        ModelAndView model = new ModelAndView("view");
        // user bean will be automatically binded to view . refer @ModelAttribute

        users.setFname(user.getFname());
        users.setLname(user.getLname());
        users.setUsername(user.getUsername());
//			users.setPassword(user.getPassword());
        return model;
    }

    @GetMapping("/register")
    public ModelAndView viewData(Users user) {

        ModelAndView model = new ModelAndView("registeruser");
        return model;
    }

    @GetMapping("/allusers")
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView("viewUsers");

        ArrayList<Users> allUsers = new ArrayList<>();

        UserDAO userDAO = UserDAO.getInstance();
        HashMap<Integer, Users> allUsersMap = userDAO.selectAllUsers();

        allUsersMap.forEach((k, v) -> allUsers.add(v));

        model.addObject("allUsers", allUsers);

        return model;
    }
}
