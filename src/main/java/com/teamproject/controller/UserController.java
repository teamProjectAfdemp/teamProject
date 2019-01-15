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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    User curUser;
    
    @GetMapping("/profile")
    public ModelAndView userProfile() {
        // if no user is logged in go to welcome page!
        // else go to profile
        return new ModelAndView( (session().getAttribute("curUser") != null)? "profile": "redirect:/");
    }
    
    
    @GetMapping("/allusers")
    public ModelAndView getAllUsers() {
        // if no user is logged in go to welcome page!
        if (session().getAttribute("curUser") == null) 
            return new ModelAndView("redirect:/");
        
        ModelAndView model = new ModelAndView("viewUsers");
        
        ArrayList<User> allUsers = new ArrayList<>();

        UserDAO userDAO = UserDAO.getInstance();
        HashMap<Integer, User> allUsersMap = userDAO.selectAllUsers();

        allUsersMap.forEach((k, v) -> allUsers.add(v));

        model.addObject("allUsers", allUsers);

        return model;
    }
    
    @RequestMapping(value = "/edituser/{id}", method=RequestMethod.GET)
    public ModelAndView getEditUser(@PathVariable("id") String id) {
        
        if (session().getAttribute("curUser") == null) 
            return new ModelAndView("redirect:/");
        
        System.out.println("THE ID IS " + id);
        User UserToEdit =  UserDAO.getInstance().getUserById( Integer.getInteger(id) );
         
        System.out.println("USER TO EDIT" + UserToEdit);
        ModelAndView model = new ModelAndView("edituser");
        model.addObject("UserToEdit",UserToEdit);
        
        return model;
    }
    
    @RequestMapping(value = "/edituser/{id}", method=RequestMethod.POST)
    public ModelAndView postEditUser(@PathVariable("id") String id, User user){
        
        if (session().getAttribute("curUser") == null) 
            return new ModelAndView("redirect:/");
        
        int updated = UserDAO.getInstance().updateUser(user);

        return new ModelAndView("redirect:/allusers");
    }
}
