package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edituser");
        return modelAndView;
    }
}
