package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    User curUser;

    @GetMapping("/profile")
    public ModelAndView userProfile() {
        // if no user is logged in go to welcome page!
        // else go to profile
        if (session().getAttribute("curUser") == null) return new ModelAndView("redirect:/");

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "route");
        return model;
    }


    @GetMapping("/allusers")
    public ModelAndView getAllUsers(User user) {
        // if no user is logged in go to welcome page!
        if (session().getAttribute("curUser") == null)
            return new ModelAndView("redirect:/");

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewUsers");

        ArrayList<User> allUsers = new ArrayList<>();

        UserDAO userDAO = UserDAO.getInstance();
        HashMap<Integer, User> allUsersMap = userDAO.selectAllUsers();

        allUsersMap.forEach((k, v) -> allUsers.add(v));

        model.addObject("allUsers", allUsers);

        return model;
    }

    @GetMapping("/edituser{id}")
    public ModelAndView getEditUser(@PathVariable("id") int id, User updatedUser) {

        if (session().getAttribute("curUser") == null)
            return new ModelAndView("redirect:/");

        System.out.println(id);
        User userToEdit =  UserDAO.getInstance().getUserById( id );

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "edituserform");
        model.addObject("userToEdit",userToEdit);

        return  model;
    }



    @PostMapping("/updateuser")
    public ModelAndView postEditUser(@ModelAttribute("updatedUser")User updatedUser){

        if (session().getAttribute("curUser") == null)
            return new ModelAndView("redirect:/");

        System.out.println(updatedUser.getId());
        System.out.println(updatedUser.getUsername());
        int updated = UserDAO.getInstance().updateUser(updatedUser);

        return new ModelAndView("redirect:/allusers");
    }

    @GetMapping("/deleteuser{id}")
    public ModelAndView postDeleteUser(@ModelAttribute("userToDelete")User userToDelete){

        if (session().getAttribute("curUser") == null)
            return new ModelAndView("redirect:/");

        int updated = UserDAO.getInstance().deleteUser(userToDelete);

        return new ModelAndView("redirect:/allusers");
    }
    
     @GetMapping("/disableuser{id}")
    public ModelAndView getDisableUser(@ModelAttribute("userToDisable")User userToDisable){

        if (session().getAttribute("curUser") == null)
            return new ModelAndView("redirect:/");
        
        // NOT YET IMPLEMENTED ON DB
//        int updated = UserDAO.getInstance().disableUser(userToDisable);

        return new ModelAndView("redirect:/allusers");
    }

}
