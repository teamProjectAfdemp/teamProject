package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Route;
import com.teamproject.bean.User;
import static com.teamproject.controller.WelcomeController.session;
import com.teamproject.db.RouteDAO;
import com.teamproject.db.UserDAO;
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
        HttpSession session = session();
       
        if (route == null) {
            redir.addFlashAttribute("modal", "Route does not exist!");
            return new ModelAndView("redirect:/");
        }
        model.addObject("aRoute", route);

        session.setAttribute("route"+id, route);

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
        curUser = (User) session().getAttribute("curUser");
        if (routeToEdit.getCreator_id() != curUser.getId()) return new ModelAndView("redirect:/allroutes");
        
        ModelAndView model = new ModelAndView("template");
        model.addObject("includeView", "editrouteform");
        model.addObject("routeToEdit", routeToEdit);

        return model;
    }

    @PostMapping("/updateroute")
    public ModelAndView postEditRoute(@ModelAttribute("updateRoute") Route updateRoute, HttpServletRequest request, RedirectAttributes redir) {
        // if user's cookie does not match got to login page!
        if (!(CookieHandler.validateCookie(request.getCookies()))) return new ModelAndView("redirect:/");
        
        int updated = RouteDAO.getInstance().updateRoute(updateRoute);
        if (updated>0) redir.addFlashAttribute("modal", "Route updated!");

        return new ModelAndView("redirect:/allroutes");
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }   
}
