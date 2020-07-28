package test.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.users.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("login")
    public String loginGet(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Username or password gavno");
        }
        if(logout != null){
            model.addAttribute("message", "Logged out ok");
        }

        return "login";
    }


    @PostMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}