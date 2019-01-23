package com.teamproject.controller;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import com.teamproject.db.PostDAO;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.ParticipantDAO;
import com.teamproject.db.RouteDAO;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@MultipartConfig(maxFileSize = 16177215)
public class RouteController {

    User curUser;

    @RequestMapping("/allroutes")
    public ModelAndView getAllRoutes(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewRoutesAjax");

        model.addObject("routesList", RouteDAO.getInstance().getRoutesIdsList());

        return model;
    }

//    @RequestMapping("/ajaxroutelist")
//    public @ResponseBody
//    ArrayList<Integer> getRouteList(HttpServletResponse response, HttpServletRequest request) {
//
//        // if user's cookie does not match got to login page!
//        if (!(CookieHandler.validateCookie(request.getCookies()))) {
//            return new ArrayList<Integer>();
//        }
//
//        response.setContentType("application/json");
//        return RouteDAO.getInstance().getRoutesIdsList();
//    }

    @RequestMapping("/allcreatedroutes")
    public ModelAndView getAllJoinedRoutes(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewRoutesAjax");

        curUser = (User) session().getAttribute("curUser");

        model.addObject("routesList", RouteDAO.getInstance().selectCreatedRoutesIds(curUser.getId()));

        return model;
    }

    @RequestMapping("/alljoinedroutes")
    public ModelAndView getAllCreatedRoutes(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "viewRoutesAjax");

        curUser = (User) session().getAttribute("curUser");

        model.addObject("routesList", RouteDAO.getInstance().selectJoinedRoutesIds(curUser.getId()));

        return model;
    }

    @GetMapping("/route/{id}")
    public ModelAndView viewSingleRoute(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes redir) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "route");

        // Select route
        Route route = RouteDAO.getInstance().selectRouteById(id);

        if (route == null) {
            redir.addFlashAttribute("modal", "Route does not exist!");
            return new ModelAndView("redirect:/");
        }

        // get route participants and posts
        ArrayList<Participant> routeParticipants = new ArrayList<>(ParticipantDAO.getInstance().selectParticipantById(route.getId()).values());
        ArrayList<Post> routePosts = new ArrayList<>(PostDAO.getInstance().selectPostsByRouteId(route.getId()).values());

        model.addObject("aRoute", route);
        model.addObject("routePosts", routePosts);
        model.addObject("routeParticipants", routeParticipants);

        HttpSession session = session();
        if (session.getAttribute("usernamesMap") == null) {
            session.setAttribute("usernamesMap", UserDAO.getInstance().getidUsernamesMap());
        }

        return model;
    }

    @GetMapping("/ajaxroute/{id}")
    public ModelAndView getRouteAjax(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes redir) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) return new ModelAndView("redirect:/");

        Route route = RouteDAO.getInstance().getRouteById(id);

        ModelAndView model = new ModelAndView("viewSingleRoute");
        model.addObject("route", route);
        return model;
    }

    @GetMapping("/addroute")
    public ModelAndView getAddRoute(HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "addroute");
        Route route = new Route();
        model.addObject("route", route);

        return model;
    }

    @PostMapping("/addroute")
    public ModelAndView postAddRoute(@ModelAttribute("route") Route route, @ModelAttribute("file") MultipartFile file, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) return new ModelAndView("redirect:/");
        // create the new route and upload the file
        int addedRoute = RouteDAO.getInstance().createRoute(route, file); 
        
        return new ModelAndView( (addedRoute != 0)? "redirect:/allroutes": "error");

    }

    @GetMapping("/editroute{id}")
    public ModelAndView getEditRoute(@PathVariable("id") int id, Route updatedRoute, HttpServletRequest request) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }
        
        Route routeToEdit = RouteDAO.getInstance().getRouteById(id);

        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "editrouteform");
        model.addObject("routeToEdit", routeToEdit);

        return model;
    }

    @PostMapping("/updateroute")
    public ModelAndView postEditRoute(@ModelAttribute("updatedRoute") Route updatedRoute, HttpServletRequest request, RedirectAttributes redir) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) return new ModelAndView("redirect:/");

        System.out.println(updatedRoute.getId());
        int updated = RouteDAO.getInstance().updateRoute(updatedRoute);
        if (updated>0) redir.addFlashAttribute("modal", "Route updated!");

        return new ModelAndView("redirect:/allroutes");
    }

    @GetMapping("/deleteroute{id}")
    public ModelAndView postDeleteUser(@ModelAttribute("userToDelete") Route routeToDelete, HttpServletRequest request, RedirectAttributes redir) {

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) return new ModelAndView("redirect:/");
        
        curUser = (User) session().getAttribute("curUser");
        // if user is not admin go to root!
        if (!curUser.getUsername().equals("admin")) return new ModelAndView("redirect:/");
        
        // NEED TO DELETE POSTS AND PARTICIPANTS BEFORE DELETING THE ROUTE
        int deleted = RouteDAO.getInstance().deleteRoute(routeToDelete);
        if (deleted>0) redir.addFlashAttribute("modal", "Route deleted!");
        
        return new ModelAndView("redirect:/allroutes");
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }
      
    @PostMapping("/join{id}")
    public ModelAndView postJoin(@PathVariable("id") int id, Route route, HttpServletRequest request) {

        ModelAndView model = new ModelAndView("redirect:/route/"+id);

        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) {
            return new ModelAndView("redirect:/");
        }
//        curUser = (User) session().getAttribute("curUser");
        ParticipantDAO participantDao = ParticipantDAO.getInstance();
        curUser = (User) session().getAttribute("curUser");
      
        if ( participantDao.checkParticipant(id, curUser.getId()) ) return model;
        ParticipantDAO.getInstance().createParticipant(route, curUser);

        return model;
    }
}
